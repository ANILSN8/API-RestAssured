package CrudOperationWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {
	
	@Test
	public void Creat() {
		
		//json body created
		JSONObject job=new JSONObject();
		job.put("createdBy", "Anil");
		job.put("project", "CRN#4");
		job.put("status", "created");
		job.put("teamsize", "8");
		
		//request body and contenttype
		RequestSpecification reqspc=RestAssured.given();
		reqspc.body(job);
		reqspc.contentType(ContentType.JSON);
		
		//action
		Response response = reqspc.post("http://localhost:8084/addProject");
		ValidatableResponse validateres = response.then();
		validateres.assertThat().contentType(ContentType.JSON);
		validateres.assertThat().statusCode(201);
		validateres.log().all();
		
		
		
		
		
		
	}

}
