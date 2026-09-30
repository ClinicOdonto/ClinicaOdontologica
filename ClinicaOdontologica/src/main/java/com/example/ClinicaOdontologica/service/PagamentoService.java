package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.Pagamento;
import com.example.ClinicaOdontologica.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository repository;

    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    public Pagamento criar(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    public List<Pagamento> listar() {
        return repository.findAll();
    }

    public Pagamento buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }
}
