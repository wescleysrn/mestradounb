package br.com.unb.wescley.mongodb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.unb.wescley.mongodb.dao")
public class ConfiguracaoMongo extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "bdm";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Override
    public String getMappingBasePackage() {
        return "br.com.unb.wescley.mongodb";
    }
    
}
