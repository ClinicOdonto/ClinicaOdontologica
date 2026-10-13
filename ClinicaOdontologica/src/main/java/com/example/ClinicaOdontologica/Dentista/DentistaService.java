package com.example.ClinicaOdontologica.Dentista;

import com.example.ClinicaOdontologica.Especialidade.Especialidade;
import com.example.ClinicaOdontologica.Especialidade.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DentistaService {
    @Autowired
    DentistaRepository dentistaRepository;

    @Autowired
    EspecialidadeRepository especialidadeRepository;

    public DentistaService(DentistaRepository repository) {
        this.dentistaRepository = repository;
    }

    public Dentista criar(DentistaDtoCreate dto) {

        Especialidade especialidade = especialidadeRepository.findByNome(dto.especialidade()).orElseThrow(() -> new RuntimeException("Especialidade não encontrada"));
        Dentista dentista = new Dentista(
                especialidade,
                dto.cro(),
                dto.cpf(),
                dto.nome(),
                dto.email(),
                dto.telefone()
        );

        return dentistaRepository.save(dentista);
    }

    public List<Dentista> listar() {
        return dentistaRepository.findAll();
    }

    public Dentista buscarPorId(UUID id) {
        return dentistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Dentista não encontrado"));
    }
}
