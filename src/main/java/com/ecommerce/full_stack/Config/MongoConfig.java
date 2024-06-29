package com.ecommerce.full_stack.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean
    public void logMongoUri() {
        System.out.println("Mongo URI: " + mongoUri);
    }
}
