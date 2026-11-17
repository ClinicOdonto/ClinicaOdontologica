
package com.example.ClinicaOdontologica.Documento;

import com.example.ClinicaOdontologica.Paciente.Paciente;
import com.example.ClinicaOdontologica.Paciente.PacienteRepository;
import com.example.ClinicaOdontologica.Prontuario.Prontuario;
import com.example.ClinicaOdontologica.Prontuario.ProntuarioRepository;
import com.example.ClinicaOdontologica.Storage.SupabaseS3Service;
import com.example.ClinicaOdontologica.Storage.ArmazenamentoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Service
public class ServiceDocumento {

    private static final long TAMANHO_MAXIMO = 10 * 1024 * 1024;

    private static final Set<String> TIPOS_PERMITIDOS = Set.of(
            "application/pdf",
            "image/jpeg",
            "image/png"
    );

    private final RepositoryDocumento repositoryDocumento;
    private final PacienteRepository repositoryPaciente;
    private final ProntuarioRepository repositoryProntuario;
    private final ArmazenamentoService armazenamentoService;

    public ServiceDocumento(
            RepositoryDocumento repositoryDocumento,
            PacienteRepository repositoryPaciente,
            ProntuarioRepository repositoryProntuario,
            ArmazenamentoService armazenamentoService
    ) {
        this.repositoryDocumento = repositoryDocumento;
        this.repositoryPaciente = repositoryPaciente;
        this.repositoryProntuario = repositoryProntuario;
        this.armazenamentoService= armazenamentoService;
    }

    @Transactional
    public Documento salvarDocumento(
            UUID idPaciente,
            UUID idProntuario,
            String dente,
            String tipoDocumento,
            String descricao,
            MultipartFile arquivo
    ) throws IOException {

        validarDados(
                idPaciente,
                idProntuario,
                tipoDocumento,
                arquivo
        );

        validarPacienteEProntuario(idPaciente, idProntuario);

        String chaveStorage = armazenamentoService.enviarArquivo(arquivo);

        try {
            Documento documento = new Documento(
                    idPaciente,
                    idProntuario,
                    dente,
                    tipoDocumento,
                    descricao,
                    arquivo.getOriginalFilename(),
                    chaveStorage,
                    LocalDateTime.now()
            );

            // Força o envio do insert ao banco dentro deste bloco.
            return repositoryDocumento.saveAndFlush(documento);

        } catch (RuntimeException e) {

            try {
                armazenamentoService.excluirArquivo(chaveStorage);
            } catch (RuntimeException erroExclusao) {
                e.addSuppressed(erroExclusao);
            }

            throw e;
        }
    }

    private void validarDados(
            UUID idPaciente,
            UUID idProntuario,
            String tipoDocumento,
            MultipartFile arquivo
    ) {

        if (idPaciente == null || idProntuario == null) {
            throw new IllegalArgumentException(
                    "Paciente e prontuário são obrigatórios."
            );
        }

        if (tipoDocumento == null || tipoDocumento.isBlank()) {
            throw new IllegalArgumentException(
                    "O tipo do documento é obrigatório."
            );
        }

        if (arquivo == null || arquivo.isEmpty()) {
            throw new IllegalArgumentException(
                    "Selecione um arquivo."
            );
        }

        if (arquivo.getSize() > TAMANHO_MAXIMO) {
            throw new IllegalArgumentException(
                    "O arquivo não pode ultrapassar 10 MB."
            );
        }

        String contentType = arquivo.getContentType();

        if (contentType == null ||
                !TIPOS_PERMITIDOS.contains(contentType.toLowerCase())) {

            throw new IllegalArgumentException(
                    "Tipo de arquivo não permitido. Envie PDF, JPEG ou PNG."
            );
        }
    }

    public void validarPacienteEProntuario(
            UUID idPaciente,
            UUID idProntuario
    ) {

        Paciente paciente = repositoryPaciente.findById(idPaciente)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Paciente não encontrado."
                ));

        Prontuario prontuario = repositoryProntuario.findById(idProntuario)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Prontuário não encontrado."
                ));

        if (prontuario.getIdPaciente() == null ||
                !prontuario.getIdPaciente().equals(paciente.getId())) {

            throw new IllegalArgumentException(
                    "O prontuário não pertence ao paciente informado."
            );
        }
    }
}
