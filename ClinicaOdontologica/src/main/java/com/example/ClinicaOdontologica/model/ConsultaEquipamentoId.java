package com.example.ClinicaOdontologica.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConsultaEquipamentoId implements Serializable {

    private Integer idConsulta;

    private Integer idEquipamento;

    public ConsultaEquipamentoId() {
    }

    public ConsultaEquipamentoId(Integer idConsulta, Integer idEquipamento) {
        this.idConsulta = idConsulta;
        this.idEquipamento = idEquipamento;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Integer idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsultaEquipamentoId)) return false;

        ConsultaEquipamentoId that = (ConsultaEquipamentoId) o;

        return Objects.equals(idConsulta, that.idConsulta)
                && Objects.equals(idEquipamento, that.idEquipamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConsulta, idEquipamento);
    }
}