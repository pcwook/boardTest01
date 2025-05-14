package com.example.borad1.boardTest01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BoardTest01Application {

	public static void main(String[] args) {
		SpringApplication.run(BoardTest01Application.class, args);
	}

}
