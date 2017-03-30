package br.com.unb.wescley.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import br.com.unb.wescley.mongodb.entidade.MesoRegiao;

public interface MesoRegiaoRepositorio extends MongoRepository<MesoRegiao, String>, QueryDslPredicateExecutor<MesoRegiao> {

}
