package br.com.unb.wescley.mongodb.entidade;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.Getter;
import lombok.Setter;

@QueryEntity
@Document
public class Municipio {

	@Id
	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String codigoIBGE;

	@Getter
	@Setter
	private MicroRegiao microRegiao;

	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private UnidadeFederacao uf;

}
