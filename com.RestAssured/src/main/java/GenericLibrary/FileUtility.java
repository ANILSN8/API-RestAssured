package GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String getPropertyValue(String key) throws IOException {
	FileInputStream fis=new FileInputStream(IConstants.filepath);
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	
	return value;
}
}
