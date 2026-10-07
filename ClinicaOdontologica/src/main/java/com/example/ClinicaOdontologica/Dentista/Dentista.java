package com.example.ClinicaOdontologica.Dentista;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "dentistas")
@Getter
@Setter
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String cro;

    private String cpf;

    private String nome;

    private String email;

    private String telefone;

    private UUID idEspecialidade;


    public Dentista() {

    }

    public Dentista(
            String cro,
            String cpf,
            String nome,
            String email,
            String telefone,
            UUID idEspecialidade
    ) {
        this.cro = cro;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idEspecialidade = idEspecialidade;
    }
}
