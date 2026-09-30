package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {
}