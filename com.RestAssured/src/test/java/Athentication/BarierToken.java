package Athentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BarierToken {
	
	@Test
	
	public void bariertoken() {
		
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.assertThat().statusCode(200).log().all();
	}

}
