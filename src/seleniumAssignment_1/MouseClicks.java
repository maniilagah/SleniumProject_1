package seleniumAssignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseClicks {
	static WebDriver driver;
	static JavascriptExecutor js;

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");  

		  driver = new ChromeDriver();
		  
		   js = (JavascriptExecutor) driver;
		  openThisWebsite("https://demoqa.com/buttons");
		  Thread.sleep(1000);
		  automate_();

	}
	public static void openThisWebsite(String address)
	{
		
	driver.get(address);
        
	}
	
	
	public static void automate_() throws InterruptedException
	{
		
		//button[@id='rightClickBtn']/following::button[1]
		//button[@id='rightClickBtn']/parent::button[1]
		//button[@id='rightClickBtn']/preceeding::button[1]
		//button[@id='rightClickBtn']/child::button[1]
		
		Actions act=new Actions(driver);
		
		
//		doubleClickBtn
		var button1 = driver.findElement(By.id("doubleClickBtn"));
		var button2 = driver.findElement(By.id("rightClickBtn"));
		
		var button3 = driver.findElement(By.xpath("//button[text()='Click Me']"));
		
		System.out.println("the tag of the element is " + button1.getTagName());
		
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", button1);
		System.out.println("the tag of the element is " + button1.getTagName());
		Thread.sleep(1000);
		act.moveToElement(button1).doubleClick().build().perform();
		Thread.sleep(1000);
		act.moveToElement(button2).contextClick().build().perform();
		Thread.sleep(1000);
		act.moveToElement(button3).click().build().perform();
	

	}
	

}
