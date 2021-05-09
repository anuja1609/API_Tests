package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.pojo.GetLocationResponse;
import com.api.util.Constants;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ForceaWeatherAPI {
	
	//@BeforeTest
	public void setup() {
		RestAssured.baseURI = Constants.FORCEA_BASE_URL;
	}
	
	@Test
	public void getAccessToken() {
		Constants.access_token = given().queryParam("user", "anuja1609").
				queryParam("password", "7Bn1USaZPRx7").
				when().post("https://pfa.foreca.com/authorize/token").
				then().extract().path("access_token");
	}
	
	//@Test
	public void getData() {
		String city = "Barcelona";
		
		List<String> list = new ArrayList<String>();
				list = given().pathParam("cityName", city).header("Authorization", "Bearer " + Constants.access_token).
				when().get(Constants.FORCEA_ENDPOINT + "/{cityName}").
				then().statusCode(200).extract().path("locations.country");
		
				
		System.out.println(list.toString());
		//body("locations[0].country", equalTo("Spain"));
		
		//body("locations.id", hasItems(103128760,103648559));
	}
	
	//@Test
	public void getLocation() {
		int id = 103128760;
		GetLocationResponse loc = given().header("Authorization", "Bearer "+Constants.access_token).pathParam("id", id).contentType("application/json").
		when().get(Constants.FORCEA_SEARCH_LOCATION_ENDPOINT + "/{id}").as(GetLocationResponse.class);
		
		System.out.println(loc.getCountry());
		System.out.println(loc.getName());
	}

	//@Test
	public void getLoc2() {
		int id = 103128760;
		RequestSpecification req  = given().header("Authorization", "Bearer "+Constants.access_token).pathParam("id", id).contentType("application/json");
		Response resp = req.get(Constants.FORCEA_SEARCH_LOCATION_ENDPOINT + "/{id}");
		System.out.println(resp.prettyPrint());		
	}
	
}
