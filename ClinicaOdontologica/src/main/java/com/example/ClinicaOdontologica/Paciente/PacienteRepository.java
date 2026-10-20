package com.example.ClinicaOdontologica.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {

    List<Paciente> findByNomeAndCpf(String nome, String cpf);

    Optional<Paciente> findByNome(String nome);
}
