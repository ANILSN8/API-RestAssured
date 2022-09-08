package SeralizationAndDesrilization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoclassforseralizationanddeserialization.Employeee;
import pojoclassforseralizationanddeserialization.Pojospouse;

public class SpouseWithSerialization {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		Pojospouse pojo = new Pojospouse("abc", "abc234");
		Employeee emp = new Employeee("ani", "ani234", pojo);
		//creat an objectmapper
				ObjectMapper objmap=new ObjectMapper();
				
				//use write value
				objmap.writeValue(new File("./empspouse.json"), emp);


	}

}
