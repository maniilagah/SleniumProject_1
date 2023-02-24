package NewTestingPractice;

import org.testng.annotations.Test;

import Guru99_Project.Class_PropertiesAccess;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterUserTestCases {
	
	WebDriver driver;
	RegsiterNewUser_Elements elements;
	
	
	@BeforeTest
	public void openWebsite()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		GoToHomePage home = new GoToHomePage();
		home.GoToHomePage(driver);
		GoToRegistrationPage goTo = new GoToRegistrationPage();
		goTo.GoToRegistrationPage(driver);
			
	}
	
	@BeforeMethod
	public void goToSignUpPage()
	{
		System.out.println("I am in before method");
		elements = new RegsiterNewUser_Elements(driver);	
	}
	@Test()
	public void A_enterName()
	{
		
	 driver.findElement(By.xpath("//*[@placeholder=\"Name\" and @data-qa=\"signup-name\"]")).sendKeys("Manish");

	 String url = driver.getCurrentUrl();
		driver.get(url);	
	
		
//		driver.findElement(By.xpath("//*[@placeholder=\"Name\" and @data-qa=\"signup-name\"]")).sendKeys("Lagah");
		
		
		
		
	}
	@Test()
	public void B_enterEmail()
	{
		elements.setEmail("Maniilagah@gmail.com");	
		
	}
	@Test()
	public void C_registerUser(){
	
		
//		driver.get();
		elements.signUP_Click();
	}
	
	@Test()
	public void D_verifyNameEmailVisible()
	{
		
		String name = driver.findElement(elements.txtField_Name).getAttribute("value");
		String email = driver.findElement(elements.txtField_Email).getAttribute("value");
		
		Assert.assertEquals("", "");
		
		System.out.println("The value of name is " + name + " The value of email is " + email);
		if(name=="" || email == "")
		{
		Assert.fail();
		
		
		}		
		
	}
	
//	@Test()
//	public void D_datePicker()
//	{
//		
//		
//	}
//	@Test()
//	public void selectCheckBoxes()
//	{
//		elements.checkBox_newsLetter();
//		elements.checkBox_specialOffer();
//		
//	}
	
	
	@Test(dataProvider = "userData")
	public void reg_User(String title,String password,String DOB,String checkBox_NewsLetter,String checkBox_SpecailOffer,String firstName,String lastName,String company,String houseNumber,String streetName,String Country,String state,String city,String zipCode,String mobileNumber)
	{
		
		System.out.println(title);
		System.out.println(password);
		System.out.println(DOB);
		System.out.println(checkBox_NewsLetter);
		System.out.println(checkBox_SpecailOffer);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(company);
		System.out.println(houseNumber);
		System.out.println(streetName);
		System.out.println(Country);
		System.out.println(state);
		System.out.println(city);
		System.out.println(zipCode);
//		System.out.println(mobileNumber);
//		
//		
//	elements.setcheckBox_Title(title);
//	elements.setPassword(password);
//	elements.setDate(DOB);
	
	
		
		
		
		
		
		
		
	}
	
	@DataProvider(name = "userData")
	public Object[][] myData() throws IOException
	{
		
		var prop = Class_PropertiesAccess.properties();
	
		return DataProviderClass.testData(prop.getProperty("Sheet_NewUserRegData"));
		
	}
	
	
	
	

	

}
