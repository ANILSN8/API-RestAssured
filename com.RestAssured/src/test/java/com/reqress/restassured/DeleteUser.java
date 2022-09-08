package com.reqress.restassured;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DeleteUser {
	@Test
	public void deletprojec() {
		when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
		
	}
}
