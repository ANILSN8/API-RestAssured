package SeralizationAndDesrilization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import pojoclassforseralizationanddeserialization.PojoClassArray;

public class EmployArrayRead {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		ObjectMapper objmap = new ObjectMapper();
		
		
		 PojoClassArray e1 = objmap.readValue(new File("./emp1.json"), PojoClassArray.class);
		
		System.out.println(e1.getemployemail());
		System.out.println(e1.getemployId());
		System.out.println(e1.getemployphonenum()[0]);

	}

}
