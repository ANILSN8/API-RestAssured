package RequestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclassforseralizationanddeserialization.PojoClassWithJson;

public class GetAndDelete {
	@Test
	public void getanddelet() {
	
	//get
	Response resp = given().when().get("http://localhost:8084/projects");
	String proId = resp.jsonPath().get("[0].projectId");
	System.out.println("proId");
	resp.then().log().all();
	
	//delete
	given()
	.pathParam("pid", proId)
	.when()
	.delete("http://localhost:8084/projects/{pid}")
	.then()
	.assertThat().statusCode(204)
	.log().all();
	
	
	
	

}
}
