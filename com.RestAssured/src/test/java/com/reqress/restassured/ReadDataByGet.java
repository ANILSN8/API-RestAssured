package com.reqress.restassured;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class ReadDataByGet {
	
	@Test
	public void read() {
		
		when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}

}
