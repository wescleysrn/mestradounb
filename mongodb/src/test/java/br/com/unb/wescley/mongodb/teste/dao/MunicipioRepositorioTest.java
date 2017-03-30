package br.com.unb.wescley.mongodb.teste.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.querydsl.core.types.Predicate;

import br.com.unb.wescley.mongodb.config.ConfiguracaoMongo;
import br.com.unb.wescley.mongodb.dao.MunicipioRepositorio;
import br.com.unb.wescley.mongodb.entidade.Municipio;
import br.com.unb.wescley.mongodb.entidade.QMunicipio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfiguracaoMongo.class)
public class MunicipioRepositorioTest {

    @Autowired
    private MunicipioRepositorio municipioRepositorio;

    @Autowired
    private MongoOperations mongoOps;
    
    @Before
    public void testSetup() {
        if (!mongoOps.collectionExists(Municipio.class)) {
            mongoOps.createCollection(Municipio.class);
        }
    }
	
    @Test
    public void testeBuscaQueryDSL() {
    	try {
            QMunicipio qMunicipio = new QMunicipio("municipio");
            Predicate predicate = qMunicipio.nome.startsWith("São");
            List<Municipio> municipios = (List<Municipio>) municipioRepositorio.findAll(predicate);
            assertThat(municipios.size(), is(344));
		} catch (Exception e) {
			Assert.assertTrue(Boolean.FALSE);
		}    	
    }
    
    @Test
    public void testeBuscaQueryDSLMunicipiosEstado() {
    	try {
            QMunicipio qMunicipio = new QMunicipio("municipio");
            Predicate predicate = qMunicipio.uf.sigla.eq("GO");
            List<Municipio> municipios = (List<Municipio>) municipioRepositorio.findAll(predicate);
            assertThat(municipios.size(), is(344));
		} catch (Exception e) {
			Assert.assertTrue(Boolean.FALSE);
		}    	
    }

    @Test
    public void testeBuscaSpringDataMongoDBMunicipiosEstado() {
    	try {
            List<Municipio> municipios = (List<Municipio>) municipioRepositorio.findByUfSigla("GO");
            assertThat(municipios.size(), is(344));
		} catch (Exception e) {
			Assert.assertTrue(Boolean.FALSE);
		}    	
    }

}
