Feature:  as a user I want an api that allows me to create users

  @Create
  Scenario: Successful user creation
    Given the user gets api
    When the user is created successfully
    Then He should respond to a 200 status create
    Then must validate the body in the create