package br.com.unb.wescley.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import br.com.unb.wescley.mongodb.entidade.UnidadeFederacao;

public interface UnidadeFederacaoRepositorio extends MongoRepository<UnidadeFederacao, String>, QueryDslPredicateExecutor<UnidadeFederacao> {

}
