package com.example.ClinicaOdontologica.Prontuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProntuarioRepository extends JpaRepository<Prontuario, UUID> {
}