package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.api.pojo.CreateUserRequest;
import com.api.pojo.GetUserResponse;
import com.api.util.APIUtil;
import com.api.util.Constants;
import com.google.gson.JsonObject;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserAPI {
	String userID = null;
	
	@BeforeTest
	public void setup() {
		RestAssured.baseURI=Constants.USER_BASE_URL;
	}
	
	@Test
	public void skipTest() {
		new SkipException("test is skipped");
	}
	
	@Test
	public void failTest() {
		Assert.assertEquals(true, false);
	} 
	
	@Test(priority=1,description="get all users")
	@Description("Get details for all users")
	@Epic("Epic001")
	@Feature("Feature001")
	@Step("Get all users")
	@Severity(SeverityLevel.BLOCKER)
	public void getAllUsers() {	
		given().
		when().
		get(Constants.USER_ENDPOINT).
		then().
		assertThat().
		body("support.url", equalTo("https://reqres.in/#support-heading"));
		
/*		Response resp = given().get(Constants.USER_ENDPOINT);
		JSONObject jo = resp.body().as(JSONObject.class);
		System.out.println(jo.toJSONString());*/
	}

	@Test(priority=2,description="get specific user")
	@Description("Get details for specific user")
	@Epic("Epic002")
	@Feature("Feature002")
	@Step("Get specific user")
	@Severity(SeverityLevel.NORMAL)
	public void listSpecificUser() {
		Constants.user_ID = "1";		

		given().pathParam("userid", Constants.user_ID).
		when().
		get(Constants.USER_ENDPOINT + "/{userid}").
		then().
		assertThat().statusCode(200);
	}
	
	//@Test
	public void createUser() {
		Map<String,String> userDetails = new HashMap<String, String>();
		userDetails.put("name", "anuja");
		userDetails.put("job", "qa");
		
		Constants.user_ID = given().
		contentType("application/json").
		body(userDetails).		
		when().
		post(Constants.USER_ENDPOINT).
		then().statusCode(201).extract().path("id");
	
	}

	//@Test
	public void createUser_Pojo() {
		 CreateUserRequest userDetails = new CreateUserRequest("anuja","qa");
		 
		String a = given().
					contentType("application/json").
					body(userDetails).		
					when().
					post(Constants.USER_ENDPOINT).
					then().statusCode(201).extract().path("id");		
		System.out.println(a);
	}
	

	//@Test
	public void listSpecificUser_pojo() {
	
		Constants.user_ID = "1";		

		GetUserResponse userdata = 
				given().pathParam("userid", 1).
				when().get(Constants.USER_ENDPOINT + "/{userid}").as(GetUserResponse.class);
		
		System.out.println(userdata.getData().getEmail());
		System.out.println(userdata.getSupport().getUrl());
	}
	
}

