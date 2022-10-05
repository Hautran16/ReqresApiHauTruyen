
@LoginApi
Feature: Check invalid Url
@TC02
  Scenario: Check invalid Url
    Given I have invalid Url "https://reqres.in/api11111/login" and method "POST" and body request "request body"
    When send request with invalid Url
    Then The reponse with invalid Url returns status code 404


