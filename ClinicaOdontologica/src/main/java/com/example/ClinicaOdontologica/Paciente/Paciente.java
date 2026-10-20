package com.example.ClinicaOdontologica.Paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String cpf;

    private String nome;

    private LocalDate dataNasc;

    private String telefone;

    private String email;

    private String endereco;


    //    public Paciente(
//            String cpf,
//            String nome,
//            LocalDate dataNasc,
//            String telefone,
//            String email,
//            String endereco
//    ) {
//        this.cpf = cpf;
//        this.nome = nome;
//        this.dataNasc = dataNasc;
//        this.telefone = telefone;
//        this.email = email;
//        this.endereco = endereco;
//        this.idPaciente = UUID.randomUUID();
//    }
}