package br.com.unb.bdm.grupo06.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.unb.bdm.grupo06.dominio.Partido;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@RepositoryRestResource(collectionResourceRel = "partidos", path = "partidos")
public interface PartidoRepositorio extends PagingAndSortingRepository<Partido, Long> {

}
