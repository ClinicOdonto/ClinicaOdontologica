package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.model.Equipamento;
import com.example.ClinicaOdontologica.service.EquipamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService service;

    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipamento criar(@RequestBody Equipamento equipamento) {
        return service.criar(equipamento);
    }

    @GetMapping
    public List<Equipamento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Equipamento buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}
