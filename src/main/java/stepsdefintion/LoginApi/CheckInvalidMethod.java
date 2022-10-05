package stepsdefintion.LoginApi;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class CheckInvalidMethod {
	String url, method ="";
	HttpResponse response= null;
  @Given("I have Url {string} and invalid method {string}")
  public void i_have_url_and_invalid_method(String givenUrl, String givenMethod) {
	  url = givenUrl;
	  method= givenMethod;
  }

  @When("send request with invalid method")
  public void send_request() {
	  
	  try {
		  HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
		  response =  HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
	} catch (Exception e) {
		e.printStackTrace();
	}
  }

  @Then("The reponse with invalid method returns status code {int}")
	public void the_reponse_returns_status_code(int expectedStatusCode) {
		int actualStatusCode = response.statusCode();
		assertEquals(actualStatusCode,expectedStatusCode );
		
  }

}
