package com.api.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.pojo.HolidayResponse;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Test123 {
	
	private static final int HolidayResponse = 0;

	@Test
	public void test1() {
		System.out.println("aaaa");
		String userID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
        String userName = "TOOLSQA-Test";
        String password = "Test@@123";
        String baseUrl = "https://bookstore.toolsqa.com";
 
        RestAssured.baseURI = baseUrl;
        Map<String,String> map = new HashMap<String,String>();
        map.put("userName", userName);
        map.put("password", password);
 
             
        String abc = RestAssured.given().header("Content-Type", "application/json").
        body(map).
        when().post("/Account/v1/GenerateToken").body().asString();
        Assert.assertNotNull(abc);
        //System.out.println(abc);
	}
	
	@Test
	public void holiday2() {
		RestAssured.baseURI = "https://holidays.abstractapi.com/v1/";
		List<String> list = new ArrayList<String>();
		list = given().queryParam("api_key", "67aada8bda7c478d9a4a61497be92f7c").queryParam("country", "US").
		queryParam("year", 2021).queryParam("month", 9).queryParam("day", 16).
		when().get().then().extract().path("");
		Assert.assertTrue(list.size()>0);

	}

	//@Test
		public void holiday() {
			RestAssured.baseURI = "https://holidays.abstractapi.com/v1/";
				
			Map<String,String> mp = new HashMap<String, String>();
			mp = given().queryParam("api_key", "67aada8bda7c478d9a4a61497be92f7c").queryParam("country", "US").
				queryParam("year", 2021).queryParam("month", 9).queryParam("day", 16).
				when().get().then().extract().path("[1]");
			
			//System.out.println(mp.toString());
			
			for(Entry<String, String> map1: mp.entrySet()) {
				
				System.out.print(map1.getKey());
				System.out.println("Value::: "+map1.getValue());
			}
		}
		
		//@Test
		public void holiday1() {
			RestAssured.baseURI = "https://holidays.abstractapi.com/v1/";	
			given().queryParam("api_key", "67aada8bda7c478d9a4a61497be92f7c").queryParam("country", "US").
			queryParam("year", 2021).queryParam("month", 9).queryParam("day", 16).
			when().get().then().log().body();
		
		}
	
		//@Test
		public void holiday_pojo() {
			RestAssured.baseURI = "https://holidays.abstractapi.com/v1/";		
			List<HolidayResponse> list = new ArrayList<HolidayResponse>();
			
			//given()
			list = given().queryParam("api_key", "67aada8bda7c478d9a4a61497be92f7c").queryParam("country", "US").
			queryParam("year", 2021).queryParam("month", 9).queryParam("day", 16).
			when().get().as(List.class);
			
			System.out.println(list.size());
			
			for(HolidayResponse hol: list) {
				System.out.println(hol.getCountry());
				System.out.println(hol.getType());
			}
		}
}
