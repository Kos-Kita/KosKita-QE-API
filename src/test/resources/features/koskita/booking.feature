Feature: Endpoint Booking User

  @BKG001
  Scenario Outline: User Success Create Booking

    Given Login users with valid "<json>"
    When Send request login user
    Given Post Create booking user with valid json "<json2>" and send request
    Then Status code should be 200
    And Response body message was "Success get booking."
    And Validate login user json schema "CreateBookingUserSchema.json"
    Examples:
      | json                   | json2                  |
      | LoginUserRenter2.json  | CreateBookingUser.json |

  @BKG002
  Scenario Outline:  User unsuccess create booking with invalid kos_id

    Given Login users with valid "<json>"
    When Send request login user
    Given Post Create booking user with valid json "<json2>" and send request
    Then Status code should be 500
    And Response body message was "error insert booking record not found"
    Examples:
      | json                   | json2                  |
      | LoginUserRenter2.json  | CreateBookingUserInvalid.json |
