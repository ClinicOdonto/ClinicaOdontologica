package com.example.ClinicaOdontologica.Equipamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "equipamento")
@Getter
@Setter
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String marca;

    private LocalDate validade;

    private BigDecimal custo;

    private UUID idCategoria;

    public Equipamento() {
    }

    public Equipamento(
            String nome,
            String marca,
            LocalDate validade,
            BigDecimal custo,
            UUID idCategoria
    ) {
        this.nome = nome;
        this.marca = marca;
        this.validade = validade;
        this.custo = custo;
        this.idCategoria = idCategoria;
    }
}
