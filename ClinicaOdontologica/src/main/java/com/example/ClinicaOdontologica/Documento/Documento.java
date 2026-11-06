package com.example.ClinicaOdontologica.Documento;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "documentos")
@Getter
@Setter
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID idPaciente;

    private UUID idProntuario;

    private String dente;

    private String tipoDocumento;

    private String descricao;

    private String nomeArquivo;

    private String chaveStorage;

    private LocalDateTime dataUpload;

    public Documento() {
    }

    public Documento(
            UUID idPaciente,
            UUID idProntuario,
            String dente,
            String tipoDocumento,
            String descricao,
            String nomeArquivo,
            String chaveStorage,
            LocalDateTime dataUpload
    ) {
        this.idPaciente = idPaciente;
        this.idProntuario = idProntuario;
        this.dente = dente;
        this.tipoDocumento = tipoDocumento;
        this.descricao = descricao;
        this.nomeArquivo = nomeArquivo;
        this.chaveStorage = chaveStorage;
        this.dataUpload = dataUpload;
    }
}