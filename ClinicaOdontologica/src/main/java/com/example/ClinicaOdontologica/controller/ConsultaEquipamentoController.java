package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.ConsultaEquipamento;
import com.example.ClinicaOdontologica.entity.ConsultaEquipamentoId;
import com.example.ClinicaOdontologica.service.ConsultaEquipamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consultas-equipamentos")
public class ConsultaEquipamentoController {

    private final ConsultaEquipamentoService service;

    public ConsultaEquipamentoController(ConsultaEquipamentoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsultaEquipamento criar(
            @RequestBody ConsultaEquipamento consultaEquipamento) {

        return service.criar(consultaEquipamento);
    }

    @GetMapping
    public List<ConsultaEquipamento> listar() {
        return service.listar();
    }

    @GetMapping("/{idConsulta}/{idEquipamento}")
    public ConsultaEquipamento buscarPorId(
            @PathVariable UUID idConsulta,
            @PathVariable UUID idEquipamento) {

        ConsultaEquipamentoId id =
                new ConsultaEquipamentoId(idConsulta, idEquipamento);

        return service.buscarPorId(id);
    }
}
