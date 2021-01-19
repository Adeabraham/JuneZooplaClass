
Feature: For Rent Search
  As a customer
  I want the ability to search for any property of my choice
  so that I can choose one to rent


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
      |London  |No min  |No max  |Show all    | No min |


  Scenario Outline: Customer can search for any property TO RENT
    Given I navigate to Zoopla homepage
    And i click on for rent tab
    When I enter "<Location>" into the search field
    And I select "<MinPrice>" from Min rent price
    And I select "<MaxPrice>" from Max rent price
    And I select "<PropertyType>" from Property type
    And I select "<NoOfBeds>" from Bedrooms
    And I click on Search button
    Then the search for "<Location>" is displayed
    And I click on one of the search results

    Examples:
      |Location|MinPrice|MaxPrice  |PropertyType|NoOfBeds|
#      |London  |No min  |No max    |Show all    | No min |
      |London  |£800 pcm|£2,000 pcm|Show all    | No min |





  # Scenario below is testing error on home page:

  @ignore
  Scenario Outline: Customer cannot search for any property with missing values
    Given I navigate to Zoopla homepage
    When I enter "<Location>" into the search field
    And I select "<MinPrice>" from Min price
    And I select "<MaxPrice>" from Max price
    And I select "<PropertyType>" from Property type
    And I select "<NoOfBeds>" from Bedrooms
    And I click on Search button
    Then an error page is displayed

    Examples:
      |Location|MinPrice|MaxPrice|PropertyType|NoOfBeds|
      |        |No min  |No max  |Show all    | No min |

  #Scenario below is testing error page:

  Scenario Outline: Error page is displayed for invalid searching values
    Given I navigate to Zoopla homepage
    When I enter "<Location>" into the search field
    And I select "<MinPrice>" from Min price
    And I select "<MaxPrice>" from Max price
    And I select "<PropertyType>" from Property type
    And I select "<NoOfBeds>" from Bedrooms
    And I click on Search button
    Then an error page is displayed

    Examples:
      |Location|MinPrice|MaxPrice|PropertyType|NoOfBeds|
      |M39 1XC |£120,000|£230,000|Houses      | 3+     |
#      |£££     |£120,000|£230,000|Farms/land  | 3+     |
#     |123     |£120,000|£230,000|Flats       | 3+     |
