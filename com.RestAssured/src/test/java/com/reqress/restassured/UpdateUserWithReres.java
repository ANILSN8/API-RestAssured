package com.reqress.restassured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateUserWithReres {
	@Test
	public void Adduser() {
			
			//json body created
			JSONObject job=new JSONObject();
			job.put("name", "morpheus");
			job.put("job", "manager");

			
			//action
			given()
			.contentType(ContentType.JSON)
			.body(job)
			.when()
			.put("https://reqres.in/api/users/2")
			.then()
			.assertThat().statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
		}

}
