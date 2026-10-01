package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
