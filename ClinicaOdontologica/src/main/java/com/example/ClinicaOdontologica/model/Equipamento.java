package com.example.ClinicaOdontologica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String marca;

    private LocalDate validade;

    private BigDecimal custo;

    private Integer idCategoria;

    public Equipamento() {
    }

    public Equipamento(
            String nome,
            String marca,
            LocalDate validade,
            BigDecimal custo,
            Integer idCategoria
    ) {
        this.nome = nome;
        this.marca = marca;
        this.validade = validade;
        this.custo = custo;
        this.idCategoria = idCategoria;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
}
