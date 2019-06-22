Feature: Get student feature
  Scenario: Retrieve a student profile
    Given A student is ready
    When get endpoint is hit
    Then a student profile is retrieved