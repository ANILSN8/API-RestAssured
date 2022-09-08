package SeralizationAndDesrilization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoclassforseralizationanddeserialization.Employe;

public class EmploySerialization {

	public static void main(String[] args) throws Throwable{
		// creat a object of pojo class
		Employe emp=new Employe("Anil", "Ty0016", "anil123@gmail.com", 9876);
		
		//creat an objectmapper
		ObjectMapper objmap=new ObjectMapper();
		
		//use write value
		objmap.writeValue(new File("./emp.json"), emp);

	}

}
