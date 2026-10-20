package com.example.ClinicaOdontologica.Paciente;

public record PacienteGetDTO (String nome, String cpf) {

    public PacienteGetDTO(Paciente paciente) {
        this(paciente.getNome(), paciente.getCpf());
    }
}
