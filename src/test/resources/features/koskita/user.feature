Feature: Endpoint User

  Scenario Outline: Login owner with valid data
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login" and role was "owner"
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
      | json           |
      | LoginUser.json |

  Scenario Outline: Login renter with valid data
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login" and role was "renter"
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
      | json           |
      | LoginUser.json |

  Scenario Outline: Login user renter with invalid credential email
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 400
    And Response body message was "success read data."
    Examples:
      | json           |
      | LoginUser.json |