package DataDrivenTesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import pojoclassforseralizationanddeserialization.PojoClassWithJson;

public class ReadTheDataFromExcel  {
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
		public Object[][] data() throws Throwable{
			Object[][] obj=new Object[3][4];
			GenericLibrary.ExcelUtility elib=new GenericLibrary.ExcelUtility();
			
			obj[0][0]=elib.getExcelData("pojo", 1, 0);
			obj[0][1]=elib.getExcelData("pojo", 1, 1);
			obj[0][2]=elib.getExcelData("pojo", 1, 2);
			obj[0][3]=elib.getExcelData("pojo", 1, 3);
			
			obj[1][0]=elib.getExcelData("pojo", 2, 0);
			obj[1][1]=elib.getExcelData("pojo", 2, 1);
			obj[1][2]=elib.getExcelData("pojo", 2, 2);
			obj[1][3]=elib.getExcelData("pojo", 2, 3);
			
			obj[2][0]=elib.getExcelData("pojo", 3, 0);
			obj[2][1]=elib.getExcelData("pojo", 3, 1);
			obj[2][2]=elib.getExcelData("pojo", 3, 2);
			obj[2][3]=elib.getExcelData("pojo", 3, 3);
			
			return obj;
			
			
		}

	}
}
