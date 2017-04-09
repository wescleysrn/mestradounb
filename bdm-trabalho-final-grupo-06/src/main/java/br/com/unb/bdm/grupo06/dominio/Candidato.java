package br.com.unb.bdm.grupo06.dominio;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.unb.bdm.grupo06.relacionamento.DespesaCampanhaCandidato;
import br.com.unb.bdm.grupo06.relacionamento.DoacaoCampanhaCandidato;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Candidato {

	@GraphId
	@Getter
	@Setter
	private Long id;
	
	@Relationship(type = "DOOU_DINHEIRO_PARA_CANDIDATO", direction = Relationship.INCOMING)
	@Getter
	@Setter
	private List<DoacaoCampanhaCandidato> doacoesCandidato = new ArrayList<>();
	
	@Relationship(type = "RECEBEU_DINHEIRO_DE_CANDIDATO")
	@Getter
	@Setter
	private List<DespesaCampanhaCandidato> despesasCandidato = new ArrayList<>();
	
	@Getter
	@Setter
	private String sequencial;
	
	@Getter
	@Setter
	private String uf;
	
	@Getter
	@Setter
	private String numero;
	
	@Getter
	@Setter
	private String cargo;
	
	@Getter
	@Setter
	private String nome;
		
	@Getter
	@Setter
	private String cpf;
	
	public void addDoacao(DoacaoCampanhaCandidato doacao) {
		this.doacoesCandidato.add(doacao);
	}

}
