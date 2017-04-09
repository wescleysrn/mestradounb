package br.com.unb.bdm.grupo06.teste;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wescley.sousa
 * @since 29 de ago de 2016
 */
@EnableTransactionManagement
@ComponentScan(basePackages = "br.com.unb.bdm.grupo06.repositorio")
public class TestConfig {

}
