package UsingFrameWorkImpliment;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import GenericLibrary.EndPointLibrary;
import GenericLibrary.IConstants;

public class ReadSingleProject {
	@Test

	public void read() {
		
		when()
		.get(IConstants.baseURI+EndPointLibrary.getSingleProject+"TY_PROJ_2602")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}
}
