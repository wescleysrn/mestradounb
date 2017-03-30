package br.com.unb.wescley.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import br.com.unb.wescley.mongodb.entidade.Municipio;

public interface MunicipioRepositorio extends MongoRepository<Municipio, String>, 
												QueryDslPredicateExecutor<Municipio> {

	List<Municipio> findByUfSigla(String sigla);
	
}
