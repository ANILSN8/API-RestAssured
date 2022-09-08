package DifferentWayToPost;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostByJsonFile {
	
	@Test
	public void JsonFile() {
		File file=new File("./src/test/resources/Data.json");
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}
	

}
