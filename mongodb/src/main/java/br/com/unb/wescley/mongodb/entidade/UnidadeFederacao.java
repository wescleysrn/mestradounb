package br.com.unb.wescley.mongodb.entidade;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.querydsl.core.annotations.QueryEntity;

import lombok.Getter;
import lombok.Setter;

@QueryEntity
@Document
public class UnidadeFederacao {

	@Id
	@Getter
	@Setter
	private String sigla;
	
	@Getter
	@Setter
	private String codigoIBGE;

	@Getter
	@Setter
	private String nome;

    @DBRef
    @Field("regiao")
	@Getter
	@Setter
	private Regiao regiao;

}
