package com.example.ClinicaOdontologica.Consulta;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "consultas")
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate data;

    private LocalTime hora;

    private String observacoes;

    private String status;

    private UUID idRecepcionista;

    private UUID idDentista;

    private UUID idPaciente;

    public Consulta() {
    }

    public Consulta(
            LocalDate data,
            LocalTime hora,
            String observacoes,
            String status,
            UUID idRecepcionista,
            UUID idDentista,
            UUID idPaciente
    ) {
        this.data = data;
        this.hora = hora;
        this.observacoes = observacoes;
        this.status = status;
        this.idRecepcionista = idRecepcionista;
        this.idDentista = idDentista;
        this.idPaciente = idPaciente;
    }
}