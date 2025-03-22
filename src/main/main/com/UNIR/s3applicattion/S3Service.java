package com.example.s3application;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;

@Service
public class S3Service {

    private final AmazonS3 amazonS3;

    // Inyectar las credenciales obtenidas de Vault a través de variables de entorno
    @Value("${aws.access.key.id}")
    private String accessKeyId;

    @Value("${aws.secret.access.key}")
    private String secretAccessKey;

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    public S3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    // Método para cargar un archivo en un bucket de S3
    public void uploadFile(String fileName, String content) {
        byte[] contentBytes = content.getBytes();
        amazonS3.putObject(new PutObjectRequest(bucketName, fileName, new ByteArrayInputStream(contentBytes), null));
    }
}
