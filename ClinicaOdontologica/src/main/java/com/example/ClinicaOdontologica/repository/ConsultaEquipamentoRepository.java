package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.entity.ConsultaEquipamento;
import com.example.ClinicaOdontologica.entity.ConsultaEquipamentoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaEquipamentoRepository
        extends JpaRepository<ConsultaEquipamento, ConsultaEquipamentoId> {
}