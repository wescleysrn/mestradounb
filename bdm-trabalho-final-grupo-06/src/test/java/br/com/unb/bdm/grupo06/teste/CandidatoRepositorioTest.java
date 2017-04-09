package br.com.unb.bdm.grupo06.teste;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import br.com.unb.bdm.grupo06.dominio.Candidato;
import br.com.unb.bdm.grupo06.dominio.Doador;
import br.com.unb.bdm.grupo06.relacionamento.DoacaoCampanhaCandidato;
import br.com.unb.bdm.grupo06.repositorio.CandidatoRepositorio;
import br.com.unb.bdm.grupo06.repositorio.DoadorRepositorio;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class}, loader = AnnotationConfigContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class CandidatoRepositorioTest {

	@Autowired
	private Session session;

	@Autowired
	private CandidatoRepositorio instancia;

	@Autowired
	private DoadorRepositorio doadorRepositorio;

	@Before
	public void setUp() {
		Candidato candidato = new Candidato();
		candidato.setCargo("Deputado Distrital");
		candidato.setCpf("58379339134");
		candidato.setNome("CLAUDECI XAVIER DE MIRANDA");
		candidato.setNumero("10456");
		candidato.setSequencial("70000000597");
		candidato.setUf("DF");
		instancia.save(candidato);

		Doador doador = new Doador();
		doador.setCodigoSetorEconomico("1622602");
		doador.setCpfCnpj("00502963000193");
		doador.setNome("FORMATUS MÓVEIS LTDA ME");
		doador.setSetorEconomico("Fabricação de esquadrias de madeira e de peças de madeira para instalações industriais e comerciais");
		doador.setSiglaUEDoador("");
		doadorRepositorio.save(doador);

		DoacaoCampanhaCandidato doacao = new DoacaoCampanhaCandidato();
		doacao.setCandidato(candidato);
		doacao.setDoador(doador);
		doacao.setData("03/09/2014");
		doacao.setDescricaoDoacao("CONTRATO DE COMODATO DE BENS MÓVES PARA ESCRITÓRIO");
		doacao.setEspecieRecurso("Nao especificado");
		doacao.setFonteRecurso("Recursos de pessoas jurídicas");
		doacao.setTipoDoacao("");
		doacao.setValor(new BigDecimal("100000"));

		candidato.addDoacao(doacao);

		instancia.save(candidato);
	}

	@After
	public void tearDown() {
		session.purgeDatabase();
	}

	/**
	 * Realiza teste simples de busca de candidato por nome no banco neo4j
	 */
	@Test
	public void testBuscarCandidatoPorNome() {
		Candidato candidato = instancia.findByNome("");
		Assert.assertNotNull(candidato);
		Assert.assertEquals("", candidato.getNome());
	}
	
}
