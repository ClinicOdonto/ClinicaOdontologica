package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.model.Equipamento;
import com.example.ClinicaOdontologica.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Equipamento buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));
    }
}