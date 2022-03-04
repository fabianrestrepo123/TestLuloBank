Feature: As a user, I want an API to obtain employee information

  @GetEmployeeSuccessful
  Scenario: Verify employee information
    Given the user gets api
    When Get employee information successfull
    Then He should respond to a status 200
    Then he should body validation

  @GetEmployeeFailed
  Scenario: Verify employee information
    Given the user gets api
    When Get employee information failed
    Then He should respond to a 400 status