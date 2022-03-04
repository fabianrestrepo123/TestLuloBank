Feature:  as a user I want an api that allows me to delete users

  @DeleteSuccessful
  Scenario: Successful user delete
    Given the user gets api
    When the user is delete successfully
    Then He should respond to a 200 status in the delete
    Then must validate the body in the delete

  @DeleteFailed
  Scenario: failed user delete
    Given the user gets api
    When the user is delete failed
    Then He should respond to a 400 status

