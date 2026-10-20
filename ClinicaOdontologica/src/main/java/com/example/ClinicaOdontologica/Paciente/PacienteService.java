package com.example.ClinicaOdontologica.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository repository) {

        this.pacienteRepository = repository;
    }

    public Paciente criar(Paciente paciente) {

        return pacienteRepository.save(paciente);
    }

    public List<PacienteGetDTO> listar(PacienteGetDTO dto) {
        List <PacienteGetDTO> getPaciente = pacienteRepository.findAll().stream().map(PacienteGetDTO::new).toList();

        return getPaciente;
    }

    public Paciente buscarPorNome(String nome) {
        return pacienteRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }
}
