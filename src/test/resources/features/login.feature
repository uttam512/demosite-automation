Feature: Login

  Scenario: Successful login with valid credentials
    Given I open the application
    When I login with valid credentials
    Then I should see the products page
