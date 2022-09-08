package Validation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicValidation {
	@Test
	
	public void dynamicresponse() {
		String expdata = "TY_PROJ_1002";
		
		
		//action
		Response resp = when().get("http://localhost:8084/projects");
		
		
		//validation
		boolean flag = false;
		List<String> pIDs = resp.jsonPath().getList("projectId");
		for(String projectID : pIDs)
		{
			if(projectID.equalsIgnoreCase(expdata))
			{
				flag = true;
			}
		}
		
		Assert.assertTrue(flag);
		System.out.println("data verfied");
		
		resp.then().log().all();
	}
	}


