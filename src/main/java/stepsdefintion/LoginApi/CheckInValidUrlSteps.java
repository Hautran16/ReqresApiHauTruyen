package stepsdefintion.LoginApi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class CheckInValidUrlSteps {
	String url, method, requestBody ="";
	HttpResponse response= null;
  @Given("I have invalid Url {string} and method {string} and body request {string}")
  public void i_have_invalid_url_and_method_and_body_request(String givenUrl, String givenMethod, String givenRequestBody) {
	  url = givenUrl;
	  method= givenMethod;
	  requestBody= givenRequestBody;
  }

  @When("send request with invalid Url")
  public void send_request_with_invalid_Url() {
	  String requestBody= "{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}";
	  try {
		  HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).headers("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
		  response =  HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
	} catch (Exception e) {
		e.printStackTrace();
	}
  }

  @Then("The reponse with invalid Url returns status code {int}")
	public void The_reponse_with_invalid_Url_returns_status_code(int expectedStatusCode) {
		int actualStatusCode = response.statusCode();
		assertEquals(actualStatusCode,expectedStatusCode );
  }

}
