package com.services.student.steps;

import com.services.student.client.RestClient;
import com.services.student.model.Student;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.OK;

public class PostStudentStepDefs {
    private Student student;

    @Autowired
    private RestClient client;
    private ResponseEntity<Student> postStudentResponseEntity;

    @Given("^A student is ready$")
    public void aStudentIsReady() {
        student = new Student();
    }

    @When("^post endpoint is hit$")
    public void postEndpointIsHit() {
        postStudentResponseEntity = client.postStudent(student);
    }

    @Then("^a student profile is created$")
    public void aStudentProfileIsCreated() {
        assertEquals(postStudentResponseEntity.getStatusCode(), OK);
    }
}
