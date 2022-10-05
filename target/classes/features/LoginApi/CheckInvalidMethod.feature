@LoginApi
Feature: Check invalid method
  @TC001
  Scenario: Check invalid method
    Given I have Url "https://reqres.in/api/login" and invalid method "GET"
    When send request with invalid method
    Then The reponse with invalid method returns status code 200