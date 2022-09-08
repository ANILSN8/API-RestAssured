package UsingFrameWorkImpliment;

import org.testng.annotations.Test;

import GenericLibrary.EndPointLibrary;
import GenericLibrary.IConstants;

import static io.restassured.RestAssured.*;

public class ReadTheData   {
@Test

public void read() {
	
	when()
	.get(IConstants.baseURI+EndPointLibrary.getAllProjects)
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
	
}
}
