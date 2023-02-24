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
	
	
	By checkBox_Mr = By.xpath("//*[@id=\"uniform-id_gender1\"]");
	By checkBox_Mrs = By.xpath("//*[@id=\"uniform-id_gender2\"]");
	
	By txtField_FirstName =  By.xpath("");
	By txtField_LastName =  By.xpath("");
	By txtField_CompanyName =  By.xpath("");
	By txtField_StreetNumber =  By.xpath("");
	By txtField_StreetName =  By.xpath("");
	
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
	
	
	public void setDate(String date)
	{
		var date1 = date.split("/");
		 WebElement element	 = driver.findElement(txtField_Day);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", element);
				
	Select dayDropDown = new  Select(element);
	dayDropDown.selectByValue(date1[0]);
	
	Select monthDropDown = new  Select(driver.findElement(txtField_Month));
	monthDropDown.selectByValue(date1[1]);
	
	Select yearDropDown = new  Select(driver.findElement(txtField_Year));
	yearDropDown.selectByValue(date1[2]);
	}
	
	
	public void setcheckBox_newsLetter()
	{
		
		WebElement checkBox = driver.findElement(checkBox_NewsLetter);
		checkBox.click();
		
	}
	public void setcheckBox_specialOffer()
	{
		
		WebElement checkBox = driver.findElement(checkBox_SpecialOffers);
		checkBox.click();
		
	}

	
	public void setPassword(String value)
	{
		
		driver.findElement(txtField_Password).sendKeys(value);
		
	}
	
	public void setFirstName(String value)
	{
		
		driver.findElement(txtField_Password).sendKeys();
		
	}
	public void setLastName(String value)
	{
		
		driver.findElement(txtField_Password).sendKeys();
		
	}
	
	
	public void setcheckBox_Title(String value)
	{
		
		
		if(value.equals("1"))
		{
		WebElement element = driver.findElement(checkBox_Mr);
		
			element.click();
		}
		else
		{
			WebElement element = driver.findElement(checkBox_Mrs);
			
			element.click();
		}
	}
}
