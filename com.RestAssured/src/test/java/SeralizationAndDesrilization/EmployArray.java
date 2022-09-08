package SeralizationAndDesrilization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoclassforseralizationanddeserialization.PojoClassArray;

public class EmployArray{

	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		int [] arr= {896,987};
		// creat a object of pojo class
	
		PojoClassArray pojo=new PojoClassArray("anil sn", "an234", "anil123@gmail.com", arr);
				//creat an objectmapper
				ObjectMapper objmap=new ObjectMapper();
				
				
				//use write value
				objmap.writeValue(new File("./emp1.json"),pojo);
				


	}

}
