Feature: Get student feature
  @Regression @SmokeTest
  Scenario: Retrieve a created student profile
    Given getAll endpoint is hit
    Then response code is 200
    And a student profile is retrieved