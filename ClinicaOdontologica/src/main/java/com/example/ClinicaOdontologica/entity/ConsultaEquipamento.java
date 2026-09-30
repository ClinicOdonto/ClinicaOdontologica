package com.example.ClinicaOdontologica.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "consulta_equipamento")
public class ConsultaEquipamento {

    @EmbeddedId
    private ConsultaEquipamentoId id;

    private LocalDate dataUso;

    public ConsultaEquipamento() {
    }

    public ConsultaEquipamento(
            ConsultaEquipamentoId id,
            LocalDate dataUso
    ) {
        this.id = id;
        this.dataUso = dataUso;
    }

    public ConsultaEquipamentoId getId() {
        return id;
    }

    public void setId(ConsultaEquipamentoId id) {
        this.id = id;
    }

    public LocalDate getDataUso() {
        return dataUso;
    }

    public void setDataUso(LocalDate dataUso) {
        this.dataUso = dataUso;
    }
}
