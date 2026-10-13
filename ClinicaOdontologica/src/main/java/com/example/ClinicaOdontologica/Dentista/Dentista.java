package com.example.ClinicaOdontologica.Dentista;

import com.example.ClinicaOdontologica.Especialidade.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "dentistas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn (name = "id_especialidade")

    private Especialidade especialidade;

    private String cro;

    private String cpf;

    private String nome;

    private String email;

    private String telefone;


    public Dentista(
            Especialidade especialidade,
            String cro,
            String cpf,
            String nome,
            String email,
            String telefone
    ) {
        this.especialidade = especialidade;
        this.cro = cro;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
}
