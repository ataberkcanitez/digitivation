package com.bilginyuksel.digitivation.infra.adapter.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration {
    private final static String DATABASE = "digitivation";
    private final static String CONNECTION_URI = "mongodb://localhost:27017";

    @Override
    public MongoClient mongoClient() {
        var connectionString = new ConnectionString(CONNECTION_URI);
        var settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(settings);
    }

    @Override
    protected String getDatabaseName() {
        return DATABASE;
    }
}
