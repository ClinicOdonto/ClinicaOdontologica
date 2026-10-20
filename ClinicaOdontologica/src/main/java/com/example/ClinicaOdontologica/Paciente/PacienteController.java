package com.example.ClinicaOdontologica.Paciente;

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
    public List<PacienteGetDTO> listar(PacienteGetDTO dto) {
        return service.listar(dto) ;
    }

    @GetMapping("/{nome}")
    public Paciente buscarPorNome(@PathVariable String nome) {
        return service.buscarPorNome(nome);
    }
}