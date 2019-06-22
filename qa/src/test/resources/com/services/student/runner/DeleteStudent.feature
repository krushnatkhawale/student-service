Feature: Delete student feature
  Scenario: Delete create a student profile
    Given A is ready
    When delete endpoint is hit
    Then a student profile is deleted