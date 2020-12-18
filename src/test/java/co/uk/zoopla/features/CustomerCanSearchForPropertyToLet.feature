Feature: For Rent Search
  As a customer
  I want the ability to search for any property of my choice
  so that I can choose one to rent

  Scenario Outline: Customer can search for any property
    Given I navigate to Zoopla homepage
    When I enter "<Location>" into the search field
    And I select "<MinPrice>" from Min price
    And I select "<MaxPrice>" from Max price
    And I select "<PropertyType>" from Property type
    And I select "<NoOfBeds>" from Bedrooms
    And I click on Search button
    Then the search for "<Location>" is displayed

    Examples:
      |Location|MinPrice|MaxPrice|PropertyType|NoOfBeds|
      |London  |No min  |No max  |Show all    | No min |