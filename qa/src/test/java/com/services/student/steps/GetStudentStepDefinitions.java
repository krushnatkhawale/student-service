package com.services.student.steps;

import com.services.student.client.RestClient;
import com.services.student.model.Student;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetStudentStepDefinitions {

    private Student student;
    private RestClient client;
    private ResponseEntity<Void> postResponseEntity;
    private ResponseEntity<List> allStudents;

    public GetStudentStepDefinitions(@Autowired RestClient client) {
        this.client = client;
    }

    @When("getAll endpoint is hit")
    public void getallEndpointIsHit() {
        allStudents = client.getAllStudents();
    }

    @Then("a student profile is retrieved")
    public void aStudentProfileIsRetrieved() {
    }

    @Then("response code is 200")
    public void responseCodeIs() {
        assertEquals(allStudents.getStatusCode(), HttpStatus.OK);
    }
}
