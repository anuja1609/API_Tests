package com.api.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NestedJson {

	public static void main(String[] args) throws ParseException {
		test();
	}
	
	public static void test() throws ParseException {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification request = RestAssured.given();
		Response response = request.queryParam("page", 2).request(Method.GET, "/users");
		
		JSONParser parser = new JSONParser();
		JSONObject jobj = (JSONObject)parser.parse(response.asString());
		
		//System.out.println(jobj.get("total_pages"));
		
		JSONArray jarr = (JSONArray) jobj.get("data");
		//System.out.println(jarr.size());
		
		for(Object obj: jarr) {
			JSONObject jo = (JSONObject) obj;
			System.out.println(jo.get("email"));
		}
		
	}
}
