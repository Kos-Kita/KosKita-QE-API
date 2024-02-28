@AllFlow
Feature: Register
  User want register to website Koskita as renter and owner

  @Register001
    #Register as renter
  Scenario: User register with valid credential as renter
    Given User already on homepage
    When User click to login page
    And  User click to sign up page
    And And user want to create account as a renter
    And User input "julirenter" as name "julirenter" as username "julirenter@gmail.com" as email "Sandi123!" as a password fill gender and create account
    Then User already on login page

  @Register002
    #Register as owner
  Scenario: User login with valid credential as owner
    Given User already on homepage
    When User click to login page
    And  User click to sign up page
    And And user want to create account as a owner
    And User input "julirowner" as name "juliowner" as username "juliowner@gmail.com" as email "Sandi123!" as a password fill gender and create account
    Then User already on login page

    @Register003
    #Test registration with a pre-existing email or username.
  Scenario: Test registration with a pre-existing email or username
    Given User already on homepage
    When User click to login page
    And  User click to sign up page
    And And user want to create account as a renter
    And User input "julirenter" as name "julirenter" as username "julirenter@gmail.com" as email "Sandi123!" as a password fill gender
    And User create account
    Then Appear message email already existed

    @Register004
    Scenario: Verify invalid format input column email without anotation "@" or "."
      Given User already on homepage
      When User click to login page
      And  User click to sign up page
      And And user want to create account as a renter
      And User input "julirenter" as name "julirenter" as username "keirenter12@gmailcom" as email "Sandi123!" as a password fill gender
      And User create account
      Then Appear message email not valid

    @Register005
    Scenario: Verify input column password with special characters
      Given User already on homepage
      When User click to login page
      And  User click to sign up page
      And And user want to create account as a renter
      And User input "julirenter" as name "julirenter" as username "julirenter@gmail.com" as email "tatang12" as a password fill gender
      And User create account
      Then Appear message minimum requirement password

  @Register006
  Scenario: Verify does not select gender
    Given User already on homepage
    When User click to login page
    And  User click to sign up page
    And And user want to create account as a renter
    And User input "julirenter" as name "julirenter" as username "julirenter@gmail.com" as email "Sandi123!" as a password
    And User create account
    Then Appear message please select gender

  @Register007
  Scenario: Test registration with missing required fields (e.g., email, password).
    Given User already on homepage
    When User click to login page
    And  User click to sign up page
    And And user want to create account as a renter
    And User input "julirenter" as name "julirenter" as username "Sandi123!" as a password
    And User create account
    Then Appear message email not valid



