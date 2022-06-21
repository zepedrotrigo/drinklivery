Feature: User logs in, adds wine to cart and checks out

  Scenario: User logs in to the app
    When I load the webpage 'http://localhost:3002/'
    And I click the Enter button located in the navigation bar
    And I fill the login form with my information
    And I click the 'login' button
    Then I am redirected to the page 'http://localhost:3002/'
    And I click the 'wines' button
    And I click the 'details' button
    And I click the 'addToCart' button
    And I click the 'close' button
    And I click the 'profile' button
    And I click the 'cartCheckout' button
    And I click the 'checkoutBuy' button
    Then I am redirected to the page 'http://localhost:3002/'