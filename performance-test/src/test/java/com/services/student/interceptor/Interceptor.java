package com.services.student.interceptor;

import com.services.student.client.RestClient;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Interceptor {

    @Before
    public void beforeScenario() {
        System.out.println("This will run before the Scenario");
    }

    @After
    public void afterScenario() {
        System.out.println("This will run after the Scenario");
    }
}
