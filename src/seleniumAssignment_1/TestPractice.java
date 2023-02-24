package seleniumAssignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPractice {

	static WebDriver driver;
	static JavascriptExecutor js;
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");  

		  driver = new ChromeDriver();
		   js = (JavascriptExecutor) driver;
//		  openThisWebsite("https://demoqa.com/automation-practice-form");
		   
		 
		  driver.manage().window().maximize();
		  openThisWebsite("https://www.dominos.ca/en/pages/order/menu#!/menu/category/entrees/");

	}
	
	public static void openThisWebsite(String address) throws InterruptedException
	{
		
		
	driver.get(address);
	
	
	Thread.sleep(1000);
	WebElement element = driver.findElement(By.xpath("//*[@data-dpz-track-evt-name='Order | Philly Steak']//parent::div"));
	
	js.executeScript("arguments[0].scrollIntoView();", element);
	Thread.sleep(1000);
	
	element.click();
	element.click();
	
        
	}

}
