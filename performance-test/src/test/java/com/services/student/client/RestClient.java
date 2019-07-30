package com.services.student.client;

import com.services.student.model.Student;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.List;

public class RestClient {

    private RestTemplate restTemplate;
    private static final String BASE_URL = "/students";

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Void> postStudent(Student student) {
        return restTemplate.postForEntity(BASE_URL, student, Void.class);
    }

    public ResponseEntity<List<Student>> getAllStudents() {
        return restTemplate.exchange(BASE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {
        });
    }

    public void deleteStudent(String id) {
        restTemplate.delete(BASE_URL + File.separator + id);
    }
}