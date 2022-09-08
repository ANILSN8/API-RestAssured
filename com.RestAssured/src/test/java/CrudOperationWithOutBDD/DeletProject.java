package CrudOperationWithOutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeletProject {
	
	@Test
	public void Delet() {
		
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_813");
		ValidatableResponse validateres = response.then();
		validateres.assertThat().statusCode(204);
		validateres.log().all();
		
	}

}
