package com.example.ClinicaOdontologica.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class ConsultaEquipamentoId implements Serializable {

    private UUID idConsulta;

    private UUID idEquipamento;

    public ConsultaEquipamentoId() {
    }

    public ConsultaEquipamentoId(UUID idConsulta, UUID idEquipamento) {
        this.idConsulta = idConsulta;
        this.idEquipamento = idEquipamento;
    }

    public UUID getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(UUID idConsulta) {

        this.idConsulta = idConsulta;
    }

    public UUID getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(UUID idEquipamento) {

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