package utils;

import java.io.File;
import java.io.InputStream;
import java.util.Map;
import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class RestSteps {

	private String baseUrl;
	private RequestSpecification requestSpecification;
	private Response response;


	public void sentAsGet(String endpoint) {
		requestSpecification = RestAssured.given().baseUri(baseUrl);
		response = requestSpecification
				.log().all()
				.get(endpoint);

	}
	public void setAsget(String endpoint, Map<String,Object>params) {
		requestSpecification = RestAssured.given().baseUri(baseUrl);
		for(String key: params.keySet()) {
			requestSpecification.param(key, params.get(key));
		}
		response = requestSpecification
				.log().all()
				.get(endpoint);
	}

	public void sentAsPost(String endpoint, Map<String, Object>params, 
			ContentType contentTyps, Map<String, Object>map) {
		requestSpecification = RestAssured.given().baseUri(baseUrl);
		for(String key: params.keySet()) {
			requestSpecification.param(key, params.get(key));
		}
		requestSpecification.contentType(contentTyps);
		requestSpecification.body(map);
		response = requestSpecification
				.log().all()
				.get(endpoint);

	}

	public void sentAsPost(String endpoint, Map<String, Object>params, 
			ContentType contentTyps, File file) {
		requestSpecification = RestAssured.given().baseUri(baseUrl);
		for(String key: params.keySet()) {
			requestSpecification.param(key, params.get(key));
		}
		requestSpecification.contentType(contentTyps);
		requestSpecification.body(file);
		response = requestSpecification
				.log().all()
				.get(endpoint);


	}
	public void sentAsPost(String endpoint, Map<String, Object>params, 
			ContentType contentTyps, InputStream inputStream) {
		requestSpecification = RestAssured.given().baseUri(baseUrl);
		for(String key: params.keySet()) {
			requestSpecification.param(key, params.get(key));
		}
		requestSpecification.contentType(contentTyps);
		requestSpecification.body(inputStream);
		response = requestSpecification
				.log().all()
				.get(endpoint);


	}
	public void sentAsPost(String endpoint, Map<String, Object>params, 
			ContentType contentTyps, byte[] bites) {
		requestSpecification = RestAssured.given().baseUri(baseUrl);
		for(String key: params.keySet()) {
			requestSpecification.param(key, params.get(key));
		}
		requestSpecification.contentType(contentTyps);
		requestSpecification.body(bites);
		response = requestSpecification
				.log().all()
				.get(endpoint);


	}

	public Response getResponse() {
		response.prettyPrint();
		return response;

	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void responseBodyValidation(String Key, Object expected) {
		response.then().body(Key, Matchers.equalTo(expected));
	}

}
