Feature: Endpoint image

 #IMG001
  Scenario Outline: Post photo using role owner with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Post photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
    Then Status code should be 403
    And Response body message was "success upload image"
    Examples:
      | kos_id | UserJson            | main_kos_photo         | front_kos_photo | back_kos_photo | front_room_photo | inside_room_photo |
      | 13     | LoginUserOwner.json | 2.-usaha-kos-kosan.jpg | depan kos.jpg   | kos 2.jpg      | kos 3.jpeg       | kos 4.jpg         |

#IMG002
  Scenario Outline: Post photo using role renter with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Post photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
    Then Status code should be 500
    And Response body message was "error upload image -> anda bukan owner"
    Examples:
      | kos_id | UserJson             | main_kos_photo | front_kos_photo | back_kos_photo | front_room_photo | inside_room_photo |
      | 13     | LoginUserRenter.json | kos 3.jpeg     | depan kos.jpg   | kos 2.jpg      | kos 3.jpeg       | kos 4.jpg         |


#IMG003
  Scenario Outline: Post photo using kos_id without login
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Post photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
    Then Status code should be 401
    And Response body message was "invalid or expired jwt"
    Examples:
      | kos_id | UserJson            | main_kos_photo         | front_kos_photo | back_kos_photo | front_room_photo | inside_room_photo |
      | 13     | LoginUserEmpty.json | 2.-usaha-kos-kosan.jpg | depan kos.jpg   | kos 2.jpg      | kos 3.jpeg       | kos 4.jpg         |

#IMG004
  Scenario Outline: Post empty photo using role owner with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Post photo using "<kos_id>" with empty and send request
    Then Status code should be 400
    And Response body message was "masukan semua foto"
    Examples:
      | kos_id | UserJson            |  |  |  |  |  |
      | 14     | LoginUserOwner.json |  |  |  |  |  |

#IMG005
  Scenario Outline: Post only 1 photo using the owner role with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Post photo using "<kos_id>" with "<main_kos_photo>" and send request
    Then Status code should be 400
    And Response body message was "masukan semua foto"
    Examples:
      | kos_id | UserJson            | main_kos_photo |  |  |  |  |
      | 14     | LoginUserOwner.json | depan kos.jpg  |  |  |  |  |

#IMG006
  Scenario Outline: Update photo using role owner with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
#    Then Status code should be 200
#    And Response body message was "success upload image"
    Examples:
      | kos_id | UserJson            | main_kos_photo         | front_kos_photo | back_kos_photo | front_room_photo | inside_room_photo |
      | 13      | LoginUserOwner.json | 2.-usaha-kos-kosan.jpg | depan kos.jpg   | kos 2.jpg      | kos 3.jpeg       | kos 4.jpg         |


#IMG007
  Scenario Outline: Update photo using role renter with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
    Then Status code should be 500
    And Response body message was "error upload imageanda bukan owner"
    Examples:
      | kos_id | UserJson             | main_kos_photo         | front_kos_photo | back_kos_photo | front_room_photo | inside_room_photo |
      | 13      | LoginUserRenter.json | 2.-usaha-kos-kosan.jpg | depan kos.jpg   | kos 2.jpg      | kos 3.jpeg       | kos 4.jpg         |


#IMG008
  Scenario Outline: Update photo using kos_id without login
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
    Then Status code should be 401
    And Response body message was "invalid or expired jwt"
    Examples:
      | kos_id | UserJson            | main_kos_photo         | front_kos_photo | back_kos_photo | front_room_photo | inside_room_photo |
      | 13      | LoginUserEmpty.json | 2.-usaha-kos-kosan.jpg | depan kos.jpg   | kos 2.jpg      | kos 3.jpeg       | kos 4.jpg         |


#IMG009
  Scenario Outline: Update empty photo using role owner with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update photo using "<kos_id>" with empty and send request
    Then Status code should be 400
    And Response body message was "error bind data. data not valid"
    Examples:
      | kos_id | UserJson            |
      | 13      | LoginUserOwner.json |

#IMG010
  Scenario Outline: Update only 1 photo using the owner role with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update photo using "<kos_id>" with "<main_kos_photo>" and send request
    Then Status code should be 200
    And Response body message was "success upload image"
    Examples:
      | kos_id | UserJson            | main_kos_photo         | front_kos_photo | back_kos_photo | front_room_photo | inside_room_photo |
      | 13      | LoginUserOwner.json | 2.-usaha-kos-kosan.jpg | depan kos.jpg   | kos 2.jpg      | kos 3.jpeg       | kos 4.jpg         |
