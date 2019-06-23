Feature: Post student feature
  @SmokeTest @RegressionTest
  Scenario Outline: Create a student profile
    Given A student is ready
    When post endpoint is hit
    Then a student profile is created

    Examples:
      | Name |
      | Ssaa |