package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.util.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherAPI {
	
	//@BeforeTest
	public void setup() {
		RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5/weather";
	}
	
	@Test
	public void getWeather() {
		given().queryParam("q", "London,uk").queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8").
		when().
		get("https://samples.openweathermap.org/data/2.5/weather").
		then().
		assertThat().statusCode(200).and().body("name", equalTo("London"));
	}
	
	
	public void getTest() {
		
		RequestSpecification req  = given();
		req.queryParam("q", "London,uk").queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8");
		Response resp = req.get("/weather");

		////////////
		
		///
		RequestSpecification req2 = given().queryParam("q", "London,uk").queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8");
		
		//Response
		
	}

	//@Test(dataProvider="test")
	public void testDP(String name, String role) {
		System.out.println(name + " ::" + role);
	}
	
	@DataProvider(name = "test")
	public String[][] dataP() {
		String[][] arr = new String[2][2];
		
		arr[0][0]= "n1";
		arr[0][1] = "r1";
		
		arr[1][0]= "n2";
		arr[1][1] = "r2";
		return arr;
	}
	
}
