
@LoginApi
Feature: Check response when send request successfully
@MainCase
  Scenario: Check response when send request successfully
    Given I have Url "https://reqres.in/api/login" and method "POST" and body request "request body"
    When send request
    Then The reponse returns status code 200


