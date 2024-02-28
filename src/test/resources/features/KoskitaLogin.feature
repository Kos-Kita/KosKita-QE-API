@AllFlow
Feature: Login
  User want login to website Koskita as renter and owner

  @Login001
    #Login as renter
  Scenario: User login with valid credential as renter
    Given User already on homepage
    When User click to login page
    And User already on login page
    And User input "julirenter@gmail.com" as email and "julirenter" as password
    Then User already on homepage

  @Login002
    #Login as owner
  Scenario: User login with valid credential as owner
    Given User already on homepage
    When User click to login page
    Then User already on login page
    When User input "juliowner@gmail.com" as email and "juliowner" as password
    Then User already on homepage

  @Login003
    #Login as admin
  Scenario: User login with valid credential as admin
    Given User already on homepage
    When User click to login page
    Then User already on login page
    When User input "admin@gmail.com" as email and "admin123" as password
    Then User already on admin page


  @Login004
    #Login with an incorrect password.
  Scenario: User with an incorrect password
    Given User already on homepage
    When User click to login page
    Then User already on login page
    When User input "juliowner@gmail.com" as email and "juliowner1" as password
    Then Verify message password incorrect

  @Login005
    #Login with not registered account
  Scenario: User login with not registered account
    Given User already on homepage
    When User click to login page
    Then User already on login page
    When User input "juliowner100@gmail.com" as email and "juliowner1" as password
    Then Verify message account is not registered

  @Login006
    #Login with a blank username and password fields.
  Scenario: User with a blank username and password fields
    Given User already on homepage
    When User click to login page
    Then User already on login page
    When User click login
    Then Verify message email and password is required

  @Login007
    #Check login account invalid format email
  Scenario: User login with account invalid format email
    Given User already on homepage
    When User click to login page
    Then User already on login page
    When User input "juliowner100@gmailcom" as email and "juliowner1" as password
    Then Verify message not a valid email


  @Logout001
  Scenario: User logout successfully
    Given User already on homepage
    When User click to login page
    Then User already on login page
    When User input "julirenter@gmail.com" as email and "julirenter" as password
    Then User already on homepage
    When And user logout
    Then User already on login page































