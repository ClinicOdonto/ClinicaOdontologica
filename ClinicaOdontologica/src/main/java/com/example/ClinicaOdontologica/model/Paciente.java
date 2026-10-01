package com.example.ClinicaOdontologica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cpf;

    private String nome;

    private LocalDate dataNasc;

    private String telefone;

    private String email;

    private String endereco;

    private UUID idPaciente;

    public Paciente() {
    }

    public Paciente(
            String cpf,
            String nome,
            LocalDate dataNasc,
            String telefone,
            String email,
            String endereco,
            UUID idPaciente
    ) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.idPaciente = idPaciente;
    }

    public Integer getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public UUID getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(UUID idPaciente) {
        this.idPaciente = idPaciente;
    }
}
