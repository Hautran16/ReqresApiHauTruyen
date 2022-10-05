package common;

public class Response<Integer, String> {
	public Response(int statusCode, String responseBody) {
		super();
		this.statusCode = statusCode;
		this.responseBody = responseBody;
	}
	private int statusCode;
	private String responseBody;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	
	
}
