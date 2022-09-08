package Rmgyantra;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import GenericLibrary.EndPointLibrary;
import GenericLibrary.IConstants;
import GenericLibrary.JavaUtility;
import GenericLibrary.PojoClass;
import static io.restassured.RestAssured.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiWithRmg {

	@Test
	public void Rmgy() {

			JavaUtility jlib=new JavaUtility();
			int ran = jlib.getRandomNum();
		PojoClass pojo=new PojoClass("varada", "flio"+ran, "created", 20);
		//action
			Response resp = given()
		.contentType(ContentType.JSON)
			.body(pojo)
		.when()
			.post(IConstants.baseURI+EndPointLibrary.creatProject);
			String proId = resp.jsonPath().get("projectId");





		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		//driver.findElement(By.name("projectName")).sendKeys(proId);
		//driver.findElement(By.name("createdBy")).sendKeys("varada");
		WebElement dropdown = driver.findElement(By.xpath("//label[text()='Project Status ']/..//select[@name='status']"));
		Select s=new Select(dropdown);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			Statement statement = connection.createStatement();
			String query="select * from project";
			ResultSet result = statement.executeQuery(query);
			boolean flag = false;
			while(result.next()) {
				String allprojects = result.getString(1);
				if(allprojects.contains(proId)) {
					flag=true;
					break;	
				}
			}
			if(flag) {
				System.out.println("project is created in db");
			}
			else {
				System.out.println("project is not created in db");
			}
		}catch(Exception e) {
			e.printStackTrace();

		}finally {
		
		}
		driver.quit();
	}
}


