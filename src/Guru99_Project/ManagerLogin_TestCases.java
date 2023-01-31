package Guru99_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ManagerLogin_TestCases {
	
	WebDriver driver;
	Properties prop;

	
	@BeforeSuite
	public void readProperties() throws IOException
	{
		
	Class_PropertiesAccess p = new	Class_PropertiesAccess();
	prop = p.properties();
	}
	
	
	@BeforeTest
	public void setPth()
	{
	System.out.println(prop.getProperty("driverPath"));
	System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));  

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
		//Call this method setUP
		
		System.out.print("This is before method");
		 driver = new ChromeDriver();
		driver.navigate().to(dynamicURL);

		driver.manage().window().maximize();
		System.out.println("This is before method");
		
		
	
	}
	
	@Test(dataProvider = "loginData")
	
	public void loginPage(String userName, String password) throws InterruptedException, IOException
//	public void loginPage() throws InterruptedException, IOException
	{	
		
	// validate button
	Thread.sleep(1000);
	
	WebElement txtFieldUserName = driver.findElement(By.xpath(prop.getProperty("ManagerUserName")));
	txtFieldUserName.sendKeys(userName);
	WebElement txtFieldPassword  = driver.findElement(By.xpath(prop.getProperty("ManagerPassword")));
	
	txtFieldPassword.sendKeys(password);
	WebElement loginButton = driver.findElement(By.xpath(prop.getProperty("ButtonLogin")));
	
	Thread.sleep(1000);
	loginButton.click();
	
	
	Thread.sleep(2000);
	
	if (isAlertPresent())
	{
		
	var myAlert = driver.switchTo().alert();
	System.out.println(myAlert.getText());
	myAlert.accept();
	
	}
	
	else
	{
	System.out.println("I am logged In");
		
	}
	}
	
	
	public boolean isAlertPresent()
	{
		
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException ex)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name = "loginData")
	public Object[][] myTestData() throws IOException
	{
		Class_ExcelDataFile d = new Class_ExcelDataFile();
		return d.myData("Sheet1");	
		
	}
	@AfterMethod
	public void afterMethod()
	{
		
		// Tear Down
//	System.out.println("This is after method");
	driver.quit();
	
	}
	
	@AfterClass
	public void afterClass()
	{
//	System.out.println("This is after Class");
	
	}
	
	
	@AfterTest
	public void afterTest()
	{
//	System.out.println("This is after Test");
	
	}

}
