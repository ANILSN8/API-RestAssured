package DifferentWayToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoclassforseralizationanddeserialization.PojoClassWithJson;

public class PostByPojoTest {
	
	
	@Test
	public void post() {
		PojoClassWithJson pojo=new PojoClassWithJson("santu", "flinlo", "created", 10);
		
		given()
		.body(pojo).contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}

}
