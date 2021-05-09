package com.api.util;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;

public class APIUtil {
	
/*	public static void getAllUsersNew() {
		given().when().get(Constants.USER_ENDPOINT).then().statusCode(200);
		
	}*/
	
	public static Response getResponse1(String method, String path, String baseURI) {
		RestAssured.baseURI = baseURI;
		Response response = given().request(method, path);
		return response;
	}
	
	public static Response getResponse(RequestSpecification requestSpec, String method, String path) {
		return requestSpec.request(method, path);
	}

	public static void printResponseBody(Response response) {
		response.then().log().body();
	}
	
	public static String getResponseBody(Response response) {
		return response.getBody().prettyPrint();
	}
	
	public static int getResponseStatusCode(Response response) {
		return response.getStatusCode();
	}
	
	public static Response getResponseWithQueryParam(HashMap<String, String> queryParams, String method, String path, String baseURI) {
		RestAssured.baseURI = baseURI;
		RequestSpecification reqSpec = RestAssured.given();
		Set<String> params = queryParams.keySet();
	
		Iterator it = params.iterator();
		while(it.hasNext()) {
			String key = (String) it.next();
			String value = queryParams.get(key);
			reqSpec.queryParam(key, value);
			
		}
		Response response = reqSpec.request(method, path);
		return response;
	}
	
	public static String getJSONElementValue(Response response, String element) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		return jsonPathEvaluator.get(element);
	}
	
	public static void test(Response response) {
		JsonPath res = response.getBody().jsonPath();
		
		
	}
}
