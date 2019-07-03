Feature: Get student feature
  @Regression @SmokeTest
  Scenario Outline: Retrieve a created student profile
    Given <firstName>, <lastName>, <email> of a student
    And that student is posted successfully
    When getAll endpoint is hit
    Then response code is 200

    Examples:
    | firstName | lastName | email    |
    | John      | Kale     | jnk@g.com|
    | Johny     | Khule    | jny@g.com|