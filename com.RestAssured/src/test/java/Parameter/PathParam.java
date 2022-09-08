package Parameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PathParam {
	
	@Test
	
	public void get() {
		//get
				given()
				.pathParam("pid", "TY_PROJ_810")
				.when()
				.get("http://localhost:8084/projects/{pid}")
				.then()
				.assertThat().statusCode(200)
				.log().all();
				
	}

}
