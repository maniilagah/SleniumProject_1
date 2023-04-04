package DemoQAPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonPractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.getCurrentUrl();
		driver.get("https://www.amazon.ca/");	 
		 WebElement ele = driver.findElement(By.xpath("//label[@for=\"twotabsearchtextbox\"]"));


		System.out.print(" The text is " + ele.getAttribute("innerHTML"));

	}

}
