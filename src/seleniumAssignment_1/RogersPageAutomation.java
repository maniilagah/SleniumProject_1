package seleniumAssignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RogersPageAutomation {
	
		static WebDriver driver;
		static JavascriptExecutor js;

		public static void main(String[] args) throws InterruptedException {
			
	 
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");  

			  driver = new ChromeDriver();
			   js = (JavascriptExecutor) driver;
			  openThisWebsite("https://www.rogers.com/phones/?icid=R_WIR_JOR_WBOM11");
			  Thread.sleep(4000);
			  automate_();
		}
		
		public static void openThisWebsite(String address)
		{
			
		driver.get(address);
	        
		}
		
		public static void automate_() throws InterruptedException
		{
			
			var element = driver.findElement(By.xpath("//button[@title='Monthly payment breakdown iPhone 14']"));
			System.out.println("i m here manish " + element.getTagName() + element.isDisplayed() + element.isSelected() + element.isEnabled());
//			js.executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(3000);
			element.click();
			

	
		}
		
	
}
