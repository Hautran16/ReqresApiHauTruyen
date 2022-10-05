package stepsdefintion.CreateUser;

import static org.testng.Assert.assertEquals;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import common.ApiUtils;
import common.JsonUltils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckCreateUserSusscessfullySteps {
	String url, method, requestBodyName;
	int actualStatusCode;

	@Given("I have Url and method and requestBody")
	public void i_have_url_and_method_and_request_body(List<Map<String, String>> resquestDatas) {
		for (Map<String, String> requestData : resquestDatas) {
			url = requestData.get("url");
			method = requestData.get("method");
			requestBodyName = requestData.get("requestBodyName");
		}
	}

	@When("I send the request with valid data")
	public void i_send_the_request_with_valid_data() {
		ApiUtils apiUtils = new ApiUtils();
		JsonUltils jsonUtils = new JsonUltils();
		String requestBody = jsonUtils.readJsonFile(
				"D:\\AutomationTest\\02Project\\02Git\\ReqresApiProject\\src\\main\\resources\\CreateUser\\"
						+ requestBodyName);
		HttpResponse<String> result = apiUtils.sendRequestHau(method, url, requestBody);
		System.out.println("url, method, request :               " + url + "        " + method +"    " + requestBody);

		System.out.println("result:  " + result);
		actualStatusCode = result.statusCode();
		String body = result.body();
	}

	@Then("The reponse returns status {string} and responsebody {string} and {string}")
	public void the_reponse_returns_status_and_responsebody_and(String expectedStatusCode, String expectedJob, String ExpectedName) {
		assertEquals(actualStatusCode, Integer.parseInt(expectedStatusCode));

	}

}
