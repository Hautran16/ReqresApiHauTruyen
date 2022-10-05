@LoginApi
Feature: Check invalid method or url

  #TC1,2
  Scenario Outline: Check invalid method
    Given I have "<Url>" and "<Method>"
    When I send the request
    Then I validate the outcomes "<StatusCode>" and "<ErrorMessage>"

    Examples: 
      | Url                               | Method | StatusCode | ErrorMessage |
      | https://reqres.in/api/login       | GET    |        200 | null         |
    #  | https://reqres.in/apifdafds/login | POST   |        404 | null         |
