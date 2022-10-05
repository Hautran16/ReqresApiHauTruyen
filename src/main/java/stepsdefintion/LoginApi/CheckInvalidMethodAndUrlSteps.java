package stepsdefintion.LoginApi;

import static org.testng.Assert.assertEquals;
import common.Response;
import common.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckInvalidMethodAndUrlSteps {
	String url, method;
	int actualStatusCode;
	String actualErrorMesage ;

	@Given("I have {string} and {string}")
	public void i_have_and(String givenUrl, String givenMethod) {
		url = givenUrl;
		method = givenMethod;
	}

	@When("I send the request")
	public void i_send_the_request() {
		ApiUtils apiUtils = new ApiUtils();
		String requestBody = "";
		Response<Integer, String> result = apiUtils.sendRequest(method, url, requestBody);
		actualStatusCode = result.getStatusCode();
		String body = result.getResponseBody();
	}

	@Then("I validate the outcomes {string} and {string}")
	public void thenIValidateTheOutcomes(String expectedStatusCode, String expectedErrorMessage) {
		assertEquals(actualStatusCode, Integer.parseInt(expectedStatusCode));
		if (actualErrorMesage == null) {
			actualErrorMesage = "null";
		}
		assertEquals(actualErrorMesage, expectedErrorMessage);
	}
}
