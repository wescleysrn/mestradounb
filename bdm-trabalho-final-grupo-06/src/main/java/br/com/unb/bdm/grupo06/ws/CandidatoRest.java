package br.com.unb.bdm.grupo06.ws;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unb.bdm.grupo06.servico.CandidatoServico;

/**
 * @author wescley.sousa
 * @since 09 de abril de 2017
 */
@RestController("/candidato/")
public class CandidatoRest {

	@Autowired 
	CandidatoServico servico;	
	
	@RequestMapping("/grafico")
	public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
		return servico.grafico(limit == null ? 100 : limit);
	}

}
