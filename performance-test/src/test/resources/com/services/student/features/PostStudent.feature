Feature: Post student feature
  @PerformanceTest
  Scenario: POST student profile stress tests - sequential
    Given A file "raw-student-record.txt" with sample student record
    And a list of 1000 records is generated
    When each record is posted individually
    Then a student profile is created within 1 second


  @PerformanceTest
  Scenario: POST student profile stress tests - parallel
    Given A file "raw-student-record.txt" with sample student record
    And a list of 1000 records is generated
    When each record is posted individually parallely
    Then a student profile is created within 1 second