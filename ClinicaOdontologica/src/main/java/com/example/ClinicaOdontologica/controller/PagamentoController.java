package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.model.Pagamento;
import com.example.ClinicaOdontologica.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Pagamento buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}