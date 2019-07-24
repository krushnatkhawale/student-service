Feature: Post student feature
  @Regression @SmokeTest
  Scenario: Create a student profile
    Given A student is ready
    When post endpoint is hit
    Then a student profile is created