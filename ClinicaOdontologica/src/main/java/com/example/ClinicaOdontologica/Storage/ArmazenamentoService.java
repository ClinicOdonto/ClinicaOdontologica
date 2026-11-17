package com.example.ClinicaOdontologica.Storage;

import org.springframework.web.multipart.MultipartFile;

public interface ArmazenamentoService {

    String enviarArquivo(MultipartFile arquivo);

    void excluirArquivo(String chave);
}