package com.services.student.client;

import com.services.student.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

    private RestTemplate restTemplate;

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Void> postStudent(Student student) {
        return restTemplate.postForEntity("", student, Void.class);
    }

    public Student getStudent(String id) {
        return null;
    }
}