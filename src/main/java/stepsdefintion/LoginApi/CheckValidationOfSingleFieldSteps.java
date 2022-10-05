package stepsdefintion.LoginApi;

import java.util.List;
import java.util.Map;

import common.CucumberUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckValidationOfSingleFieldSteps {
	String url, method, requestBodyName;
	@Given("I have Url and method and requestBody and")
	public void i_have_url_and_method_and_request_body(List<Map<String, String>> loginTable) {
	    url = CucumberUtils.getValueByTableKey(loginTable, "url");
	    method = CucumberUtils.getValueByTableKey(loginTable, "method");
	    requestBodyName = CucumberUtils.getValueByTableKey(loginTable, "requestBodyName");
	}
	@When("I send the request {string} and {string}")
	public void i_send_the_request_and(String fiedName, String Value) {
	   
	}

	@Then("The reponse returns status {string} and {string}")
	public void the_reponse_returns_status_and(String string, String string2, String string3) {
	   
	}

	
	
}
