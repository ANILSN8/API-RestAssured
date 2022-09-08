package UsingFrameWorkImpliment;



import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import GenericLibrary.EndPointLibrary;
import GenericLibrary.IConstants;
import GenericLibrary.JavaUtility;
import GenericLibrary.PojoClass;
import io.restassured.http.ContentType;

public class CreatAnObject  {
	@Test
	
public void creatpro() {
		JavaUtility jlib=new JavaUtility();
		int ran = jlib.getRandomNum();
		PojoClass pojo=new PojoClass("salar", "plio"+ran, "created", 20);
		//action
		given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.when()
		.post(IConstants.baseURI+EndPointLibrary.creatProject)
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
