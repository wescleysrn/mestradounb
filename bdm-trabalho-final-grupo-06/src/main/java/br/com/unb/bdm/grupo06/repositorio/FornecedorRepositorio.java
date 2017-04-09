package br.com.unb.bdm.grupo06.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.unb.bdm.grupo06.dominio.Fornecedor;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@RepositoryRestResource(collectionResourceRel = "fornecedores", path = "fornecedores")
public interface FornecedorRepositorio extends PagingAndSortingRepository<Fornecedor, Long> {

}
