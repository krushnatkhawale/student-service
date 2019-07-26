package com.services.student.steps;

import com.services.student.CucumberApp;
import com.services.student.client.RestClient;
import com.services.student.model.Student;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.OK;

@ContextConfiguration(classes = CucumberApp.class, loader = SpringBootContextLoader.class)
public class PostStudentStepDefinitions {

    private Student student;
    private RestClient client;
    private ResponseEntity<Void> postResponseEntity;

    public PostStudentStepDefinitions(@Autowired RestClient client) {
        this.client = client;
    }

    @Given("A {string} with sample student record")
    public void aWithSampleStudentRecord(String arg0) {

    }

    @And("a list of {int} records is generated")
    public void aListOfRecordsIsGenerated(int arg0) {
    }

    @When("each record is posted individually")
    public void eachRecordIsPostedIndividually() {

    }

    @Then("a student profile is created within {int} second")
    public void aStudentProfileIsCreatedWithinSecond(int arg0) {

    }
}