package TestNG_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Annotations {
	WebDriver driver;
	
	
	
	@BeforeTest
	public void setPth()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");  

	}
	
	
	
	@BeforeSuite
	public void beforeSuite()
	{
	System.out.println("This is before Suite");
	
	}
	
	@BeforeClass
	public void beforeClass()
	{
	System.out.println("This is before Class");
	
	}
	
	@BeforeMethod
	@Parameters({"url"})
	public void beforeMethod(String dynamicURL)
	
	{
		//Call thsi method setUP
		
		System.out.print("This is before method");
		 driver = new ChromeDriver();
		driver.navigate().to(dynamicURL);

		driver.manage().window().maximize();
		System.out.println("This is before method to open a website");
	
	}
//	@Test(invocationCount = 2)
	
	@Test(invocationCount = 2)
	
	public void loginTest()
	{
	System.out.println("This is original test 1");
	
	// validate button
	
	boolean b = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).isDisplayed();
	
	if (b)
	{
		System.out.print("Hey it is displayed");
	}
	else
	{
		System.out.print("Hey it is NOT displayed");

	}
	
	}
	
	
	@Test(dependsOnMethods = "loginTest")
	public void verifyHomeScreen()
	{
	
	boolean c = driver.findElement(By.linkText("Gmail")).isDisplayed();
	
		Assert.assertTrue(c,"Hey" + " Gmail " + "button is displayed");
//		Assert.assertFalse(c,"Hey" + " Gmail " + "button is NOT displayed");
	

	
	 
	}
		 
	
	@Test(invocationCount = 2)
	public void loginTest2()
	{
	System.out.println("This is login test2");
	
	// validate button
	
	boolean b = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).isDisplayed();
	
	if (b)
	{
		System.out.print("Hey it is displayed");
	}
	else
	{
		System.out.print("Hey it is NOT displayed");

	}
	
	}
	
	
	@Test(dependsOnMethods = "loginTest")
	public void verifyHomeScreen2()
	{
	
	boolean c = driver.findElement(By.linkText("Gmail")).isDisplayed();
	
		Assert.assertTrue(c,"Hey" + " Gmail " + "button is displayed");
//		Assert.assertFalse(c,"Hey" + " Gmail " + "button is NOT displayed");
	

	
	 
	}
	
	//Assertions
	
	@Test()
	public void sendKeys()
	{
		Assert.assertEquals("Manish", "Kumar","Paramter2 one is exepected value and parameter1 is found value");
		
		
	}
	
	
	@AfterMethod
	public void afterMethod()
	{
		
		// Tear Down
	System.out.println("This is after method");
	driver.quit();
	
	}
	
	@AfterClass
	public void afterClass()
	{
	System.out.println("This is after Class");
	
	}
	
	
	@AfterTest
	public void afterTest()
	{
	System.out.println("This is after Test");
	
	}
	
	
}
