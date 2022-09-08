package Validation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class TimeValidation {
	
	@Test
	public void time() {
	
	when()
	.get("http://localhost:8084/projects")
	//validation
			.then()
			  .assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
			  .assertThat().body("[4].projectName", Matchers.equalTo("eturotic"))
			  .log().all();
}
}