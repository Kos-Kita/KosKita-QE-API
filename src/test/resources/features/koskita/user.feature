@test
Feature: Endpoint User

  @USR001
  Scenario Outline: Post create user with all parameters
    Given Post Create user with valid "<json>"
    When Send request post create user
    Then Status code should be 200
    And Response body message was "success insert user"
    And Validate login user json schema "CreateUserSchema.json"
    Examples:
      | json            |
      | CreateUser.json |

  @USR002
  Scenario Outline: Post create user with empty json
    Given Post Create user with valid "<json>"
      When Send request post create user
    Then Status code should be 400
    And Response body message contains "error insert data"
    Examples:
      | json                 |
      | CreateUserEmpty.json |

  @USR003
  Scenario Outline: Post create user with invalid credential
    Given Post Create user with invalid "<json>"
    When Send request post create user
    Then Status code should be 400
    And Response body message contains "error insert data"
    Examples:
      | json                              |
      | CreateUserInvalidCredential.json  |

  @USR004
  Scenario Outline: Create user with all parameters with one parameter missing
    Given Post Create user with invalid "<json>"
    When Send request post create user
    Then Status code should be 400
    And Response body message contains "error insert data"
    Examples:
      | json                               |
      | CreateUserOneParameterMissing.json |

  @USR005
  Scenario Outline: Login user renter with valid credential
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login" and role was "renter"
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
     | json                  |
      | LoginUserRenter2.json |


  @USR006
  Scenario Outline: Login user renter with invalid credential email
    Given Login users with invalid "<json>"
    When Send request login user
    Then Status code should be 400
    And Response body message was "error login.  Invalid email or password"
    Examples:
      | json                        |
      | LoginUserRenterInvalidEmail.json |

  @USR007
  Scenario Outline: Login user renter with invalid credential password
    Given Login users with invalid "<json>"
    When Send request login user
    Then Status code should be 400
    And Response body message was "error login.  Invalid email or password"
    Examples:
      | json                                |
      | LoginUserRenterInvalidPassword.json |


  Scenario Outline: Post create user owner with all parameters
    Given Post Create user with valid "<json>"
    When Send request post create user
    Then Status code should be 200
    And Response body message was "success insert user"
#    And Validate login user json schema "CreateUserSchema.json"
    Examples:
      | json                 |
      | CreateUserOwner.json |

  @USR008
  Scenario Outline: Login user owner with valid credential
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login"
    Examples:
      | json                |
      | LoginUserOwner3.json |

  @USR009
  Scenario Outline: Login user owner with invalid credential email
    Given Login users with invalid "<json>"
    When Send request login user
    Then Status code should be 400
    And Response body message was "error login.  Invalid email or password"
    Examples:
      | json                        |
      | LoginUserOwnerInvalidEmail.json |

  @USR010
  Scenario Outline: Login user owner with invalid credential password
    Given Login users with invalid "<json>"
    When Send request login user
    Then Status code should be 400
    And Response body message was "error login.  Invalid email or password"
    Examples:
      | json                                |
      | LoginUserOwnerInvalidPassword.json  |


  @USR011
  Scenario Outline: Get my user profile success
    Given Login users with valid "<json>"
    When Send request login user
    And Send request get user profile
    Then Status code should be 200
    And Response body message was "success read data"
    And Validate get kos_id json schema "GetUserProfileValidIDSchema.json"
    Examples:
      | json        |
      | LoginUserOwner.json |

  @USR012
  Scenario: Get my user profile without login
    When Send request get user profile without token
    Then Status code should be 401
    And Response body message was "missing or malformed jwt"

    #usr0013 belum karena token blm expirred, nuggu expired baru dicoba
  #usr0014 tidak jadi makanya dihapus


  @USR015
  Scenario Outline: Update user with all parameters
    Given Login users with valid "<json>"
    When Send request login user
    And Update user body name was "<name>" user_name was "<user_name>" email was "<email>" password was "<password>" photo_profile was "<photo_profile>" and gender was "<gender>" and send request
    Then Status code should be 200
    And Response body message was "success update data"
    Examples:
      | json                  | name        | user_name   | email                | password | photo_profile                                     | gender |
      | LoginUserRenter2.json | juliowner2 | juliowner2 | juliowner2@gmail.com | user123  | C:\\Users\\keian\\Downloads\\BAHAN\\download.jpeg | male   |


  @USR016
  Scenario Outline: Update user gender
    Given Login users with valid "<json>"
    When Send request login user
    And Update user body name was gender was "<gender>" and send request
    Then Status code should be 400
    And Response body message contains "error update data."
    Examples:
      | json                  | gender |
      | LoginUserRenter2.json | male   |


  @USR017
  Scenario Outline: Update user invalid email
    Given Login users with valid "<json>"
    When Send request login user
    And Update user body name was email was "<email>" and send request
    Then Status code should be 400
    And Response body message contains "error update data."
    Examples:
      | json                  | email |
      | LoginUserRenter2.json | usergender7gmail.com   |

  @USR018
  Scenario Outline: Update user invalid password
    Given Login users with valid "<json>"
    When Send request login user
    And Update user body name was password was "<password>" and send request
    Then Status code should be 400
    And Response body message contains "error update data."
    Examples:
      | json                  | password  |
      | LoginUserRenter2.json | juliowner |

#    belum diubah BE status harusnya 200 bukan 400 dan error messagenya gak cocok
  @USR019
  Scenario Outline: Update user valid password
    Given Login users with valid "<json>"
    When Send request login user
    And Update user body name was password was "<password>" and send request
    Then Status code should be 400
#    And Response body message was "success update data"
    Examples:
      | json                  | password |
      | LoginUserRenter2.json | juliowner        |

  @USR019
  Scenario Outline: Update password with old incorrect password
    Given Login users with valid "<json>"
    When Send request login user
    And Update user body name was password was "<password>" and send request
    Then Status code should be 400
    And Response body message contains "error update data."
    Examples:
      | json                  | password |
      | LoginUserRenter2.json | juliowner        |


    #USR020 gk dipakai kayaknya karena old_password blm ada di server
#  @USR020
#  Scenario Outline: Update password with old incorrect password
#    Given Login users with valid "<json>"
#    When Send request login user
#    And Update user body name was password was "<password>" and send request
#    Then Status code should be 200
#    And Response body message was "Passwords cannot be the same"
#    Examples:
#      | json                  | password         |
#      | LoginUserRenter2.json | passwordbaru2024 |


  @USR021
  Scenario Outline: Delete user with valid id
    Given Login users with valid "<json>"
    When Send request login user
    And  User delete with valid id
    When Send request delete user
    Then Status code should be 200
    And Response body message was "success delete data"
    Examples:
      | json                  |
      | LoginUserRenter3.json |

  @USR022
  Scenario: Delete user without login
    When Send request delete user
    And Status code should be 401
    Then Response body message was "missing or malformed jwt"

  @USR023
  Scenario Outline: Delete user with invalid id
    Given Login users with invalid "<json>"
    When Send request login user
    And  User delete with valid id
    When Send request delete user
    Then Status code should be 401
    And Response body message was "invalid or expired jwt"
    Examples:
      | json                  |
      | LoginUserRenter3.json |

