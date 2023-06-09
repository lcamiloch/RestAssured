Feature: Test JSONPlaceholder functionalities

  @Get
  Scenario Outline: Obtain users
    Given the customer wants to test the functionalities of the JSONPlaceholder services
    When he queries for the user with id <idNumber>
    Then he should see the queried user

    Examples:
      | idNumber |
      | 8        |

  @Post
  Scenario Outline: Create user
    Given the customer wants to test the functionalities of the JSONPlaceholder services
    When he creates an user with the data <tittle> <body> <userId>
    Then he should see the user created

    Examples:
      | tittle | body       | userId |
      | IA     | Technology | 83     |