package com.example.ClinicaOdontologica.Recepcionista;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecepcionistaRepository extends JpaRepository<Recepcionista, UUID> {
}