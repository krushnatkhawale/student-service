package com.services.student.interceptor;

import com.services.student.client.RestClient;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Interceptor {

<<<<<<< Updated upstream
    @Before
    public void beforeScenario() {
        System.out.println("This will run before the Scenario");
    }

    @After
    public void afterScenario() {
        System.out.println("This will run after the Scenario");
    }
}
=======
    private static final Logger LOGGER = LoggerFactory.getLogger(Interceptor.class);
    private static final String PRE_PROCESSING = "Performance tests pre-processing";
    private static final String POST_PROCESSING = "Performance tests post-processing";

    private final RestClient restClient;
    private List<String> allStudents;

    public Interceptor(RestClient restClient) {
        this.restClient = restClient;
    }

    @Before
    public void beforeScenario() {

        fetchAllRecordIdsFromAPI(PRE_PROCESSING);
        deleteAllRecordsBeforePerformanceTests(POST_PROCESSING);
    }

    @After
    public void afterScenario() {
        fetchAllRecordIdsFromAPI(PRE_PROCESSING);
        deleteAllRecordsBeforePerformanceTests(POST_PROCESSING);
    }


    private void deleteAllRecordsBeforePerformanceTests(String when) {
        LOGGER.info("{} - Deleting {} records from DB before running performance tests", when, allStudents.size());
        allStudents.forEach(restClient::deleteStudent);
    }

    private void fetchAllRecordIdsFromAPI(String when) {
        ResponseEntity<List<Student>> allStudentsResponse = restClient.getAllStudents();

        if (allStudentsResponse.getStatusCode() == HttpStatus.OK) {
            allStudents = allStudentsResponse.getBody()
                    .stream()
                    .map(Student::getId)
                    .collect(Collectors.toList());
            LOGGER.info("{} - Number of records found in DB are: {}", when, allStudents.size());
        }
    }
}
>>>>>>> Stashed changes
