package com.example.ClinicaOdontologica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "dentistas")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cro;

    private String cpf;

    private String nome;

    private String email;

    private String telefone;

    private Integer idEspecialidade;

    private UUID idUsuario;

    public Dentista() {
    }

    public Dentista(
            String cro,
            String cpf,
            String nome,
            String email,
            String telefone,
            Integer idEspecialidade,
            UUID idUsuario
    ) {
        this.cro = cro;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idEspecialidade = idEspecialidade;
        this.idUsuario = idUsuario;
    }

    public Integer getId() {
        return id;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Integer idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }
}
