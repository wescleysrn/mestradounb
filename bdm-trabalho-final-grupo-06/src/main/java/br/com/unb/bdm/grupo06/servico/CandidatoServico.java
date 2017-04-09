package br.com.unb.bdm.grupo06.servico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unb.bdm.grupo06.dominio.Candidato;
import br.com.unb.bdm.grupo06.relacionamento.DoacaoCampanhaCandidato;
import br.com.unb.bdm.grupo06.repositorio.CandidatoRepositorio;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@Service
public class CandidatoServico {

	@Autowired 
	CandidatoRepositorio repositorio;

	@Transactional(readOnly = true)
	public Map<String, Object>  grafico(int limite) {
		List<Candidato> result = repositorio.grafico(limite);
		return converterFormato3D(result);
	}

	//Trabalhar aqui ...
	private Map<String, Object> converterFormato3D(Collection<Candidato> movies) {
		List<Map<String, Object>> nodes = new ArrayList<>();
		List<Map<String, Object>> rels = new ArrayList<>();
		int i = 0;
		Iterator<Candidato> result = movies.iterator();
		while (result.hasNext()) {
			Candidato candidato = result.next();
			nodes.add(map("nome", candidato.getDoacoesCandidato(), "label", "candidato"));
			int target = i;
			i++;
			for (DoacaoCampanhaCandidato doacao : candidato.getDoacoesCandidato()) {
				Map<String, Object> doador = map("doador", doacao.getDoador().getNome(), "label", "doador");
				int source = nodes.indexOf(doador);
				if (source == -1) {
					nodes.add(doador);
					source = i++;
				}
				rels.add(map("source", source, "target", target));
			}
		}
		return map("nodes", nodes, "links", rels);
	}

	private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put(key1, value1);
		result.put(key2, value2);
		return result;
	}

}
