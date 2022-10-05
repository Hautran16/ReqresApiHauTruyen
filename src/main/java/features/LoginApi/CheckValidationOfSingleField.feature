@Login
Feature: Check validation of single field

  @validation
  Scenario Outline: Check validation of single field
    Given I have "<Url>" and "<Method>" and "requestBody" and
      | Url                         | method | requestBodyName       |
      | https://reqres.in/api/login | POST   | LoginRequestBody.json |
    When I send the request "<fiedName>" and "<Value>"
    Then The reponse returns status "<ExpectedStatusCode>" and "<ExpectedMessage>"

    Examples: 
      | FieldName | Value              | Expected Status Code | Expected Message          |
      | email     | eve.holt@reqres.in |                  200 |                           |
      | email     | missing            |                  400 | Missing email or username |
      | email     | null               |                  400 | Missing email or username |
      | email     | ""                 |                  400 | user not found            |
      | email     | true               |                  400 | user not found            |
      | password  | eve.holt@reqres.in |                  200 |                           |
      | password  | missing            |                  400 | Missing email or username |
      | password  | null               |                  400 | Missing email or username |
      | password  | ""                 |                  400 | user not found            |
      | password  | true               |                  400 | user not found            |
