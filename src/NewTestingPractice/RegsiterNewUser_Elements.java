package NewTestingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegsiterNewUser_Elements {
	
	
	WebDriver driver;
	
	By txtFeild_SignUP_Name = By.xpath("//*[@placeholder=\"Name\" and @data-qa=\"signup-name\"]");
	By txtField_SignUP_Email = By.xpath("//*[@placeholder=\"Email Address\" and @data-qa=\"signup-email\"]");
	
	By btn_SignUP = By.xpath("//*[@data-qa=\"signup-button\"]");
	By txtField_Name = By.xpath("//input[@data-qa=\"name\"]");
	By txtField_Email = By.xpath("//input[@data-qa=\"email\"]");
	By txtField_Password = By.xpath("//input[@data-qa=\"Password\"]");
	By txtField_Day = By.xpath("//*[@data-qa=\"days\"]");
	By txtField_Month = By.xpath("//*[@data-qa='months']");
	By txtField_Year = By.xpath("//*[@data-qa='years']");
	By checkBox_NewsLetter = By.xpath("//*[@name='newsletter']");
	By checkBox_SpecialOffers = By.xpath("//*[@id='optin']");
	
	RegsiterNewUser_Elements(WebDriver driver)
	{
		
		this.driver = driver;
		
	}
	
	
	public void setName(String name)
	{
		driver.findElement(txtFeild_SignUP_Name).sendKeys(name);
		
	}
	
	public void setEmail(String email)
	{
	
		driver.findElement(txtField_SignUP_Email).sendKeys(email);
	}
	
	public void signUP_Click() 
	{
		driver.findElement(btn_SignUP).click();
		
	}
	
	
	public void selectDate(String i,String j, String k)
	{
		 WebElement element	 = driver.findElement(txtField_Day);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", element);
				
	Select dayDropDown = new  Select(element);

	dayDropDown.selectByValue(i);
	
	Select monthDropDown = new  Select(driver.findElement(txtField_Month));
	monthDropDown.selectByValue(j);
	
	Select yearDropDown = new  Select(driver.findElement(txtField_Year));
	yearDropDown.selectByValue(k);
	}
}
