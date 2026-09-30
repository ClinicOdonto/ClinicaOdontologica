package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Prontuario;
import com.example.ClinicaOdontologica.repository.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Prontuario buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado"));
    }
}
