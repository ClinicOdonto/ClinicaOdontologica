
package com.example.ClinicaOdontologica.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
public class SupabaseS3Service {

    private final S3Client s3Client;
    private final String bucket;

    public SupabaseS3Service(
            S3Client s3Client,
            @Value("${supabase.s3.bucket}") String bucket) {

        this.s3Client = s3Client;
        this.bucket = bucket;
    }

    public boolean testarConexao() {
        try {
            s3Client.headBucket(
                    HeadBucketRequest.builder()
                            .bucket(bucket)
                            .build()
            );

            return true;

        } catch (S3Exception e) {
            throw new IllegalStateException(
                    "Não foi possível acessar o bucket. Código HTTP: "
                            + e.statusCode(),
                    e
            );
        }
    }

    public String enviarArquivo(MultipartFile arquivo) {

        if (arquivo == null || arquivo.isEmpty()) {
            throw new IllegalArgumentException(
                    "O arquivo não pode estar vazio."
            );
        }

        String nomeOriginal = arquivo.getOriginalFilename();

        String extensao = "";

        if (nomeOriginal != null && nomeOriginal.contains(".")) {
            extensao = nomeOriginal.substring(
                    nomeOriginal.lastIndexOf(".")
            );
        }

        String chave = "documentos/"
                + UUID.randomUUID()
                + extensao;

        String contentType = arquivo.getContentType();

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        try {
            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(chave)
                    .contentType(arquivo.getContentType())
                    .build();

            s3Client.putObject(
                    request,
                    RequestBody.fromBytes(arquivo.getBytes())
            );

            return chave;

        } catch (IOException | S3Exception e) {
            throw new IllegalStateException(
                    "Erro ao enviar arquivo para o Supabase Storage.",
                    e
            );
        }
    }
}
