@AllFlow
Feature: Booking
  User want booking kos at website Koskita

  @Booking
Scenario: User renter booking
Given User already on homepage
When User click to login page
Then User already on login page
When User input "julirenter@gmail.com" as email and "julirenter" as password
Then User already on homepage
When User input search "jakarta" and search
And User click the fourth kos
And User set the date for booking
And User click continue ordering
Then User verified the ordering
When User select the payment and pay
Then User verify the detail payment