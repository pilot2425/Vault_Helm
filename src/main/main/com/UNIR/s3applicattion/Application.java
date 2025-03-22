package com.example.s3application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Ejecutar el acceso a S3 después de iniciar la aplicación
    @Bean
    public CommandLineRunner demo(S3Service s3Service) {
        return (args) -> {
            // Accede al bucket de S3 para comprobar la conexión
            s3Service.uploadFile("test-file.txt", "Hola desde Spring Boot y Vault!");
            System.out.println("Archivo subido correctamente a S3.");
        };
    }
}
