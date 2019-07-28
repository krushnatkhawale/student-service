package com.services.student.steps;

import com.services.student.CucumberApp;
import com.services.student.client.RestClient;
import com.services.student.model.RequestStats;
import com.services.student.model.Student;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

@ContextConfiguration(classes = CucumberApp.class, loader = SpringBootContextLoader.class)
public class PostStudentStepDefinitions {

    private Student student;
    private RestClient client;
    private ResponseEntity<Void> postResponseEntity;
    private String rawRecord;
    private List<Student> records;
    private List<RequestStats> postStats;
    private static final Logger LOGGER = LoggerFactory.getLogger(PostStudentStepDefinitions.class);

    public PostStudentStepDefinitions(@Autowired RestClient client) {
        this.client = client;
    }

    @Given("A file {string} with sample student record")
    public void aWithSampleStudentRecord(String fileName) throws IOException {
        File file = ResourceUtils.getFile("classpath:" + fileName);
        rawRecord = Files.lines(file.toPath())
                .collect(Collectors.joining());
    }

    @And("a list of {int} records is generated")
    public void aListOfRecordsIsGenerated(int noOfRecords) {
        records = IntStream.rangeClosed(1, noOfRecords)
                .mapToObj(recordCount -> generateNewRecord(recordCount))
                .collect(Collectors.toList());
    }

    private Student generateNewRecord(int recordCount) {
        try {
            JSONObject record = new JSONObject(rawRecord);
            return new Student(
                    record.getString("firstName") + recordCount,
                    record.getString("lastName") + recordCount,
                    record.getString("email") + recordCount
            );
        } catch (JSONException e) {
            throw new RuntimeException("Error while generating record: " + e.getMessage());
        }
    }

    @When("each record is posted individually")
    public void eachRecordIsPostedIndividually() {

        postStats = records.stream()
                .map(this::postARecord)
                .collect(Collectors.toList());
    }


    @Then("a student profile is created within {int} second")
    public void aStudentProfileIsCreatedWithinSecond(int sla) {
        long slaInMillis = sla * 1000;

        testSLA(slaInMillis);
    }

    private void testSLA(long sla) {
        double average = postStats.stream().mapToLong(RequestStats::getDuration).average().getAsDouble();
        LOGGER.info("Expected sla: {}, actual sla: {}", sla, average);
        assertTrue(average< sla);
    }

    private RequestStats postARecord(Student student) {
        String key = student.getEmail();
        long startRequestTime = System.currentTimeMillis();
        ResponseEntity<Void> responseEntity = client.postStudent(student);
        long duration = System.currentTimeMillis() - startRequestTime;
        LOGGER.info("Time taken by record for key '{}' is {}", key, duration);
        return new RequestStats(key, responseEntity.getStatusCodeValue(), duration);
    }
}