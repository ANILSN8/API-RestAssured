package DifferentWayToPost;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostByJsonObject {
	
	@SuppressWarnings("unchecked")
	@Test
	
	public void jsonobject() {
		//json body created
				JSONObject job=new JSONObject();
				job.put("createdBy", "vijaya");
				job.put("projectName", "frederal");
				job.put("status", "created");
				job.put("teamsize", 25);
				
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
