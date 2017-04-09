package br.com.unb.bdm.grupo06.repositorio;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.unb.bdm.grupo06.dominio.Candidato;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@RepositoryRestResource(collectionResourceRel = "candidatos", path = "candidatos")
public interface CandidatoRepositorio extends PagingAndSortingRepository<Candidato, Long> {

	Candidato findByCpf(@Param("cpf") String cpf);
	
	Candidato findByNome(@Param("nome") String nome);
	
	List<Candidato> findByCargo(@Param("cargo") String cargo);
	
	@Query("MATCH (m:Candidato)<-[r:DOOU_DINHEIRO_PARA_CANDIDATO]-(a:Doador) RETURN m,r,a LIMIT {limite}")
	List<Candidato> grafico(@Param("limite") int limite);

}
