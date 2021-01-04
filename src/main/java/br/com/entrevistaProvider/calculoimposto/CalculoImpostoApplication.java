package br.com.entrevistaProvider.calculoimposto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.entrevistaProvider.calculoimposto")
@EntityScan(basePackages = "br.com.entrevistaProvider.calculoimposto.domain.model")
public class CalculoImpostoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculoImpostoApplication.class, args);
	}

}
