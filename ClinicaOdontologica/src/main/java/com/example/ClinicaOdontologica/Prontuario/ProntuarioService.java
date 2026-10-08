package com.example.ClinicaOdontologica.Prontuario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProntuarioService {

    private final ProntuarioRepository repository;

    public ProntuarioService(ProntuarioRepository repository) {
        this.repository = repository;
    }

    public Prontuario criar(Prontuario prontuario) {
        return repository.save(prontuario);
    }

    public List<Prontuario> listar() {
        return repository.findAll();
    }

    public Prontuario buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado"));
    }
}
