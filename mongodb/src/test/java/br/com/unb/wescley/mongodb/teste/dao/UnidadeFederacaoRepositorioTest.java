package br.com.unb.wescley.mongodb.teste.dao;

import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.unb.wescley.mongodb.config.ConfiguracaoMongo;
import br.com.unb.wescley.mongodb.dao.UnidadeFederacaoRepositorio;
import br.com.unb.wescley.mongodb.entidade.UnidadeFederacao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfiguracaoMongo.class)
public class UnidadeFederacaoRepositorioTest {

    @Autowired
    private UnidadeFederacaoRepositorio ufRepositorio;

    @Autowired
    private MongoOperations mongoOps;
    
    @Before
    public void testSetup() {
        if (!mongoOps.collectionExists(UnidadeFederacao.class)) {
            mongoOps.createCollection(UnidadeFederacao.class);
        }
    }
	
    @Test
    public void testeInsercaoUFJSON() {
    	try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream is = RegiaoRepositorioTest.class.getResourceAsStream("/uf.json");
			List<UnidadeFederacao> ufs = mapper.readValue(is, new TypeReference<List<UnidadeFederacao>>(){}); 
			for (UnidadeFederacao uf : ufs) {
				ufRepositorio.insert(uf);
			}
		} catch (Exception e) {
			Assert.assertTrue(Boolean.FALSE);
		}    	
    }
    
}
