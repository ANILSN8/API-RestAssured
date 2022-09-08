package Parameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParameter {
	
	@Test
	public void Query() {
		given()
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat().statusCode(200)
		.log().all();

	}

}
