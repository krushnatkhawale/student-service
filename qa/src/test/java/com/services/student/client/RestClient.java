package com.services.student.client;

import com.services.student.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestClient {

    private RestTemplate restTemplate;
    private static final String POST_URL = "/students";

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Void> postStudent(Student student) {
        return restTemplate.postForEntity(POST_URL, student, Void.class);
    }

    public ResponseEntity<List> getAllStudents() {
        return restTemplate.getForEntity(POST_URL, List.class);
    }
}