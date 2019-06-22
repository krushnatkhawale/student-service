Feature: Put student feature
  Scenario: Put a student profile
    Given A student is ready
    When put endpoint is hit
    Then a student profile is updated