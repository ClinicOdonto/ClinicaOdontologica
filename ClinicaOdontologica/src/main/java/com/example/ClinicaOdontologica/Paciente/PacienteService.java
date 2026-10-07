package com.example.ClinicaOdontologica.Paciente;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {

        this.repository = repository;
    }

    public Paciente criar(Paciente paciente) {

        return repository.save(paciente);
    }

    public List<Paciente> listar(PacienteGetDTO dto) {
        return repository.findByNomeAndCpf(dto.nome(), dto.cpf());
    }

    public Paciente buscarPorNome(String nome) {
        return repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }
}
