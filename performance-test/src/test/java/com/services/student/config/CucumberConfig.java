package com.services.student.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.student.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

@Configuration
public class CucumberConfig {

    private static final String ROOT_URI_FORMAT = "http://%s:%s";

    @Bean
    public RestTemplate restTemplate(@Value("${hostname:localhost}") String host, @Value("${port:8080}") String port) {

        String baseHost = format(ROOT_URI_FORMAT, host, port);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new RootUriTemplateHandler(baseHost));
        return restTemplate;
    }

    @Bean
    public RestClient restClient(RestTemplate restTemplate) {
        return new RestClient(restTemplate);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}