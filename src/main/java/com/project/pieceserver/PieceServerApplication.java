package com.project.pieceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PieceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PieceServerApplication.class, args);
    }

}
