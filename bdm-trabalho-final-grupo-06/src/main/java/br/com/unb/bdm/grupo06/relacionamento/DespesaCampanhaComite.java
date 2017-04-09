package br.com.unb.bdm.grupo06.relacionamento;

import java.math.BigDecimal;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.unb.bdm.grupo06.dominio.Comite;
import br.com.unb.bdm.grupo06.dominio.Fornecedor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "RECEBEU_DINHEIRO_DE_COMITE")
public class DespesaCampanhaComite {

	@GraphId
	private Long id;
	
	@StartNode
	private Fornecedor fornecedor;

	@EndNode
	private Comite comite;
	
	@Getter
	@Setter
	private String data;
	
	@Getter
	@Setter
	private BigDecimal valor;
	
	@Getter
	@Setter
	private String tipoDespesa;
	
	@Getter
	@Setter
	private String descricaoDespesa;
	
}
