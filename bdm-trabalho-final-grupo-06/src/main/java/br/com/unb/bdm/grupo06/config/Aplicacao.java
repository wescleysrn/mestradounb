package br.com.unb.bdm.grupo06.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@SpringBootApplication
@EntityScan("br.com.unb.bdm.grupo06.dominio")
public class Aplicacao extends SpringBootServletInitializer {

	public static void main(final String[] args) {
		SpringApplication.run(Aplicacao.class, args);
	}
	
}
