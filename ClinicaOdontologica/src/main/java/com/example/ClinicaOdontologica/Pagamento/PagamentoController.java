package com.example.ClinicaOdontologica.Pagamento;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) {

        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento criar(@RequestBody Pagamento pagamento) {

        return service.criar(pagamento);
    }

    @GetMapping
    public List<Pagamento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Pagamento buscarPorId(@PathVariable UUID id) {
        return service.buscarPorId(id);
    }
}