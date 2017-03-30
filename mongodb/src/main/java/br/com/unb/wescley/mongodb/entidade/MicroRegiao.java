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
public class MicroRegiao {

	@Id
	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String codigoIBGE;

    @DBRef
    @Field("uf")
	@Getter
	@Setter
	private MesoRegiao mesoRegiao;

	@Getter
	@Setter
	private String nome;
	
}
