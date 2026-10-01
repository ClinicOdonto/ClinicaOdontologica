package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.model.Paciente;
import com.example.ClinicaOdontologica.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente criar(@RequestBody Paciente paciente) {
        return service.criar(paciente);
    }

    @GetMapping
    public List<Paciente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}