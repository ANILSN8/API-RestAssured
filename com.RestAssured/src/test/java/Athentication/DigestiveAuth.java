package Athentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class DigestiveAuth {
	@Test
	public void basicauth() {
		
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.assertThat().statusCode(202)
		.log().all();
	}

}
