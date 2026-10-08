package com.example.ClinicaOdontologica.Equipamento;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    public Equipamento criar(Equipamento equipamento) {
        return repository.save(equipamento);
    }

    public List<Equipamento> listar() {
        return repository.findAll();
    }

    public Equipamento buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
    }
}