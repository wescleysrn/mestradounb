package br.com.unb.bdm.grupo06.dominio;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.unb.bdm.grupo06.relacionamento.DespesaCampanhaComite;
import br.com.unb.bdm.grupo06.relacionamento.DoacaoCampanhaComite;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Comite {

	@GraphId
	@Getter
	@Setter
	private Long id;
	
	@Relationship(type = "DOOU_DINHEIRO_PARA_COMITE", direction = Relationship.INCOMING)
	private List<DoacaoCampanhaComite> doacoesComite = new ArrayList<>();
	
	@Relationship(type = "RECEBEU_DINHEIRO_DE_COMITE")
	private List<DespesaCampanhaComite> despesasComite = new ArrayList<>();
	
	@Getter
	@Setter
	private String sequencialComite;
	
	@Getter
	@Setter
	private String uf;
	
	@Getter
	@Setter
	private String tipoComite;
	
	@Getter
	@Setter
	private String siglaPartido;	
	
}
