package UsingFrameWorkImpliment;

import static io.restassured.RestAssured.given;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import GenericLibrary.EndPointLibrary;
import GenericLibrary.IConstants;
import GenericLibrary.PojoClass;
import io.restassured.http.ContentType;

public class UpdatetheProject {
	@Test
	public void update() {
	PojoClass pojo=new PojoClass("salar", "pilio", "ongoing", 300);
	//action
	given()
	.contentType(ContentType.JSON)
	.body(pojo)
	.when()
	.put(IConstants.baseURI+EndPointLibrary.updateProject+"TY_PROJ_2602")
	.then()
	.assertThat().statusCode(200)
	.log().all();
	}
}
