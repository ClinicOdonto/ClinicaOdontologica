package com.example.ClinicaOdontologica.Prontuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prontuario")
@Getter
@Setter
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID idPaciente;

    private String diagnostico;

    private String tratamento;

    private LocalDate dataRegistro;

    private String observacao;

    public Prontuario() {
    }

    public Prontuario(
            UUID idPaciente,
            String diagnostico,
            String tratamento,
            LocalDate dataRegistro,
            String observacao
    ) {
        this.idPaciente = idPaciente;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.dataRegistro = dataRegistro;
        this.observacao = observacao;
    }
}
