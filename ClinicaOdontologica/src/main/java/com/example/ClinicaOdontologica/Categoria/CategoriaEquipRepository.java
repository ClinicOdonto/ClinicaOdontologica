package com.example.ClinicaOdontologica.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaEquipRepository extends JpaRepository<CategoriaEquip, UUID> {
}
