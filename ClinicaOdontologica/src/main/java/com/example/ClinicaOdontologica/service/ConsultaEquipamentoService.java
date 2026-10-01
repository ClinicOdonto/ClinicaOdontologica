package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.model.ConsultaEquipamento;
import com.example.ClinicaOdontologica.model.ConsultaEquipamentoId;
import com.example.ClinicaOdontologica.repository.ConsultaEquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaEquipamentoService {

    private final ConsultaEquipamentoRepository repository;

    public ConsultaEquipamentoService(ConsultaEquipamentoRepository repository) {
        this.repository = repository;
    }

    public ConsultaEquipamento criar(ConsultaEquipamento consultaEquipamento) {
        return repository.save(consultaEquipamento);
    }

    public List<ConsultaEquipamento> listar() {
        return repository.findAll();
    }

    public ConsultaEquipamento buscarPorId(ConsultaEquipamentoId id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Consulta equipamento não encontrada"));
    }
}
