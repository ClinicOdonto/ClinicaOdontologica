package com.example.ClinicaOdontologica.Dentista;

import com.example.ClinicaOdontologica.Especialidade.Especialidade;

public record DentistaDtoCreate(
        String nome,
        String cpf,
        String cro,
        String especialidade,
        String email,
        String telefone) {
}
