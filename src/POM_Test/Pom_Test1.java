package POM_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Pom_Test1 {

	
	@BeforeClass
	public void myTest3()
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.ca/");
		System.out.println("I am in BeforeClass");
	}
	
	@AfterClass
	public void myTest2()
	{
		
		System.out.println("I am in the After Class");
	}
}
