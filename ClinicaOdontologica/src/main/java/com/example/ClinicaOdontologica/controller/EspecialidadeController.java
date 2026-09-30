package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Especialidade;
import com.example.ClinicaOdontologica.service.EspecialidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    private final EspecialidadeService service;

    public EspecialidadeController(EspecialidadeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidade criar(@RequestBody Especialidade especialidade) {
        return service.criar(especialidade);
    }

    @GetMapping
    public List<Especialidade> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Especialidade buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}
