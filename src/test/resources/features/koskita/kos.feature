Feature: Endpoint Kos

  Scenario Outline: Login owner with valid data
    Given Login users with valid "<json>"
    When Send request login user
    Then Status code should be 200
    And Response body message was "success login" and role was "owner"
    And Validate login user json schema "LoginUserSchema.json"
    Examples:
      | json           |
      | LoginUser.json |

  Scenario Outline: Get kos with valid kos_id
    Given Get kos with valid "<kos_id>"
    When Send request get single kos
    Then Status code should be 200
    And Response body message was "success read data."
    And Validate get kos_id json schema "GetSingleKosSchema.json"
    Examples:
      | kos_id |  |
      | 1      |  |

  Scenario Outline: Get kos with invalid kos_id
    Given Get kos with valid "<kos_id>"
    When Send request get single kos
    Then Status code should be 400
    And Response body message was "id kos salah"
    Examples:
      | kos_id |  |
      | 5tw    |  |

  Scenario Outline: Get my kos
    Given Login users with valid "<json>"
    When Send request login user
    And Get my kos
    And Send request get my kos
    Then Status code should be 200
    And Response body message was "success get kos"
    And Validate get kos_id json schema "GetMyKosSchema.json"
    Examples:
      | json           |
      | LoginUser.json |


  Scenario: Get my kos without login
    When Get my kos
    And Send request get my kos
    Then Status code should be 401
    And Response body message was "invalid or expired jwt"

  Scenario Outline: Successful kos search with all param
    When Get search kos with param "<address>" "<category>" "<minPrice>" "<maxPrice>"
    And Send request get kos
    Then Status code should be 200
    And Response body message was "success get kos"
    And Validate get kos_id json schema "GetKosSchema.json"
    Examples:
      | address | category | minPrice | maxPrice |
      | jakarta | campur   | 10000    | 1000001  |

  Scenario Outline: Successful kos search with only one param
    When Get search kos with param "<address>" "<category>" "<minPrice>" "<maxPrice>"
    And Send request get kos
    Then Status code should be 200
    And Response body message was "success get kos"
    And Validate get kos_id json schema "GetKosSchema.json"
    Examples:
      | address | category | minPrice | maxPrice |
      | jakarta |          |          |          |

  Scenario Outline: Empty kos search
    When Get search kos with param "<address>" "<category>" "<minPrice>" "<maxPrice>"
    And Send request get kos
    Then Status code should be 200
    And Response body message was "success get kos"
    And Validate get kos_id json schema "GetKosSchema.json"
    Examples:
      | address | category | minPrice | maxPrice |
      |         |          |          |          |

  Scenario Outline: Invalid kos search with invalid param
    When Get search kos with param "<address>" "<category>" "<minPrice>" "<maxPrice>"
    And Send request get kos
    Then Status code should be 400
    And Response body message was "invalid search param"
    Examples:
      | address | category | minPrice | maxPrice |
      |         | wakwaw   |          |          |


