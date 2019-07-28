package com.services.student.steps;

import com.services.student.CucumberApp;
import com.services.student.client.RestClient;
import com.services.student.model.Student;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;
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

@ContextConfiguration(classes = CucumberApp.class, loader = SpringBootContextLoader.class)
public class PostStudentStepDefinitions {

    private Student student;
    private RestClient client;
    private ResponseEntity<Void> postResponseEntity;
    private String rawRecord;
    private List<JSONObject> records;

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

    private JSONObject generateNewRecord(int recordCount) {
        try {
            JSONObject record = new JSONObject(rawRecord);
            record.put("firstName", record.getString("firstName") + recordCount);
            record.put("lastName", record.getString("lastName") + recordCount);
            record.put("email", record.getString("email") + recordCount);
            return record;
        } catch (JSONException e) {
            throw new RuntimeException("Error while generating record: " + e.getMessage());
        }
    }

    @When("each record is posted individually")
    public void eachRecordIsPostedIndividually() {
        records.forEach(System.out::println);
    }

    @Then("a student profile is created within {int} second")
    public void aStudentProfileIsCreatedWithinSecond(int arg0) {

    }
}