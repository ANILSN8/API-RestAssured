package CrudOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ReadTheProjects {
	@Test
	public void read() {
		
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}

}
