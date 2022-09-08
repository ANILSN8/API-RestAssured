package Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticValidation {
	
	@Test
	public void StaticResponseget() {
		String expdata = "TY_PROJ_003";
	
		//action
		Response resp = when()
		        .get("http://localhost:8084/projects");

//validation
String actData = resp.jsonPath().get("[1].projectId");
Assert.assertEquals(actData, expdata);
System.out.println("data verfied ");

resp.then().log().all();
}
	}


