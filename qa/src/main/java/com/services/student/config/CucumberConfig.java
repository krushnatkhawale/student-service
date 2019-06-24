package com.services.student.config;

import com.services.student.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static java.lang.String.format;
import static java.util.Arrays.asList;

@Configuration
public class CucumberConfig {

    public static final String ROOT_URI_FORMAT = "http://%s:%s";
    private String host;

    @Value("${port}")
    private String port;

    @Bean
    public RestTemplate restTemplate(@Value("${hostname}") String host, @Value("${hostname}") String port) {
        String baseHost = format(ROOT_URI_FORMAT, host, port);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(asList(converter));
        return restTemplate;
    }

    @Bean
    public RestClient restClient(RestTemplate restTemplate) {
        return new RestClient(restTemplate);
    }
}