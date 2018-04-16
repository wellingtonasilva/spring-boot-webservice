package br.com.wsilva.fpf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class ProdutosApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProdutosApplication.class, args);
	}
}
