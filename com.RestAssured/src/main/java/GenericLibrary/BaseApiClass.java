package GenericLibrary;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class BaseApiClass {
	
	
	 DataBaseUtility dlib=new DataBaseUtility();
	 ExcelUtility elib=new ExcelUtility();
	 FileUtility flib=new FileUtility();
	JavaUtility jlib=new JavaUtility();
	 RestAssuredLibrary rlib=new RestAssuredLibrary();
	
	@BeforeSuite
	public void bsconfig() {
		dlib.connectToDB();
		
	}
    
	@AfterSuite
	public void asconfig() {
		dlib.closeDB();
	}

}
