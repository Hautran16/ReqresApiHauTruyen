package common;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import common.ApiUtils.Method;

public class ApiUtils {
	public HttpResponse<String> sendGetRequest(String url) {
		HttpResponse<String> response = null;
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET()
					.header("Content-Type", "application/json").build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
			// actualStatusCode=response.statusCode();
			// String body = response.body();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send get request fail");
		}
		return response;
	}

	// Send POST request
	public HttpResponse<String> sendPostRequest(String url, String jsonRequestBody) {

		HttpResponse<String> response = null;
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(jsonRequestBody))// pass request body
					.build();

			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
			System.out.println("requestBodyString:" + jsonRequestBody);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send get request fail");
		}
		return response;
	}

	public enum Method {
		POST, GET
	}
	
//	public enum Method{POST ("POST"),GET ("GET");
//
//	Method(String string) {
//		// TODO Auto-generated constructor stub
//	}};

	public Response<Integer, String> sendRequest(String method, String url, String requestBody) {
		HttpResponse<String> response = null;
		Response<Integer, String> result = null;
		if (method.equals(Method.POST)) {
			response = sendPostRequest(url, requestBody);
		} else
			response = sendGetRequest(url);
		result.setStatusCode(response.statusCode());
		result.setResponseBody(response.body());
		return result;
	}

	public HttpResponse<String> sendRequestHau(String method, String url, String requestBody) {

		HttpResponse<String> response = null;
		if (method.equals(Method.POST.name())) {
//				response = sendPostRequest(requestBody.toString(), url);
			response = sendPostRequest(url,requestBody);

		} else if (method.equals(Method.GET)) {
			response = sendGetRequest(url);
		}

		return response;
	}
}
