package br.com.unb.bdm.grupo06.dominio;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.unb.bdm.grupo06.relacionamento.DoacaoCampanhaCandidato;
import br.com.unb.bdm.grupo06.relacionamento.DoacaoCampanhaComite;
import br.com.unb.bdm.grupo06.relacionamento.DoacaoCampanhaPartido;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Doador {

	@GraphId
	@Getter
	@Setter
	private Long id;
	
	@Relationship(type = "DOOU_DINHEIRO_PARA_CANDIDATO")
	private List<DoacaoCampanhaCandidato> doacoesCandidato = new ArrayList<>();
	
	@Relationship(type = "DOOU_DINHEIRO_PARA_PARTIDO")
	private List<DoacaoCampanhaPartido> doacoesPartido = new ArrayList<>();
	
	@Relationship(type = "DOOU_DINHEIRO_PARA_COMITE")
	private List<DoacaoCampanhaComite> doacoesComite = new ArrayList<>();
	
	@Getter
	@Setter
	private String cpfCnpj;
	
	@Getter
	@Setter
	private String nome;
	
	@Getter
	@Setter
	private String siglaUEDoador;
	
	@Getter
	@Setter
	private String codigoSetorEconomico;
	
	@Getter
	@Setter
	private String setorEconomico;
	
}
