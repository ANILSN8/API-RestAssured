package CrudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProject {
	@SuppressWarnings("unchecked")
	@Test
	public void Addprojct() {
		
		//json body created
		JSONObject job=new JSONObject();
		job.put("createdBy", "Roja");
		job.put("projectName", "flinko");
		job.put("status", "created");
		job.put("teamsize", 20);
		
		//action
		given()
		.contentType(ContentType.JSON)
		.body(job)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
