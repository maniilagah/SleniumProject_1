package Guru99_Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Class_PropertiesAccess {
	
	
	 static Properties prop;
	public static Properties properties() throws IOException
	{
		
		try {
			
	InputStream input = new FileInputStream("src/config.properties");
	prop = new Properties();
		
		prop.load(input);
		
		return prop;
		
		}
		catch(FileNotFoundException e)
		{
			System.out.print(e.getLocalizedMessage());
			e.printStackTrace();
			return prop;
		}
	}

}
