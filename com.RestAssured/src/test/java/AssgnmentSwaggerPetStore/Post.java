package AssgnmentSwaggerPetStore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Post {
	
	@Test
	
	public void post() {
		
	JSONObject jsob=new JSONObject();
	jsob.put("id", 123);
	jsob.put("petId", 244);
	jsob.put("quantity", 55);
	jsob.put("shipDate", "2022-09-06T10:55:04.503Z");
	jsob.put("status", "placed");
	jsob.put("complete", true);
	
	given()
	.body(jsob)
	.contentType(ContentType.JSON)
	
	.when()
	.post("https://petstore.swagger.io/v2/store/order")
	
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
	
	}

}
