package com.example.ClinicaOdontologica.Recepcionista;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "recepcionistas")
@Getter
@Setter
public class Recepcionista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String cpf;

    private String nome;

    private String telefone;

    private String email;

    private UUID usuarioId;

    public Recepcionista() {
    }

    public Recepcionista(
            String cpf,
            String nome,
            String telefone,
            String email,
            UUID usuarioId
    ) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.usuarioId = usuarioId;
    }
}