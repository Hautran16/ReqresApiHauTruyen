@CreateUser
Feature: Check Create User Susscessfully

  @Maincase
  Scenario Outline: Check Create User Susscessfully
    Given I have Url and method and requestBody
      | url                         | method | requestBodyName            |
      | https://reqres.in/api/users | POST   | CreateUserRequestBody.json |
    When I send the request with valid data
    Then The reponse returns status "<statuscode>" and responsebody "<job>" and "<name>"
  Examples:
      | statuscode | job    | name     |
      |        201 | leader | morpheus |
