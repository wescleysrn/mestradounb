package br.com.unb.wescley.mongodb.teste.carga;

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
import br.com.unb.wescley.mongodb.dao.MicroRegiaoRepositorio;
import br.com.unb.wescley.mongodb.dao.MunicipioRepositorio;
import br.com.unb.wescley.mongodb.dao.RegiaoRepositorio;
import br.com.unb.wescley.mongodb.dao.UnidadeFederacaoRepositorio;
import br.com.unb.wescley.mongodb.entidade.MesoRegiao;
import br.com.unb.wescley.mongodb.entidade.MicroRegiao;
import br.com.unb.wescley.mongodb.entidade.Municipio;
import br.com.unb.wescley.mongodb.entidade.Regiao;
import br.com.unb.wescley.mongodb.entidade.UnidadeFederacao;
import br.com.unb.wescley.mongodb.teste.dao.MesoRegiaoRepositorioTest;
import br.com.unb.wescley.mongodb.teste.dao.RegiaoRepositorioTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfiguracaoMongo.class)
public class CargaLocalizacaoIBGETest {

    @Autowired
    private RegiaoRepositorio regiaoRepositorio;

    @Autowired
    private UnidadeFederacaoRepositorio ufRepositorio;
    
    @Autowired
    private MesoRegiaoRepositorio mesoRegiaoRepositorio;
    
    @Autowired
    private MicroRegiaoRepositorio microRegiaoRepositorio;
    
    @Autowired
    private MunicipioRepositorio municipioRepositorio;
    
    @Autowired
    private MongoOperations mongoOps;
    
    @Before
    public void testSetup() {
        if (!mongoOps.collectionExists(Regiao.class)) {
            mongoOps.createCollection(Regiao.class);
        }
        if (!mongoOps.collectionExists(UnidadeFederacao.class)) {
            mongoOps.createCollection(UnidadeFederacao.class);
        }
        if (!mongoOps.collectionExists(MesoRegiao.class)) {
            mongoOps.createCollection(MesoRegiao.class);
        }
        if (!mongoOps.collectionExists(MicroRegiao.class)) {
            mongoOps.createCollection(MicroRegiao.class);
        }
        if (!mongoOps.collectionExists(Municipio.class)) {
            mongoOps.createCollection(Municipio.class);
        }
    }

    @Test
    public void cargaInsercaoRegiaoJSON() {
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

    @Test
    public void cargaInsercaoUFJSON() {
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

    @Test
    public void cargaInsercaoMesoRegiaoJSON() {
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

    @Test
    public void cargaInsercaoMicroRegiaoJSON() {
    	try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream is = MesoRegiaoRepositorioTest.class.getResourceAsStream("/microregiao.json");
			List<MicroRegiao> microsRegioes = mapper.readValue(is, new TypeReference<List<MicroRegiao>>(){}); 
			for (MicroRegiao microRegiao : microsRegioes) {
				microRegiaoRepositorio.insert(microRegiao);
			}
		} catch (Exception e) {
			Assert.assertTrue(Boolean.FALSE);
		}    	
    }
    
    @Test
    public void cargaInsercaoMunicipioJSON() {
    	try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream is = MesoRegiaoRepositorioTest.class.getResourceAsStream("/municipio.json");
			List<Municipio> municipios = mapper.readValue(is, new TypeReference<List<Municipio>>(){}); 
			for (Municipio municipio : municipios) {
				municipioRepositorio.insert(municipio);
			}
		} catch (Exception e) {
			Assert.assertTrue(Boolean.FALSE);
		}    	
    }
    
}
