package br.com.unb.wescley.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import br.com.unb.wescley.mongodb.entidade.Regiao;

public interface RegiaoRepositorio extends MongoRepository<Regiao, String>, 
											QueryDslPredicateExecutor<Regiao> {

	Regiao findBySigla(String sigla);
	
    List<Regiao> findByNomeLikeOrderBySiglaAsc(String nome);
	
}
