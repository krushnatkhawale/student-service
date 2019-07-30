package com.services.student.interceptor;

import com.services.student.client.RestClient;
import com.services.student.model.Student;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Interceptor {

    private final RestClient restClient;
    private List<String> allStudents;
    private static final Logger LOGGER = LoggerFactory.getLogger(Interceptor.class);

    public Interceptor(RestClient restClient) {
        this.restClient = restClient;
    }

    @Before
    public void beforeScenario() {

        fetchAllRecordIdsFromAPI();
        deleteAllRecordsBeforePerformanceTests();
        System.out.println("This will run before the Scenario");
    }

    private void deleteAllRecordsBeforePerformanceTests() {
        LOGGER.info("Deleting all records({}) from DB before running performance tests", allStudents.size());
        allStudents.forEach(restClient::deleteStudent);
    }

    private void fetchAllRecordIdsFromAPI() {
        ResponseEntity<List<Student>> allStudentsResponse = restClient.getAllStudents();

        if (allStudentsResponse.getStatusCode() == HttpStatus.OK) {
            allStudents = allStudentsResponse.getBody()
                    .stream()
                    .map(Student::getId)
                    .collect(Collectors.toList());
            LOGGER.info("Number of records found in DB are: {}", allStudents.size());
        }
    }

    @After
    public void afterScenario() {
        System.out.println("This will run after the Scenario");
    }
}