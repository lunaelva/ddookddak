package com.ddook.ddak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class DdookApplication {
	public static void main(String[] args) {
		SpringApplication.run(DdookApplication.class, args);
	}
}
