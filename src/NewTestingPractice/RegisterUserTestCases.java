package NewTestingPractice;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
		elements.setName("Manish Kumar");
		
	}
	@Test()
	public void B_enterEmail()
	{
		elements.setEmail("Maniilagah@gmail.com");	
		
	}
	@Test()
	public void C_registerUser(){
	
	
		elements.signUP_Click();
		
		
	}
	
	@Test()
	public void D_verifyNameEmailVisible()
	{
		
		String name = driver.findElement(elements.txtField_Name).getAttribute("value");
		String email = driver.findElement(elements.txtField_Email).getAttribute("value");
		
		System.out.println("The value of name is " + name + " The value of email is " + email);
		if(name=="" || email == "")
		{
		Assert.fail();
		}		
		
	}
	
	@Test()
	public void D_datePicker()
	{
	elements.selectDate("12", "11", "1995");	
		
	}
	

}
