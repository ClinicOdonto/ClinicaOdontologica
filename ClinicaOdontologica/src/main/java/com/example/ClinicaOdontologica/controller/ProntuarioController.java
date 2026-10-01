package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.model.Prontuario;
import com.example.ClinicaOdontologica.service.ProntuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    private final ProntuarioService service;

    public ProntuarioController(ProntuarioService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prontuario criar(@RequestBody Prontuario prontuario) {
        return service.criar(prontuario);
    }

    @GetMapping
    public List<Prontuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Prontuario buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}