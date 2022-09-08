package SeralizationAndDesrilization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoclassforseralizationanddeserialization.Employe;

public class EmployDesiralization {

	public static void main(String[] args) throws Throwable, Throwable, Throwable {
	
		ObjectMapper objmap = new ObjectMapper();
		
		
		 Employe e1 = objmap.readValue(new File("./emp.json"), Employe.class);
		
		System.out.println(e1.getemployemail());
		System.out.println(e1.getemployId());

	}

}
