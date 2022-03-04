Feature: As a user, I want an API to obtain employees information

  @GetEmployees
  Scenario: Verify employee information
    Given the user gets api
    When Get employees information
    Then He should respond to status 200 in the employees