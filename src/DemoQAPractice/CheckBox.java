package DemoQAPractice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Duration;


public class CheckBox {

	static WebDriver driver;
	static JavascriptExecutor js;
	static WebDriverWait wait;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
//		js = (JavascriptExecutor) driver;
//		wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(30));	
//		driver.get("https://demoqa.com/elements");
//		driver.manage().window().maximize();
//		checkBox();
//		radioButton();
//		webTables();
	}
	
	public static void checkBox()
	{
	String xPath = "//*[text()=\"Elements\"]//parent::div[@class=\"header-wrapper\"]";
	
	WebElement element = driver.findElement(By.xpath(xPath));
	
	waitTime(driver,xPath,10);
	element.click();
	
	driver.findElement(By.xpath("//span[text()=\"Check Box\"]")).click();
	
//  https://www.scientecheasy.com/2019/08/xpath-axes.html/	
//	//label[@for="tree-node-downloads"]//preceding-sibling::button
//  //label[@for="tree-node-desktop"]//preceding-sibling::button
	driver.findElement(By.xpath("//*[@for='tree-node-home']")).click();
	driver.findElement(By.xpath("//*[@for='tree-node-home']//preceding-sibling::button")).click();
	driver.findElement(By.xpath("//*[@for=\"tree-node-documents\"]")).click();
	driver.findElement(By.xpath("//label[@for=\"tree-node-downloads\"]//preceding-sibling::button")).click();
	driver.findElement(By.xpath("//label[@for=\"tree-node-desktop\"]//preceding-sibling::button")).click();
	
	
//	driver.quit();
	}
	
	
	public static void radioButton() 
	{
		
		
		WebElement element = driver.findElement(By.xpath("//span[text()=\"Radio Button\"]"));
//		waitTime(driver,xpath,5);
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
	
//		js.executeScript("arguments[0].scrollIntoView();", tables);
		
		try
		{
		Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"yesRadio\"]//following-sibling::label")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"impressiveRadio\"]//following-sibling::label")).click();
	WebElement ele = driver.findElement(By.xpath("//*[@id=\"noRadio\"]//following-sibling::label"));
	ele.click();
//	Boolean a = driver.findElement(By.xpath("//*[@id=\"noRadio\"]//following-sibling::label")).isSelected();
	
	System.out.print("The third button is enabled "  + ele.isSelected());
	
	
		}
		catch(Exception e)
		{
		System.out.print("I am in the exception block" + e.getLocalizedMessage());
			
		}	
	}
	
	
	public static void webTables()
	{
		
		WebElement element = driver.findElement(By.xpath("//span[text()=\"Web Tables\"]"));
//		
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		element.click();
		driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]")).click();
		
//		waitTime(driver,"//input[@id='firstName']",5);
	
		driver.findElement(By.xpath("//input[@id=\"firstName\"]")).sendKeys("Manish");
		driver.findElement(By.xpath("//input[@id=\"lastName\"]")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@id=\"userEmail\"]")).sendKeys("Maniilagah@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"age\"]")).sendKeys("28");
		
		driver.findElement(By.xpath("//input[@id=\"salary\"]")).sendKeys("700000");
		driver.findElement(By.xpath("//input[@id=\"department\"]")).sendKeys("IT");
		driver.findElement(By.xpath("//button[@id='submit']")).click();		
	}
	

	
	public static void waitTime(WebDriver driver,String xpath,int timeout)
	{
		new WebDriverWait(driver,java.time.Duration.ofSeconds(timeout)).
		until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
	}
	
}
