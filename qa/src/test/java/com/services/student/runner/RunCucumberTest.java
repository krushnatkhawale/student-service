package com.services.student.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber"})
public class RunCucumberTest{
}