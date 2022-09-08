package UsingFrameWorkImpliment;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import GenericLibrary.EndPointLibrary;
import GenericLibrary.IConstants;

public class DeleteProject{
	
	@Test
	public void delete() {
		when()
		.delete(IConstants.baseURI+EndPointLibrary.getSingleProject+"TY_PROJ_2602")
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}
}
