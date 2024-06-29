package com.ecommerce.full_stack.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Value("${mongodb://mongo:USYCIyiyKkvOnhoDyjjKRGaJqiFoqjGe@viaduct.proxy.rlwy.net:36810/ecom}")
    private String mongoUri;

    @Bean
    public void logMongoUri() {
        System.out.println("Mongo URI: " + mongoUri);
    }
}
