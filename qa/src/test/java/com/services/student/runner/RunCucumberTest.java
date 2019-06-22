package com.services.student.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"src/test/java/com/services/student/steps"},
        plugin = {"pretty", "html:build/reports/cucumber"},
        tags = "@SmokeTest")
public class RunCucumberTest {

}