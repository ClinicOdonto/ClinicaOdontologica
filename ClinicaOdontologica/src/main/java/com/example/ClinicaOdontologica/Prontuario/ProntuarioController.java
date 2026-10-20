package com.example.ClinicaOdontologica.Prontuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public Prontuario buscarPorId(@PathVariable UUID id) {

        return service.buscarPorId(id);
    }
}