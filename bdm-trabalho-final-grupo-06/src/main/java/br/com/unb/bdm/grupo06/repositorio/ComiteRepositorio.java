package br.com.unb.bdm.grupo06.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.unb.bdm.grupo06.dominio.Comite;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@RepositoryRestResource(collectionResourceRel = "comites", path = "comites")
public interface ComiteRepositorio extends PagingAndSortingRepository<Comite, Long> {

}
