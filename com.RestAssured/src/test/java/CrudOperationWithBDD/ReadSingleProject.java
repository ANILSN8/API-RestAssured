package CrudOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ReadSingleProject {
	
	@Test
	
	public void singleprojct() {
		when()
		.get("http://localhost:8084/projects/TY_PROJ_809")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();

	}

}
