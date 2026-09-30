package com.example.ClinicaOdontologica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idConsulta;

    private Integer idRecepcionista;

    private BigDecimal valor;

    private LocalDate dataPag;

    private String formaPagamento;

    private String status;

    public Pagamento() {
    }

    public Pagamento(
            Integer idConsulta,
            Integer idRecepcionista,
            BigDecimal valor,
            LocalDate dataPag,
            String formaPagamento,
            String status
    ) {
        this.idConsulta = idConsulta;
        this.idRecepcionista = idRecepcionista;
        this.valor = valor;
        this.dataPag = dataPag;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Integer getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(Integer idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataPag() {
        return dataPag;
    }

    public void setDataPag(LocalDate dataPag) {
        this.dataPag = dataPag;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
