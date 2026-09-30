package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public Consulta criar(Consulta consulta) {
        return repository.save(consulta);
    }

    public List<Consulta> listar() {
        return repository.findAll();
    }

    public Consulta buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }
}