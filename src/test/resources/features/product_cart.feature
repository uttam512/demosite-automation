Feature: Product and Cart flows

  Scenario: Add backpack to cart and verify in cart
    Given I am logged in as a standard user
    When I add "Sauce Labs Backpack" to the cart
    And I open the cart
    Then the cart should contain "Sauce Labs Backpack"
    And the cart should contain 1 item
