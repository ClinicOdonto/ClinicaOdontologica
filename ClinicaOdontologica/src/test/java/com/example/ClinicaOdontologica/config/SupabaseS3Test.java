package com.example.ClinicaOdontologica.config;
// aqui verifica a se o bucket está acessivel usando o S3client

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class SupabaseS3Test {

    private final S3Client s3Client;

    public SupabaseS3Test(S3Client s3Client) {
        this.s3Client = s3Client;
    }


    public void run(String... args) {

        String bucket = "clinicodonto-documentos";

        try {
            s3Client.headBucket(
                    HeadBucketRequest.builder()
                            .bucket(bucket)
                            .build()
            );

            System.out.println("================================");
            System.out.println("Conexão com Supabase Storage OK!");
            System.out.println("Bucket: " + bucket);
            System.out.println("================================");

        } catch (S3Exception e) {
            System.out.println("Erro ao acessar o bucket!");
            System.out.println("Código: " + e.awsErrorDetails().errorCode());
            System.out.println("Mensagem: " + e.getMessage());
        }
    }
}
