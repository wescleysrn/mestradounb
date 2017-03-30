package br.com.unb.wescley.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import br.com.unb.wescley.mongodb.entidade.MicroRegiao;

public interface MicroRegiaoRepositorio extends MongoRepository<MicroRegiao, String>, QueryDslPredicateExecutor<MicroRegiao> {

}
