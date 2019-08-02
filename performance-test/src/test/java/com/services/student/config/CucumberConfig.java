package com.services.student.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.student.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static java.lang.String.format;

@Configuration
public class CucumberConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(CucumberConfig.class);
    private static final String ROOT_URI_FORMAT = "http://%s:%s";

    @Bean
    public RestTemplate restTemplate(@Value("${hostname:localhost}") String host, @Value("${port:8080}") String port, ResponseErrorHandler errorHandler) {

        String baseHost = format(ROOT_URI_FORMAT, host, port);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new RootUriTemplateHandler(baseHost));
        restTemplate.setErrorHandler(errorHandler);
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


    @Bean
    public ResponseErrorHandler errorHandler() {
        return new
                ResponseErrorHandler() {
                    @Override
                    public boolean hasError(ClientHttpResponse response) throws IOException {
                        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                            return false;
                        }
                        return true;
                    }

                    @Override
                    public void handleError(ClientHttpResponse response) throws IOException {
                        LOGGER.error("Error while making http request: {}", response.getStatusText());
                    }
                };
    }
}