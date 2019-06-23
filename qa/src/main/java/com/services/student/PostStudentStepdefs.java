package com.services.student;

import com.services.student.app.CucumberApp;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = CucumberApp.class, loader = SpringBootContextLoader.class)
public class PostStudentStepdefs {
    @Given("A student is ready")
    public void aStudentIsReady() {
    }

    @When("post endpoint is hit")
    public void postEndpointIsHit() {
    }

    @Then("a student profile is created")
    public void aStudentProfileIsCreated() {
    }
}