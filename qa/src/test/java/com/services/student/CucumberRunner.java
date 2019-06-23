package com.services.student;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources"},
        glue = {"com.services.student"},
        plugin = {"pretty", "html:build/reports/cucumber"})
public class CucumberRunner {

}