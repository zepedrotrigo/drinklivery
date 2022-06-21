Feature: Users register in app
    Scenario: User registers in app
        When I load the webpage 'http://localhost:3002/'
        And I click the Enter button located in the navigation bar
        And I fill the signup form with my information
        And I click the 'register' button
        Then a green confirmation text shows I registered succesfully
    
    
    
