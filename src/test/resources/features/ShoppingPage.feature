Feature: Default
  @shop
  Scenario: User searches trampoline on myToys webpage
    Given the user is on the home page
    When the user writes "trampoline"  on the search box
    And the user clicks on search button
    And the user sorts products by highest price
    Then Verify that the first 5 products have been sorted correctly
    When the user clicks on Mehr Filter button
    And the user clicks on Preis button
    And the user writes costs between 500 and 1000
    And the user clicks on preis submit button
    And the user clicks on result
    And the user clicks on one product to open detail page
    And the user adds the product to cart
    Then the user verify that the correct product is added to shopping cart



