package Parameter;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclassforseralizationanddeserialization.PojoClassWithJson;

public class PathParameter {
	
	@Test
	
	public void path() {
		
		Random random=new Random();
		int randomNum = random.nextInt(1000);
		
		PojoClassWithJson pojo=new PojoClassWithJson("varu", "crm"+randomNum, "created", 25);
		//post
		Response resp = given().contentType(ContentType.JSON).body(pojo).when().post("http://localhost:8084/addProject");
		String proId = resp.jsonPath().get("projectId");
		System.out.println("proId");
		resp.then().log().all();
		
		//get
		given()
		.pathParam("pid", proId)
		.when()
		.get("http://localhost:8084/projects/{pid}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		
	}

}
