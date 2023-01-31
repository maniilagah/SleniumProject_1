package seleniumAssignment_1;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandler {
	static WebDriver driver;

	static JavascriptExecutor js;

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");  

		 driver = new ChromeDriver();
		 js = (JavascriptExecutor) driver;
		driver.get("https://demoqa.com/browser-windows");
		  
		driver.manage().window().maximize();
//		newTab();
//		newWindowButton();
		newWindowMessage();

	}	
//	sampleHeading
	
	public static void newTab()
	{
		
		WebElement button = driver.findElement(By.id("tabButton"));
		String currentWindow = driver.getWindowHandle();
		System.out.println("My current windwo is" + currentWindow);
		button.click();
		Set<String> myHandlers = driver.getWindowHandles();

		for(String handle:myHandlers)
		{
			if(!(currentWindow.equals(handle)))
			{
			System.out.println(" I am in the new tab with window ID--> " + handle);
			driver.switchTo().window(handle);
			
			System.out.println(driver.findElement(By.id("sampleHeading")).getText());
			}	
		}		
	}
	
	
	public static void newWindowButton()
	{
		
		WebElement button = driver.findElement(By.id("windowButton"));
		String currentWindow = driver.getWindowHandle();
		System.out.println("My current windwo is" + currentWindow);
		button.click();
		Set<String> myHandlers = driver.getWindowHandles();

		for(String handle:myHandlers)
		{
			if(!(currentWindow.equals(handle)))
			{
			System.out.println(" I am in the Window with ID--> " + handle);
			driver.switchTo().window(handle);
			
			System.out.println(driver.findElement(By.id("sampleHeading")).getText());
			}	
		}
		}

	
	public static void newWindowMessage() 
	{
		
		WebElement button = driver.findElement(By.id("messageWindowButton"));
		String currentWindow = driver.getWindowHandle();
		System.out.println("My current windwo is" + currentWindow);
		button.click();
		Set<String> myHandlers = driver.getWindowHandles();

		for(String handle:myHandlers)
		{
			if(!(currentWindow.equals(handle)))
			{
			System.out.println(" I am in the message Window with ID--> " + handle);
			driver.switchTo().window(handle);
			String newCurrentWindow = driver.getWindowHandle();
			System.out.println(" I am in the message Window with ID--> " + newCurrentWindow);
			


			
			}
		
		
			
		}
		
		
		
		
	}

}
