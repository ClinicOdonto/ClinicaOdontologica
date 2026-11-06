package com.example.ClinicaOdontologica.Documento;

import com.example.ClinicaOdontologica.Paciente.Paciente;
import com.example.ClinicaOdontologica.Paciente.PacienteRepository;
import com.example.ClinicaOdontologica.Prontuario.Prontuario;
import com.example.ClinicaOdontologica.Prontuario.ProntuarioRepository;
import com.example.ClinicaOdontologica.service.SupabaseS3Service;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.io.IOException;

import java.util.UUID;

@Service
public class ServiceDocumento {

    private final RepositoryDocumento repositoryDocumento;
    private final PacienteRepository repositoryPaciente;
    private final ProntuarioRepository repositoryProntuario;
    private final SupabaseS3Service supabaseS3Service;

    public ServiceDocumento(
            RepositoryDocumento repositoryDocumento,
            PacienteRepository repositoryPaciente,
            ProntuarioRepository repositoryProntuario,
            SupabaseS3Service supabaseS3Service
    ) {
        this.repositoryDocumento = repositoryDocumento;
        this.repositoryPaciente = repositoryPaciente;
        this.repositoryProntuario = repositoryProntuario;
        this.supabaseS3Service = supabaseS3Service;
    }

    public Documento salvarDocumento(
            UUID idPaciente,
            UUID idProntuario,
            String dente,
            String tipoDocumento,
            String descricao,
            MultipartFile arquivo
    ) throws IOException {

        // 1. Validar paciente e prontuário
        validarPacienteEProntuario(idPaciente, idProntuario);

        // 2. Enviar arquivo para o Supabase
        String chaveStorage = supabaseS3Service.enviarArquivo(arquivo);

        // 3. Criar registro do documento
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

        // 4. Salvar informações no PostgreSQL
        return repositoryDocumento.save(documento);
    }

    public void validarPacienteEProntuario(UUID idPaciente, UUID idProntuario) {

        Paciente paciente = repositoryPaciente.findById(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado."));

        Prontuario prontuario = repositoryProntuario.findById(idProntuario)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado."));

        if (!prontuario.getIdPaciente().equals(paciente.getId())) {
            throw new RuntimeException(
                    "Este prontuário não pertence ao paciente informado."
            );
        }
    }
}