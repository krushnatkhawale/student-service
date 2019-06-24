package com.services.student.client;

import com.services.student.model.Student;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class RestClient {

    private RestTemplate restTemplate;
    private String postURL = "http://localhost:8080/students";

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Void> postStudent(Student student) {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        ResponseEntity<Void> voidResponseEntity = restTemplate.
                exchange(postURL, HttpMethod.POST,getRequestEntity("{ \"aa\":\"a\"}"), Void.class);
        return  voidResponseEntity;
    }

    private HttpEntity<Student> getRequestEntity(Student student) {
        HttpHeaders httpHeaders = new HttpHeaders();
        return new HttpEntity<>(student, httpHeaders);
    }

    private HttpEntity<String> getRequestEntity(String student) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put(HttpHeaders.CONTENT_TYPE, asList(MediaType.APPLICATION_JSON_VALUE));
        return new HttpEntity<>(student, httpHeaders);
    }

    public Student getStudent(String id) {
        return null;
    }
}