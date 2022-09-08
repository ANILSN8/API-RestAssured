package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclassforseralizationanddeserialization.PojoClassWithJson;

public class AddAndDelete {
	
	@Test
	public void addanddelet() {
		Random random=new Random();
		int randomNum = random.nextInt(1000);
		
		PojoClassWithJson pojo=new PojoClassWithJson("varu", "crm"+randomNum, "created", 25);
		//post
		Response resp = given().contentType(ContentType.JSON).body(pojo).when().post("http://localhost:8084/addProject");
		String proId = resp.jsonPath().get("projectId");
		System.out.println("proId");
		
		resp.then().assertThat().statusCode(201).log().all();
		
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
