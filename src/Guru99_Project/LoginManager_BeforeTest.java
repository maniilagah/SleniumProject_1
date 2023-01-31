package Guru99_Project;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginManager_BeforeTest {

	
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
//		loginManagerBeforeTest(driver,"https://demo.guru99.com/V4/index.php","mngr465089","bUnYmur");
		
		
		
		

	}
	

	public void loginManagerBeforeTest(WebDriver driver,String webisteURL,Properties prop,String userName, String password) throws IOException, InterruptedException
	{
	
		
		driver.navigate().to(webisteURL);

		driver.manage().window().maximize();
		
		
		Thread.sleep(1000);
		
		WebElement txtFieldUserName = driver.findElement(By.xpath(prop.getProperty("ManagerUserName")));
		txtFieldUserName.sendKeys(userName);
		WebElement txtFieldPassword  = driver.findElement(By.xpath(prop.getProperty("ManagerPassword")));
		
		txtFieldPassword.sendKeys(password);
		WebElement loginButton = driver.findElement(By.xpath(prop.getProperty("ButtonLogin")));
		
		Thread.sleep(1000);
		loginButton.click();
		
		
		Thread.sleep(2000);
		
		if (isAlertPresent(driver))
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
	
	public boolean isAlertPresent(WebDriver driver)
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
	
	
	

}
