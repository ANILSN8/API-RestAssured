package CrudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
@SuppressWarnings("unchecked")
@Test
public void update() {
	JSONObject job=new JSONObject();
	job.put("createdBy", "Rashmi");
	job.put("projectName", "flinko");
	job.put("status", "created");
	job.put("teamSize", 20);
	
	  given()
	  .contentType(ContentType.JSON)
	  .body(job)
	  .when()
	  .put("http://localhost:8084/projects/TY_PROJ_804")
	  .then()
	  .assertThat().statusCode(200)
	  .contentType(ContentType.JSON)
	  .log().all();
	  
	
}
}
