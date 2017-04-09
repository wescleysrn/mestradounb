package br.com.unb.bdm.grupo06.dominio;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.unb.bdm.grupo06.relacionamento.DespesaCampanhaPartido;
import br.com.unb.bdm.grupo06.relacionamento.DoacaoCampanhaPartido;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Partido {

	@GraphId
	@Getter
	@Setter
	private Long id;
	
	@Relationship(type = "DOOU_DINHEIRO_PARA_PARTIDO", direction = Relationship.INCOMING)
	private List<DoacaoCampanhaPartido> doacoesPartido = new ArrayList<>();
	
	@Relationship(type = "RECEBEU_DINHEIRO_DE_PARTIDO")
	private List<DespesaCampanhaPartido> despesasPartido = new ArrayList<>();
	
	@Getter
	@Setter
	private String sequencialDiretorio;
	
	@Getter
	@Setter
	private String uf;
	
	@Getter
	@Setter
	private String tipoDiretorio;
	
	@Getter
	@Setter
	private String siglaPartido;	
	
}
