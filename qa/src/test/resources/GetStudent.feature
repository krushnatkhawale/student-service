Feature: Get student feature
  Scenario: Retrieve a student profile
    Given A student is ready
    When post endpoint is hit
    Then a student profile is created