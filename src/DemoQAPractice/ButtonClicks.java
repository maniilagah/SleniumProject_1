package DemoQAPractice;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

import com.beust.jcommander.JCommander.Builder;

public class ButtonClicks {

	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static Actions action;
	
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
//		Actions act=new Actions(driver);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 js = (JavascriptExecutor) driver;
		 action = new Actions(driver);
		
		 driver.manage().window().maximize();
//		 doubleClick();
//		 workWithLinks();
//		 hitAPI();
//		 chooseFile();
//		 dynamicVeriable();
//		 newWindow();
		 alerts();
		 
		 
		

	}
	public static void doubleClick() throws InterruptedException
	{
		 driver.get("https://demoqa.com/buttons");
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//button[@id=\"doubleClickBtn\"]"));
//		arguments[0].scrollIntoView();
		js.executeScript("arguments[0].scrollIntoView();", element);
		 Thread.sleep(1000);
		act.moveToElement(element).perform();
		 Thread.sleep(1000);
		act.clickAndHold();
		act.doubleClick().build().perform();
		
		WebElement element2 = driver.findElement(By.xpath("//button[contains(text(),'Right Click Me')]"));
		act.moveToElement(element2).perform();
		Thread.sleep(1000);
		act.contextClick(element2).build().perform();
		
		WebElement element3 = driver.findElement(By.xpath("//button[text()='Click Me']"));
		act.moveToElement(element3).perform();
		Thread.sleep(1000);
		act.click(element3).build().perform();

	
	    	
		  } 
	public static void workWithLinks()
	{
		
		driver.get("https://demoqa.com/links");
		WebElement element = driver.findElement(By.xpath("//a[text()='Home']"));
		
		element.click();
		
		if (driver.getTitle()=="DEMOQA")
		{
			System.out.print("We are on the new window");
		}
		else
		{
			System.out.print("We are on the same page");
		}
		
	}
	
	public static void hitAPI()
	{
	
		driver.get("https://demoqa.com/links");
		WebElement element = driver.findElement(By.xpath("//a[@id='created']"));
		element.click();
		WebElement element2 = driver.findElement(By.xpath("//p[@id='linkResponse']"));

	
		js.executeScript("arguments[0].scrollIntoView();", element);
		
//		element.click();
		
		if (element2.getText()!= "")
		{
			System.out.print("We have this message [" + element2.getText() + "]");
		}
		else
		{
			System.out.print("We did not click on any button");
		}	
		
	}

	
	public static void chooseFile() throws IOException, InterruptedException
	{
	
	driver.get("https://demoqa.com/upload-download");
		
//	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys("C:\\\\Users\\\\Owner\\\\Geek Squad Setup Guide.pdf");

	
	
	}
	public static void dynamicVeriable()
	{
		
		driver.get("https://demoqa.com/dynamic-properties");
		WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofMillis(5000));
		
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='enableAfter']")));
		

		ele.click();
		
		
		WebElement ele2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"visibleAfter\"]")));

//		js.executeAsyncScript("arguments[0].scrollIntoView();", ele2);
		
		System.out.print("The text of button is " + ele2.isEnabled());
		
		
		
	}
	
	public static void newWindow() throws InterruptedException
	{
	
		driver.get("https://demoqa.com/browser-windows");
//		WebElement ele = driver.findElement(By.xpath("//button[@id=\"tabButton\"]"));
		
//		
		WebElement ele = driver.findElement(By.xpath("//button[@id=\"windowButton\"]"));

		ele.click();
		Thread.sleep(2000);
		
		Set<String> windows = driver.getWindowHandles();
        
    	System.out.println("Window ID is " + driver.getWindowHandle());

        for (String g: windows)
        {
        	
        	
        	if(driver.getWindowHandle()!= g)
        	{
        	
        	driver.switchTo().window(g);
        	
        		
        	}
        	
        	System.out.println("Window ID is " + g);
        	
        }
       
       WebElement ele2 = driver.findElement(By.xpath("//h1[@id=\"sampleHeading\"]"));
		
	   System.out.print("The text on the other window is " + ele2.getText());

		
	}
	public static void alerts() throws InterruptedException
	{
		
	
	driver.get("https://demoqa.com/alerts");
//	driver.findElement(By.xpath("//*[@id=\"alertButton\"]")).click();	
//	driver.switchTo().alert().accept();
//	WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofMillis(5000));
//	driver.findElement(By.xpath("//button[@id=\"timerAlertButton\"]")).click();
//	WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofMillis(5000)); 
//	wait.until(ExpectedConditions.alertIsPresent());
//	driver.switchTo().alert().accept();
		
	WebElement elew = driver.findElement(By.xpath("//*[@id=\"alertButton\"]"));
	js.executeScript("arguments[0].scrollIntoView();", elew);

	
	Thread.sleep(1000);
	WebElement ele =	driver.findElement(By.xpath("//button[@id='promtButton']"));

	Actions act = new Actions(driver);
	act.click(ele).build().perform();
	Thread.sleep(1000);

	driver.switchTo().alert().sendKeys("manish kumar");
	driver.switchTo().alert().accept();
				
	}
		
	

}
