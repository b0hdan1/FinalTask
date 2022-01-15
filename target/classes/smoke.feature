Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check visibility of required fields for registration
    Given User opens '<homePage>' page
    When User checks registration button visibility
    Then User clicks Join button
    And User check 'Email address' field is visible
    And User check 'First name' field is visible
    And User check 'Last name' field is visible
    And User check 'Password' field is visible
    And User check 'Day of birth' field is visible
    And User check 'Month of birth' field is visible
    And User check 'Year of birth' field is visible

    Examples:
      | homePage              |
      | https://www.asos.com/ |


  Scenario Outline: Check the user can log in with previously registered data
    Given User opens '<homePage>' page
    And User checks registration button visibility
    When User click 'Sign In' button
    And User check 'Sign In Email address' field is visible
    And User enter '<email>'
    And User check 'Sign In Password' field is visible
    And User enter '<password>' to 'Sign In' field
    And User click 'Sign In' button in Sign In page
    And User clicks account dropdown
    Then User sees their greeting


    Examples:
      | homePage              | email                     | password        |
      | https://www.asos.com/ | lagep54922@rubygon.com    | 7cw3Gc-_2@3EwMF |

  Scenario Outline: Check the correct work of the registration form with invalid data
    Given User opens '<homePage>' page
    And User checks registration button visibility
    And User clicks Join button
    When User fills in all required registration fields with invalid '<email>'
    And User clicks registration button
    Then User sees email error

    Examples:
      | homePage              | email        |
      | https://www.asos.com/ | qweqwrettqwe |

  Scenario Outline: Check password field error when entering less than 10 characters
    Given User opens '<homePage>' page
    And User checks registration button visibility
    And User clicks Join button
    When User fills in required registration fields with invalid '<password>'
    And User clicks registration button
    Then User sees password error

    Examples:
      | homePage              | password     |
      | https://www.asos.com/ | 12qweErty    |

  Scenario Outline: Check that url contains search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    Then User checks that current url contains '<currentUrl>'

    Examples:
      | homePage              | searchWord | currentUrl |
      | https://www.asos.com/ | sneakers   | sneakers   |

  Scenario Outline: Check the impossibility of adding an item without choosing a size
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User clicks on first product
    And User checks 'ADD TO BAG' button visibility
    And User clicks 'ADD TO BAG' button on product
    Then User will see the '<message>'

    Examples:
      | homePage              | searchWord | message                                                    |
      | https://www.asos.com/ | sneakers   | Please select from the available colour and size options   |

  Scenario Outline: Check current count items on the page
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User checks that current url contains '<searchWord>'
    Then User check '<currentCount>' items on the page

    Examples:
      | homePage              | searchWord | currentCount |
      | https://www.asos.com/ | coat       | 72           |

  Scenario Outline: Check adding a product with the selected size
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User clicks on first product
    And User checks size button visibility
    And User select size button
    And User clicks on first size field
    And User checks 'ADD TO BAG' button visibility
    And User clicks 'ADD TO BAG' button on product
    Then User check '<countOfItems>' item(s) in the bag

    Examples:
      | homePage              | searchWord | countOfItems |
      | https://www.asos.com/ | jeans      | 1            |

  Scenario Outline: Check the possibility of adding the product to the wish list
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User click 'Add to wishlist' on first product
    Then User makes sure that '<countOfItems>' products are added to the wishlist

    Examples:
      | homePage              | searchWord | countOfItems |
      | https://www.asos.com/ | jacket     | 1            |

  Scenario Outline: Check correctly working filter
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User check visible filter button
    And User clicks 'Brand' filter button
    And User select 'ASOS'
    Then User checks that current url contains '<searchWord>'

    Examples:
      | homePage              |  searchWord |
      | https://www.asos.com/ |  jacket     |
