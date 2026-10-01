package com.example.ClinicaOdontologica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idPaciente;

    private String diagnostico;

    private String tratamento;

    private LocalDate dataRegistro;

    private String observacao;

    public Prontuario() {
    }

    public Prontuario(
            Integer idPaciente,
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

    public Integer getId() {
        return id;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
