package DifferentWayToPost;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostByHashMap {
	@Test
	
	public void Hashmap() {
		HashMap hm=new HashMap();
		hm.put("createdBy", "parmesh11");
		hm.put("projectName","frederal22");
		hm.put("status", "created");
		hm.put("teamsize", 5);
		
		given()
		.body(hm)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
		
	}

}
