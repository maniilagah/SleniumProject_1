package Guru99_Project;

import java.io.IOException;
import java.util.Properties;

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

public class NewCustomer_TestCases {

	WebDriver driver;
	Properties prop;

	
	@BeforeSuite
	public void readProperties() throws IOException
	{
		
	Class_PropertiesAccess p = new	Class_PropertiesAccess();
	prop = p.properties();
	
	}
	
	
	@BeforeTest
	public void setPth() throws IOException, InterruptedException
	{
	

		System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));
		driver = new ChromeDriver();
		
		LoginManager_BeforeTest a = new LoginManager_BeforeTest();
		a.loginManagerBeforeTest(driver,"https://demo.guru99.com/V4/index.php",prop, "mngr465089","bUnYmur");


	}
	


	@BeforeClass
	public void beforeClass()
	{
	System.out.println("This is before Class");
	
	}
	

	
//	@Test(dataProvider = "loginData")
//	
//	public void loginPage(String CustomerName,String Gender, String DOB, String Address, String City, String State, String PIN, String MobileNumber, String Email, String	Password) throws InterruptedException, IOException
	@Test
	public void loginPage() throws InterruptedException, IOException
	{	
	

	
	
	// validate button
	Thread.sleep(1000);
	
	WebElement txtFieldUserName = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a"));
//	txtFieldUserName.sendKeys("jgfjg gf j");
//	WebElement txtFieldPassword  = driver.findElement(By.xpath(prop.getProperty("ManagerPassword")));
//	
//	txtFieldPassword.sendKeys(password);
//	WebElement loginButton = driver.findElement(By.xpath(prop.getProperty("ButtonLogin")));
//	
	Thread.sleep(1000);
	txtFieldUserName.click();
	
	
	Thread.sleep(2000);
	
	if (isAlertPresent())
	{
		
	var myAlert = driver.switchTo().alert();
	System.out.println(myAlert.getText());
//	myAlert.dismiss();
//	myAlert.accept();
	
	
	 WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
	    driver.switchTo().frame(frame1);
	    WebElement frame2 = driver.findElement(By.id("ad_iframe"));
	    driver.switchTo().frame(frame2);
	    driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
	    driver.switchTo().defaultContent();
	    txtFieldUserName.click();
		
	
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
		return d.myData("AddNewCustomer");	
		
	}
	@AfterMethod
	public void afterMethod()
	{
		
		// Tear Down
//	System.out.println("This is after method");
//	driver.quit();
	
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
