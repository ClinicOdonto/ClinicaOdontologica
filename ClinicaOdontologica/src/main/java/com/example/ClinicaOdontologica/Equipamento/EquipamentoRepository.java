package com.example.ClinicaOdontologica.Equipamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipamentoRepository extends JpaRepository<Equipamento, UUID> {
}
