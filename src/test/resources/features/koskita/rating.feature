Feature: Endpoint Rating

#[RTG001]
Scenario Outline: Successfully rating kos using renter
  Given Login users with valid "<json>"
  When Send request login user
  And Post rating kos with id "<kos_id>" with "<RatingJson>" and send request
  Then Status code should be 200
  And Response body message was "success rating score"
  Examples:
    | json                 | kos_id | RatingJson       |  |
    | LoginUserRenter.json | 13      | RatingJson1.json |  |

  #[RTG002]
  Scenario Outline: Successfully rating kos other owner
    Given Login users with valid "<json>"
    When Send request login user
    And Post rating kos with id "<kos_id>" with "<RatingJson>" and send request
    Then Status code should be 200
    And Response body message was "success rating score"
    Examples:
      | json                | kos_id | RatingJson       |  |
      | LoginUserOwner.json | 14     | RatingJson1.json |  |

    #[RTG003]
  Scenario Outline: Invalid rating kos owner it self
    Given Login users with valid "<json>"
    When Send request login user
    And Post rating kos with id "<kos_id>" with "<RatingJson>" and send request
    Then Status code should be 500
    And Response body message was "anda sudah pernah memberikan rating untuk kos ini"
    Examples:
      | json                | kos_id | RatingJson       |  |
      | LoginUserOwner.json | 14     | RatingJson1.json |  |

    #[RTG004]
  Scenario Outline:  Invalid rating kos
    Given Login users with valid "<json>"
    When Send request login user
    And Post rating kos with id "<kos_id>" with "<RatingJson>" and send request
    Then Status code should be 500
    And Response body message was "skor hanya bisa 1 sampai 5"
    Examples:
      | json                | kos_id | RatingJson       |  |
      | LoginUserOwner.json | 13     | RatingJson2.json |  |

    #[RTG005]
  Scenario Outline: gives the rating cost that has been given a rating
    Given Login users with valid "<json>"
    When Send request login user
    And Post rating kos with id "<kos_id>" with "<RatingJson>" and send request
    Then Status code should be 500
    And Response body message was "anda sudah pernah memberikan rating untuk kos ini"
    Examples:
      | json                | kos_id | RatingJson       |  |
      | LoginUserOwner.json | 14     | RatingJson1.json |  |

