@AllFlow
Feature: About and Contact
  User want to see about koskita

  @About001
    #About page validation
  Scenario: About page validation
    Given User already on homepage
    When User click to about page
    Then User already on about page

  @Contact001
    #Contact page validation
  Scenario: Contact page validation
    Given User already on homepage
    When User click to contact page
    Then User already on contact page
