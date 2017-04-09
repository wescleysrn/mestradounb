package br.com.unb.bdm.grupo06.dominio;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.unb.bdm.grupo06.relacionamento.DespesaCampanhaCandidato;
import br.com.unb.bdm.grupo06.relacionamento.DespesaCampanhaComite;
import br.com.unb.bdm.grupo06.relacionamento.DespesaCampanhaPartido;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Fornecedor {

	@GraphId
	@Getter
	@Setter
	private Long id;
	
	@Relationship(type = "RECEBEU_DINHEIRO_DE_CANDIDATO", direction = Relationship.INCOMING)
	private List<DespesaCampanhaCandidato> despesasCandidato = new ArrayList<>();
	
	@Relationship(type = "RECEBEU_DINHEIRO_DE_PARTIDO", direction = Relationship.INCOMING)
	private List<DespesaCampanhaPartido> despesasPartido = new ArrayList<>();
	
	@Relationship(type = "RECEBEU_DINHEIRO_DE_COMITE", direction = Relationship.INCOMING)
	private List<DespesaCampanhaComite> despesasComite = new ArrayList<>();
	
	@Getter
	@Setter
	private String cpfCnpj;

	@Getter
	@Setter
	private String nome;
	
	@Getter
	@Setter
	private String codigoSetorEconomico;
	
	@Getter
	@Setter
	private String setorEconomico;
	
}
