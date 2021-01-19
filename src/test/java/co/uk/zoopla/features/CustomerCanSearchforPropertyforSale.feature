Feature: For Sale Search
  As a customer
  I want the ability to search for any property of my choice
  so that I can choose one to buy
@ignore
  Scenario Outline: Customer can search for any property
    Given I navigate to Zoopla homepage
    When I enter "<Location>" into the search field
    And I select "<MinPrice>" from Min price
    And I select "<MaxPrice>" from Max price
    And I select "<PropertyType>" from Property type
    And I select "<NoOfBeds>" from Bedrooms
    And I click on Search button
    Then the search for "<Location>" is displayed
    And I click on one of the search results

Examples:
  |Location|MinPrice|MaxPrice|PropertyType|NoOfBeds|
  |London  |No min  |No max  |Show all    |No min |
  |London  |£120,000|No max  |Show all    |No min  |
#|London  |No min  |£400,000|show all    |No min  |
#|London  |£120,000|£400,000|Show all    |No min  |
#|London  |£120,000|£400,000|Houses      |No min  |
#|London  |£120,000|£400,000|Show all    |3+      |
#|OL9 BLE  |£120,000|£400,000|Show all    |3+     |
#|Piccadilly Station|£120,000|£400,000|Show all|3+|


  @error
  Scenario Outline: Search for property in a city
    Given I navigate to Zoopla homepage
    When I enter "<Location>" into the search field
    And I select "<MinPrice>" from Min price
    And I select "<MaxPrice>" from Max price
    And I select "<PropertyType>" from Property type
    And I select "<NoOfBeds>" from Bedrooms
    And I click on Search button to expect error
    Then an error page is displayed

    Examples:
      |Location|MinPrice|MaxPrice|PropertyType|NoOfBeds|
      |NNNNNN  |No min  |No max  |Show all    | No min |




#  Scenario: Search for property in a city with min price
#    Given I navigate to Zoopla homepage
#    When I enter "London" into the search field
#    And I select "£120,000" from Min price
#    And I select "No max" from Max price
#    And I select "Show all" from Property type
#    And I select "No min" from Bedrooms
#    And I click on Search button
#    Then the search for "London" is displayed
  @smokeTest
  Scenario: Search for property in a city with max price
    Given I navigate to Zoopla homepage
    When I enter "London" into the search field
    And I select "No min" from Min price
    And I select "£400,000" from Max price
    And I select "Show all" from Property type
    And I select "No min" from Bedrooms
    And I click on Search button
    Then the search for "London" is displayed
#
#  Scenario: Search for property in a city with min and max price
#    Given I navigate to Zoopla homepage
#    When I enter "London" into the search field
#    And I select "£120,000" from Min price
#    And I select "£400,000" from Max price
#    And I select "Show all" from Property type
#    And I select "No min" from Bedrooms
#    And I click on Search button
#    Then the search for "London" is displayed