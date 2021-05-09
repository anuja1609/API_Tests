package com.api.util;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpRequest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherAPIs_JSON {
	public static void main(String[] args) {
test4();
	}
	
	public static void test() {
		given().when().get("http://demoqa.com/utilities/weather/city/Hyderabad").then().log().body();
	}
	
	public static void test1() {
		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET,"/Mumbai");
		System.out.println(response.getBody().asString());
	}
	
	public static void test2() {
		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
		System.out.println(RestAssured.given().request(Method.GET,"/Mumbai").getBody().asString());
	}
	
	public static void test3() {
		RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET,"/Mumbai");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String s = jsonPathEvaluator.get("Temperature");
		System.out.println(s);
	}

	public static void test4() {
		//given().when().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=2b1fd2d7f77ccf1b7de9b441571b39b8").then().log().all();
		
		RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5";
		RequestSpecification request = RestAssured.given();
		Response response = request.queryParam("q", "London,uk").queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8").request(Method.GET, "/weather");
		//System.out.println(response.asString());
		
		JsonPath jsonPath = response.jsonPath();		
		//System.out.println(jsonPath.get("weather").toString());

		List<String> w = jsonPath.getList("weather");

		
	}
}
