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
import br.com.unb.wescley.mongodb.dao.MesoRegiaoRepositorio;
import br.com.unb.wescley.mongodb.entidade.MesoRegiao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfiguracaoMongo.class)
public class MesoRegiaoRepositorioTest {

    @Autowired
    private MesoRegiaoRepositorio mesoRegiaoRepositorio;

    @Autowired
    private MongoOperations mongoOps;
    
    @Before
    public void testSetup() {
        if (!mongoOps.collectionExists(MesoRegiao.class)) {
            mongoOps.createCollection(MesoRegiao.class);
        }
    }
	
    @Test
    public void testeInsercaoUFJSON() {
    	try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream is = MesoRegiaoRepositorioTest.class.getResourceAsStream("/mesoregiao.json");
			List<MesoRegiao> mesosRegioes = mapper.readValue(is, new TypeReference<List<MesoRegiao>>(){}); 
			for (MesoRegiao mesoRegiao : mesosRegioes) {
				mesoRegiaoRepositorio.insert(mesoRegiao);
			}
		} catch (Exception e) {
			Assert.assertTrue(Boolean.FALSE);
		}    	
    }
    
}
