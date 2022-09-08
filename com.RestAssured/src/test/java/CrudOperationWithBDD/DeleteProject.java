package CrudOperationWithBDD;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DeleteProject {
	
	@Test
	public void deletprojec() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_811")
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
		
	}

}
