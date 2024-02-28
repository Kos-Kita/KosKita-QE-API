@AllFlow
Feature: Ratings
  User want give ratings at kos

  @Ratings
Scenario: User renter add ratings
Given User already on homepage
When User click to login page
Then User already on login page
When User input "julirenter@gmail.com" as email and "julirenter" as password
Then User already on homepage
When User go to user profile
And User give the the rating