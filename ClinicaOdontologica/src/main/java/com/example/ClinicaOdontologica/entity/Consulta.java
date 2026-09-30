package com.example.ClinicaOdontologica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private LocalTime hora;

    private String observacoes;

    private String status;

    private Long idRecepcionista;

    private Long idDentista;

    private Long idPaciente;

    public Consulta() {
    }

    public Consulta(
            LocalDate data,
            LocalTime hora,
            String observacoes,
            String status,
            Long idRecepcionista,
            Long idDentista,
            Long idPaciente
    ) {
        this.data = data;
        this.hora = hora;
        this.observacoes = observacoes;
        this.status = status;
        this.idRecepcionista = idRecepcionista;
        this.idDentista = idDentista;
        this.idPaciente = idPaciente;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(Long idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }

    public Long getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Long idDentista) {
        this.idDentista = idDentista;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
}