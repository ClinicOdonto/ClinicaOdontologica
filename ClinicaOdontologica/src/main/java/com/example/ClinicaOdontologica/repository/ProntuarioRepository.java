package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Integer> {
}