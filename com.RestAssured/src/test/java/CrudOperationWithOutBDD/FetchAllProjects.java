package CrudOperationWithOutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class FetchAllProjects {
	
	@Test
	public void Fetchall() {
		
				Response response = RestAssured.get("http://localhost:8084/projects");
				ValidatableResponse validateres = response.then();
				validateres.assertThat().statusCode(200);
				validateres.log().all();
				
	}

}
