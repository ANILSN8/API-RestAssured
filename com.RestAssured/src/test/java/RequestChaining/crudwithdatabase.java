package RequestChaining;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclassforseralizationanddeserialization.PojoClassWithJson;

public class crudwithdatabase {
	
	@Test
	public void crud() throws SQLException {
		
		Random random=new Random();
		int randomNum = random.nextInt(1000);
		
		PojoClassWithJson pojo=new PojoClassWithJson("punith", "kisko"+randomNum, "created", 25);
		//post
		Response resp = given()
	    .contentType(ContentType.JSON)
	    .body(pojo)
	    .when()
	    .post("http://localhost:8084/addProject");
		String proId = resp.jsonPath().get("projectId");
		System.out.println("proId");
		resp.then().assertThat().statusCode(201).log().all();
		
		//read
		given()
		.pathParam("pid", proId)
		.when()
		.get("http://localhost:8084/projects/{pid}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		//update
PojoClassWithJson pojo1=new PojoClassWithJson("punith sn", "crm"+randomNum, "on going", 15);
		
		given()
		.body(pojo1)
		.contentType(ContentType.JSON)
		.pathParam("pid", proId)
		.when()
		.put("http://localhost:8084/projects/{pid}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		//delete
		given()
		.pathParam("pid", proId)
		.when()
		.delete("http://localhost:8084/projects/{pid}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
		//database
		//register to Db
				Driver driverref=new Driver();
				DriverManager.registerDriver(driverref);

				//step2:connect to db
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");

				//step3:creat statement or query
				Statement statement = connection.createStatement();
				String query = "select * from project";

				//step4:execute query
				ResultSet result = statement.executeQuery(query);
				boolean flag = false;
				while(result.next()) {
					String allprojid = result.getString(1);
					if(allprojid.contains(proId)) {
						flag=true;
						break;	
					}
				}
				if(flag) {
					System.out.println("project is created in db");
				}
				else {
					System.out.println("project is deleted in db");
				}

				//step5:close the database
				connection.close();

		
	}

}
