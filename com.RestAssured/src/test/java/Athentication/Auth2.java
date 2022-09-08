package Athentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Auth2 {
	
	@Test
	
	public void auth2() {
	Response resp = given()
			.formParam("client_id", "SDET-378")
			.formParam("client_secret", "8a74f92093a04b3c8618f99692b3fcf0")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "htttp://example.com")
			.formParam("code","authorization_code")
			
			.when()
			.post("http://coop.apps.symfonycasts.com/token");
	        
	        String token = resp.jsonPath().get("access_token");
	        given()
	        .auth().oauth2(token)
	        .pathParam("user_id", "3761")
	        .when()
	        .post("http://coop.apps.symfonycasts.com/api/{user_id}/eggs-count")
	        .then()
	        .log().all();
			
		
	}

}
