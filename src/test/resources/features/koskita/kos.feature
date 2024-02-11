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

#KOS001
  Scenario Outline: Get kos with valid kos_id
    Given Get kos with valid "<kos_id>"
    When Send request get single kos
    Then Status code should be 200
    And Response body message was "success read data."
    And Validate get kos_id json schema "GetSingleKosSchema.json"
    Examples:
      | kos_id |  |
      | 9      |  |

#KOS002
  Scenario Outline: Get kos with invalid kos_id
    Given Get kos with valid "<kos_id>"
    When Send request get single kos
    Then Status code should be 400
    And Response body message was "id kos salah"
    Examples:
      | kos_id |  |
      | 5tw    |  |

#KOS003
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

#KOS004
  Scenario Outline: Get my kos without login
    Given Login users with valid "<json>"
    When Send request login user
    And Get my kos
    When Send request get my kos
    Then Status code should be 401
    And Response body message was "invalid or expired jwt"
    Examples:
      | json                |
      | LoginUserEmpty.json |

#KOS005
  Scenario Outline: Successful kos search with all param
    Given Get search kos with param "<address>" "<category>" "<minPrice>" "<maxPrice>"
    When Send request get kos
    Then Status code should be 200
    And Response body message was "success get kos"
    And Validate get kos_id json schema "GetKosSchema.json"
    Examples:
      | address | category | minPrice | maxPrice |
      | jakarta | campur   | 10000    | 1000001  |

#KOS006
  Scenario Outline: Successful kos search with only one param
    Given Get search kos with param "<address>" "<category>" "<minPrice>" "<maxPrice>"
    When Send request get kos
    Then Status code should be 200
    And Response body message was "success get kos"
    And Validate get kos_id json schema "GetKosSchema.json"
    Examples:
      | address | category | minPrice | maxPrice |
      | jakarta |          |          |          |

#KOS007
  Scenario Outline: Empty kos search
    Given Get search kos with param "<address>" "<category>" "<minPrice>" "<maxPrice>"
    When Send request get kos
    Then Status code should be 200
    And Response body message was "success get kos"
    And Validate get kos_id json schema "GetKosSchema.json"
    Examples:
      | address | category | minPrice | maxPrice |
      |         |          |          |          |

#KOS008
  Scenario Outline: Invalid kos search with invalid param
    Given Get search kos with param "<address>" "<category>" "<minPrice>" "<maxPrice>"
    When Send request get kos
    Then Status code should be 400
    And Response body message was "invalid search param"
    Examples:
      | address | category | minPrice | maxPrice |
      |         | wakwaw   |          |          |

#KOS009
  Scenario: Get recommendation kos
    Given Get kos
    When Send request get kos recommendation
    Then Status code should be 200
    And Response body message was "success get kos"
    And Validate get kos_id json schema "GetKosSchema.json"

#KOS010
  Scenario Outline: Create kos with all parameters using role owner
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Create kos using "<CreateJson>" and send request
    Then Status code should be 200
    And Response body message was "success create kos"
    Examples:
      | UserJson            | CreateJson         |
      | LoginUserOwner.json | CreateKosJson.json |

#KOS011
  Scenario Outline: Create kos with all parameters using role renter
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Create kos using "<CreateJson>" and send request
    Then Status code should be 401
    And Response body message was "anda bukan owner"
    Examples:
      | UserJson             | CreateJson         |
      | LoginUserRenter.json | CreateKosJson.json |

  Scenario Outline: Create kos with all parameters without login
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Create kos using "<CreateJson>" and send request
    Then Status code should be 401
    And Response body message was "invalid or expired jwt"
    Examples:
      | UserJson            | CreateJson         |
      | LoginUserEmpty.json | CreateKosJson.json |

  Scenario Outline: Create kos with all parameters except kos_name
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Create kos using "<CreateJson>" and send request
    Then Status code should be 400
    And Response body message was "name anda kosong"
    Examples:
      | UserJson            | CreateJson          |
      | LoginUserOwner.json | CreateKosJson1.json |

  Scenario Outline: Update kos with valid kos_id using role owner
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update kos with "<kos_id>" using "<json>" and send request
    Then Status code should be 200
    And Response body message was "success update kos"
    Examples:
      | kos_id | json           | UserJson            |
      | 9      | UpdateKos.json | LoginUserOwner.json |

  Scenario Outline: Update kos with valid kos_id using role renter
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update kos with "<kos_id>" using "<json>" and send request
    Then Status code should be 401
    And Response body message was "anda bukan owner"
    Examples:
      | kos_id | json           | UserJson            |
      | 9      | UpdateKos.json | LoginUserRenter.json |


  Scenario Outline: Update kos with valid kos_id without login
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update kos with "<kos_id>" using "<json>" and send request
    Then Status code should be 401
    And Response body message was "invalid or expired jwt"
    Examples:
      | kos_id | json           | UserJson            |
      | 9      | UpdateKos.json | LoginUserEmpty.json |

  Scenario Outline: Update kos with invalid kos_id using role owner
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update kos with "<kos_id>" using "<json>" and send request
    Then Status code should be 400
    And Response body message was "error parsing kos id"
    Examples:
      | kos_id | json           | UserJson            |
      | gyg32  | UpdateKos.json | LoginUserOwner.json |

  Scenario Outline: Update one of the parameters with valid kos_id using role owner
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update kos with "<kos_id>" using "<json>" and send request
    Then Status code should be 200
    And Response body message was "success update kos"
    Examples:
      | kos_id | json            | UserJson            |
      | 9      | UpdateKos1.json | LoginUserOwner.json |

  Scenario Outline: Delete kos with valid kos_id using role owner
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Delete kos with "<kos_id>" and send request
    Then Status code should be 200
    And Response body message was "success delete kos"
    Examples:
      | kos_id | UserJson            |
      | 14     | LoginUserOwner.json |

  Scenario Outline: Delete kos with valid kos_id using role renter
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Delete kos with "<kos_id>" and request
    Then Status code should be 400
    And Response body message was "kos ini bukan milik Anda"
    Examples:
      | kos_id | UserJson             |
      | 3      | LoginUserRenter.json |

  Scenario Outline: Delete kos other people with valid kos_id using role owner
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Delete kos with "<kos_id>" and request
    Then Status code should be 400
    And Response body message was "kos ini bukan milik Anda"
    Examples:
      | kos_id | UserJson        |
      | 3      | LoginUserOwner.json |

  Scenario Outline: Delete kos without kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Delete kos with "<kos_id>" and request
    Then Status code should be 405
    And Response body message was "Method Not Allowed"
    Examples:
      | kos_id | UserJson            |
      |        | LoginUserOwner.json |

#IMG001
  Scenario Outline: Post photo using role owner with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Post photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
    Then Status code should be 200
    And Response body message was "success upload image"
    Examples:
      | kos_id | UserJson            | main_kos_photo                                      | front_kos_photo                        | back_kos_photo                         | front_room_photo                        | inside_room_photo                      |
      | 14     | LoginUserOwner.json | C:\\Users\\keian\\Downloads\\2.-usaha-kos-kosan.jpg | C:\\Users\\keian\\Downloads\\kos 5.jpg | C:\\Users\\keian\\Downloads\\kos 2.jpg | C:\\Users\\keian\\Downloads\\kos 3.jpeg | C:\\Users\\keian\\Downloads\\kos 4.jpg |

#IMG002
  Scenario Outline: Post photo using role renter with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Post photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
    Then Status code should be 401
    And Response body message was "error upload image -> anda bukan owner"
    Examples:
      | kos_id | UserJson        | main_kos_photo                                      | front_kos_photo                        | back_kos_photo                         | front_room_photo                        | inside_room_photo                      |
      | 14     | LoginUserRenter.json | C:\\Users\\keian\\Downloads\\2.-usaha-kos-kosan.jpg | C:\\Users\\keian\\Downloads\\kos 5.jpg | C:\\Users\\keian\\Downloads\\kos 2.jpg | C:\\Users\\keian\\Downloads\\kos 3.jpeg | C:\\Users\\keian\\Downloads\\kos 4.jpg |

#IMG003
  Scenario Outline: Post photo using kos_id without login
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Post photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
    Then Status code should be 401
    And Response body message was "invalid or expired jwt"
    Examples:
      | kos_id | UserJson            | main_kos_photo                                      | front_kos_photo                        | back_kos_photo                         | front_room_photo                        | inside_room_photo                      |
      | 14     | LoginUserEmpty.json | C:\\Users\\keian\\Downloads\\2.-usaha-kos-kosan.jpg | C:\\Users\\keian\\Downloads\\kos 5.jpg | C:\\Users\\keian\\Downloads\\kos 2.jpg | C:\\Users\\keian\\Downloads\\kos 3.jpeg | C:\\Users\\keian\\Downloads\\kos 4.jpg |

#IMG004
  Scenario Outline: Post empty photo using role owner with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Post photo using "<kos_id>" with empty and send request
    Then Status code should be 400
    And Response body message was "masukan semua foto"
    Examples:
      | kos_id | UserJson            | main_kos_photo | front_kos_photo | back_kos_photo | front_room_photo | inside_room_photo |
      | 14     | LoginUserOwner.json | empty          |        empty          |         empty        |        empty           |          empty          |

#IMG005
  Scenario Outline: Post only 1 photo using the owner role with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Post photo using "<kos_id>" with "<main_kos_photo>" and send request
    Then Status code should be 400
    And Response body message was "masukan semua foto"
    Examples:
      | kos_id | UserJson            | main_kos_photo                                      | front_kos_photo                        | back_kos_photo                         | front_room_photo                        | inside_room_photo                      |
      | 14     | LoginUserOwner.json | C:\\Users\\keian\\Downloads\\2.-usaha-kos-kosan.jpg | C:\\Users\\keian\\Downloads\\kos 5.jpg | C:\\Users\\keian\\Downloads\\kos 2.jpg | C:\\Users\\keian\\Downloads\\kos 3.jpeg | C:\\Users\\keian\\Downloads\\kos 4.jpg |

#IMG006
  Scenario Outline: Update photo using role owner with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
    Then Status code should be 200
    And Response body message was "success upload image"
    Examples:
      | kos_id | UserJson        | main_kos_photo                                      | front_kos_photo                        | back_kos_photo                         | front_room_photo                        | inside_room_photo                      |
      | 14     | LoginUserOwner.json | C:\\Users\\keian\\Downloads\\2.-usaha-kos-kosan.jpg | C:\\Users\\keian\\Downloads\\kos 5.jpg | C:\\Users\\keian\\Downloads\\kos 2.jpg | C:\\Users\\keian\\Downloads\\kos 3.jpeg | C:\\Users\\keian\\Downloads\\kos 4.jpg |

#IMG007
  Scenario Outline: Update photo using role renter with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
    Then Status code should be 401
    And Response body message was "error upload imageanda bukan owner"
    Examples:
      | kos_id | UserJson        | main_kos_photo                                      | front_kos_photo                        | back_kos_photo                         | front_room_photo                        | inside_room_photo                      |
      | 14     | LoginUserRenter.json | C:\\Users\\keian\\Downloads\\2.-usaha-kos-kosan.jpg | C:\\Users\\keian\\Downloads\\kos 5.jpg | C:\\Users\\keian\\Downloads\\kos 2.jpg | C:\\Users\\keian\\Downloads\\kos 3.jpeg | C:\\Users\\keian\\Downloads\\kos 4.jpg |

#IMG008
  Scenario Outline: Update photo using kos_id without login
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update photo using "<kos_id>" with "<main_kos_photo>" "<front_kos_photo>" "<back_kos_photo>" "<front_room_photo>" "<inside_room_photo>" and send request
    Then Status code should be 401
    And Response body message was "invalid or expired jwt"
    Examples:
      | kos_id | UserJson           | main_kos_photo                                      | front_kos_photo                        | back_kos_photo                         | front_room_photo                        | inside_room_photo                      |
      | 14     | LoginUserEmpty.json | C:\\Users\\keian\\Downloads\\2.-usaha-kos-kosan.jpg | C:\\Users\\keian\\Downloads\\kos 5.jpg | C:\\Users\\keian\\Downloads\\kos 2.jpg | C:\\Users\\keian\\Downloads\\kos 3.jpeg | C:\\Users\\keian\\Downloads\\kos 4.jpg |

#IMG009
  Scenario Outline: Update empty photo using role owner with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update photo using "<kos_id>" with empty and send request
    Then Status code should be 400
    And Response body message was "masukan semua foto"
    Examples:
      | kos_id | UserJson        | main_kos_photo                                      | front_kos_photo                        | back_kos_photo                         | front_room_photo                        | inside_room_photo                      |
      | 14     | LoginUserOwner.json | C:\\Users\\keian\\Downloads\\2.-usaha-kos-kosan.jpg | C:\\Users\\keian\\Downloads\\kos 5.jpg | C:\\Users\\keian\\Downloads\\kos 2.jpg | C:\\Users\\keian\\Downloads\\kos 3.jpeg | C:\\Users\\keian\\Downloads\\kos 4.jpg |

#IMG010
  Scenario Outline: Update only 1 photo using the owner role with kos_id
    Given Login users with valid "<UserJson>"
    When Send request login user
    And Update photo using "<kos_id>" with "<main_kos_photo>" and send request
    Then Status code should be 200
    And Response body message was "success upload image"
    Examples:
      | kos_id | UserJson        | main_kos_photo                                      | front_kos_photo                        | back_kos_photo                         | front_room_photo                        | inside_room_photo                      |
      | 14     | LoginUserOwner.json | C:\\Users\\keian\\Downloads\\2.-usaha-kos-kosan.jpg | C:\\Users\\keian\\Downloads\\kos 5.jpg | C:\\Users\\keian\\Downloads\\kos 2.jpg | C:\\Users\\keian\\Downloads\\kos 3.jpeg | C:\\Users\\keian\\Downloads\\kos 4.jpg |
