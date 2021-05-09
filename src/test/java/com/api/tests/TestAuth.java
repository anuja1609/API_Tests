package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestAuth {
	@Test
	public void postmantest() {
		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
		given().auth().basic("postman", "password").
		when().get().then().
		assertThat().body("authenticated", equalTo(true));		
	}
	
	@Test
	public void postman() {
		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
		RequestSpecification req = given().auth().basic("postman", "password");
		
		Response resp = req.get();
		
		resp.then().
		assertThat().body("authenticated", equalTo(true)).and().statusCode(200);
		
/*		JSONObject jo = resp.as(JSONObject.class);
		String s = jo.keySet().toString();
		System.out.println(s);*/
		
		
	}
}
