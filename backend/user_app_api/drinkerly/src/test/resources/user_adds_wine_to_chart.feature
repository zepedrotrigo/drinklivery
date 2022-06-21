Feature: User adds wine to cart and checks out
    The user finds a wine to buy, adds it to the cart and then it goes to t
    he checkout to finish the purchase

    Scenario: User adds wine to cart
        Given User clicked the "Details" button
        And The wine card opened
        When User clicks "Add to Cart" button
        Then Cart should have wine item
    
    Scenario: User goes to checkout
        Given User is in the profile page
        And Has items in the cart
        When User clicks "Add to Cart" button
        Then Cart should have wine item
    