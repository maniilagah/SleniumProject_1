package NewTestingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoToHomePage {
	
	
	public void GoToHomePage(WebDriver driver)
	{
	
	  
	driver.get("https://automationexercise.com/");
	driver.manage().window().maximize();
	
	}
	

}
