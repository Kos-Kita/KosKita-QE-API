@AllFlow
Feature: Profile
  User want edit profile at koskita


  @EditProfile001
Scenario: User renter or user edit the information account
Given User already on homepage
When User click to login page
Then User already on login page
When User input "julirenter@gmail.com" as email and "julirenter" as password
Then User already on homepage
When User go to user profile
And User edit name as "julirenter" and username as "julirenter"
And User go to homepage

   @EditProfile002
   Scenario: User renter or user edit the name account
     Given User already on homepage
     When User click to login page
     Then User already on login page
     When User input "julirenter@gmail.com" as email and "julirenter" as password
     Then User already on homepage
     When User go to user profile
     And User edit name as "julirenter"
     And User go to homepage

  @EditProfile003
  Scenario: User renter or user edit the username account
    Given User already on homepage
    When User click to login page
    Then User already on login page
    When User input "peper213@gmail.com" as email and "Peper213%" as password
    Then User already on homepage
    When User go to user profile
    And User edit username as "julirenter"
    And User go to homepage