package com.example.ClinicaOdontologica.Pagamento;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Pagamento buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }
}
