package com.example.ClinicaOdontologica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Paciente {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String cpf;
}
