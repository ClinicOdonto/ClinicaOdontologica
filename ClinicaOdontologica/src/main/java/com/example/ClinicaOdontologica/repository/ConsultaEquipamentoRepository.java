package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.model.ConsultaEquipamento;
import com.example.ClinicaOdontologica.model.ConsultaEquipamentoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaEquipamentoRepository
        extends JpaRepository<ConsultaEquipamento, ConsultaEquipamentoId> {
}