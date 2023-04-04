package seleniumAssignment_1;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropContries_Capitals {
	static WebDriver driver;
	static JavascriptExecutor js;

	public static void main(String[] args) throws InterruptedException {
		
		
		
		getCountries();
		

	}
	
	public static void openThisWebsite(String address)
	{
		
	driver.get(address);
        
	}
	
	public static void getCountries() throws InterruptedException
	{
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");  

		  driver = new ChromeDriver();
		   js = (JavascriptExecutor) driver;
			driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		  
		driver.manage().window().maximize();
		
		
		 Actions act=new Actions(driver);
		 WebElement elements1 = driver.findElement(By.id("dropContent"));

		 
		 
		 var allCapitalDivs = elements1.findElements(By.xpath("./child::*"));

		 int count = 1;
		 for (WebElement capital : allCapitalDivs)
		 {
			String forCapital = String.valueOf(count);
			String forCountry = String.valueOf(count+100);
			
			String capital_ID = "//div[@id='box" + forCapital + "']";
			String country_ID = "//div[@id='box" + forCountry + "']";
			
			System.out.println("capital id is  " + capital_ID);
			System.out.println("country id is  " + country_ID);			
			var move_capital = capital.findElement(By.xpath(capital_ID)); 
			var to_country = driver.findElement(By.xpath(country_ID));
			Thread.sleep(1000);
			
			act.dragAndDrop(move_capital, to_country).build().perform();	
			Thread.sleep(1000);
			
			count++;
		 
		 }
		
		 System.out.println("count is " + count);
	 
		 
	}
	

}
