package com.services.student.client;

import com.services.student.model.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static java.util.Arrays.asList;

public class RestClient {

    private RestTemplate restTemplate;
    private String postURL = "/students";

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Void> postStudent(Student student) {
        return restTemplate.
                postForEntity(postURL, (student), Void.class);
    }

    private HttpEntity<Student> getRequestEntity(Student student) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("Content-Type", asList("application/json"));
        return new HttpEntity<>(student, httpHeaders);
    }

    public Student getStudent(String id) {
        return null;
    }
}