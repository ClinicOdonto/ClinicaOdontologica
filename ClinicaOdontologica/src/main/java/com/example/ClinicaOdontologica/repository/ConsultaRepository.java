package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}