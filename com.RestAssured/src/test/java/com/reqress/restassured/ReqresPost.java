package com.reqress.restassured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReqresPost {
	
	@Test
public void Addprojct() {
		
		//json body created
		JSONObject job=new JSONObject();
		job.put("name", "morpheus");
		job.put("job", "leader");

		
		//action
		given()
		.contentType(ContentType.JSON)
		.body(job)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
	@Test
	public void staticResponseGet()
	{
		
		//action
		Response resp = when()
				        .get("https://reqres.in/api/users");
		
		//validation
		String actData = resp.jsonPath().get(".name");
		Assert.assertEquals(actData," morpheus");
		System.out.println("data verfied ");
		
		resp.then().log().all();
	}

}
