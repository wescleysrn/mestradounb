package br.com.unb.bdm.grupo06.relacionamento;

import java.math.BigDecimal;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.unb.bdm.grupo06.dominio.Doador;
import br.com.unb.bdm.grupo06.dominio.Partido;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "DOOU_DINHEIRO_PARA_PARTIDO")
public class DoacaoCampanhaPartido {

	@GraphId
	private Long id;
	
	@StartNode
	private Doador doador;

	@EndNode
	private Partido partido;

	@Getter
	@Setter
	private String data;
	
	@Getter
	@Setter
	private BigDecimal valor;
	
	@Getter
	@Setter
	private String tipoDoacao;
	
	@Getter
	@Setter
	private String fonteRecurso;
	
	@Getter
	@Setter
	private String especieRecurso;
	
	@Getter
	@Setter
	private String descricaoDoacao;
	
}
