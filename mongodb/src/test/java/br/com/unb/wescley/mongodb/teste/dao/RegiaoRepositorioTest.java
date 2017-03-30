package br.com.unb.wescley.mongodb.teste.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.unb.wescley.mongodb.config.ConfiguracaoMongo;
import br.com.unb.wescley.mongodb.dao.RegiaoRepositorio;
import br.com.unb.wescley.mongodb.entidade.Regiao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfiguracaoMongo.class)
public class RegiaoRepositorioTest {

    @Autowired
    private RegiaoRepositorio regiaoRepositorio;

    @Autowired
    private MongoOperations mongoOps;
    
    @Before
    public void testSetup() {
        if (!mongoOps.collectionExists(Regiao.class)) {
            mongoOps.createCollection(Regiao.class);
        }
    }

    @Test
    public void testeInsercaoRegiaoSimples() {
    	try {
            final Regiao regiao = new Regiao();
            regiao.setNome("Norte");
            regiao.setSigla("NO");
            regiaoRepositorio.insert(regiao);
            assertThat(mongoOps.findOne(Query.query(Criteria.where("nome").is("Norte")), Regiao.class).getNome(), is("Norte"));        			
		} catch (Exception e) {
			Assert.assertTrue(Boolean.FALSE);
		}    	
    }

    @Test
    public void testeInsercaoRegiaoJSON() {
    	try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream is = RegiaoRepositorioTest.class.getResourceAsStream("/regiao.json");
			List<Regiao> regioes = mapper.readValue(is, new TypeReference<List<Regiao>>(){}); 
			for (Regiao regiao : regioes) {
				regiaoRepositorio.insert(regiao);
			}
		} catch (Exception e) {
			Assert.assertTrue(Boolean.FALSE);
		}    	
    }
    
//    @After
//    public void tearDown() {
//        mongoOps.dropCollection(Regiao.class);
//    }
	
}
