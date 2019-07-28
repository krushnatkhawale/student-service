Feature: Post student feature
  @PerformanceTest
  Scenario: Create a student profile stress tests
    Given A file "raw-student-record.txt" with sample student record
    And a list of 100 records is generated
    When each record is posted individually
    Then a student profile is created within 1 second