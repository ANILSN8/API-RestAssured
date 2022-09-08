package DataDrivenTesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclassforseralizationanddeserialization.PojoClassWithJson;

public class AddProjectUsingDataProviderTest {
	
	@Test(dataProvider = "getdata")
	public void creatproject(String createdBy,String projectName,String status,int teamsize) {
		
		PojoClassWithJson pojo=new PojoClassWithJson(createdBy, projectName, status, teamsize);
		
		given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
	
	@DataProvider(name="getdata")
	public Object[][] data(){
		Object[][] obj=new Object[3][4];
		
		obj[0][0]="jackson41";
		obj[0][1]="ticle001";
		obj[0][2]="created";
		obj[0][3]=6;
		
		obj[1][0]="jackson42";
		obj[1][1]="ticle002";
		obj[1][2]="created";
		obj[1][3]=8;
		
		obj[2][0]="jackson43";
		obj[2][1]="ticle003";
		obj[2][2]="created";
		obj[2][3]=8;
		
		return obj;
		
		
	}

}
