package br.com.heitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "br.com.heitor"})

public class ProjetoSpringApiHeitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringApiHeitorApplication.class, args);
	}

}
