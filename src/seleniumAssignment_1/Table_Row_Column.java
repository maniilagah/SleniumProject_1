package seleniumAssignment_1;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_Row_Column {
	
	
	static WebDriver driver;
	static JavascriptExecutor js;
	public static void main(String args[]) throws InterruptedException
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");  

		 driver = new ChromeDriver();
		 js = (JavascriptExecutor) driver;
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		  
		driver.manage().window().maximize();
		
		//Methods calls are commented
		
		
//		assignment1_printTable();
//		assignment2_SelectCountryWithFrenchLanguage();
		
//		assignment3_SelectCountryWithFrenchEnglishLanguage();
		
	}
	
	
public  void assignment1_printTable()
	
	{
		WebElement tables = driver.findElement(By.id("countries"));
		js.executeScript("arguments[0].scrollIntoView();", tables);
		WebElement table = tables.findElement(By.xpath("./child::*"));
		List<WebElement> table1 = table.findElements(By.xpath("./child::*"));
				
		for(WebElement element:table1)
		{	
		if ("tr".equals(element.getTagName()))
			{
		
		List<WebElement> tableColumns = element.findElements(By.xpath("./child::*"));
		
		for(WebElement column:tableColumns)
		{
			
			if("td".equals(column.getTagName()))
			{				
			System.out.print(column.getText() + "                 ");

			}
		}
//		System.out.println();
		
		}
		}
	}	
		public static void assignment2_SelectCountryWithFrenchLanguage() throws InterruptedException
		
		{
			WebElement tables = driver.findElement(By.id("countries"));
			js.executeScript("arguments[0].scrollIntoView();", tables);
			WebElement table = tables.findElement(By.xpath("./child::*"));
			List<WebElement> table1 = table.findElements(By.xpath("./child::*"));
//			elements1.findElements(By.xpath("./child::*"));
			
			//*[@id="countries"]/tbody/tr[1]/td[1]
			
			int rowNumber = 1;
			for(WebElement element:table1)
			{	
				int columnNumber = 1;
				
			if ("tr".equals(element.getTagName()))
				{
			
			List<WebElement> tableColumns = element.findElements(By.xpath("./child::*"));
			
			for(WebElement column:tableColumns)
			{
				
				//*[@id="countries"]/tbody/tr[2]/td[1]/input
				
				if("td".equals(column.getTagName()))
				{				
					if (columnNumber == 5 && "French".equals(column.getText()) )
					{
						String leftXPath = "//table[@id=\"countries\"]/tbody/tr[";
						String row = String.valueOf(rowNumber);
						String lastXpath = "]/td[1]/input";
						
						String finalXpath = leftXPath + row + lastXpath;
						WebElement checkBox = element.findElement(By.xpath(finalXpath));
						
						assertEquals("","");
						Thread.sleep(1000);
						js.executeScript("arguments[0].scrollIntoView();", column);
						Thread.sleep(1000);
						checkBox.click();
						

					}
					
				}

				columnNumber++;	
			}
			
			rowNumber++;

			}
			}
		
		
		}
		
		
public static void assignment3_SelectCountryWithFrenchEnglishLanguage() throws InterruptedException
		
		{
			WebElement tables = driver.findElement(By.id("countries"));
			js.executeScript("arguments[0].scrollIntoView();", tables);
			WebElement table = tables.findElement(By.xpath("./child::*"));
			List<WebElement> table1 = table.findElements(By.xpath("./child::*"));
//			elements1.findElements(By.xpath("./child::*"));
			
			//*[@id="countries"]/tbody/tr[1]/td[1]
			
			int rowNumber = 1;
			for(WebElement element:table1)
			{	
				int columnNumber = 1;
				
			if ("tr".equals(element.getTagName()))
				{
			
			List<WebElement> tableColumns = element.findElements(By.xpath("./child::*"));
			
			for(WebElement column:tableColumns)
			{
				
				//*[@id="countries"]/tbody/tr[2]/td[1]/input
				
				if("td".equals(column.getTagName()))
				{				
					
					String columnData = String.valueOf(column.getText());
					
//					System.out.println(columnData);
					if (columnNumber == 5 && columnData.contains("French") && columnData.contains("English")  )
					{
						String leftXPath = "//table[@id=\"countries\"]/tbody/tr[";
						String row = String.valueOf(rowNumber);
						String lastXpath = "]/td[1]/input";
						
						String finalXpath = leftXPath + row + lastXpath;
						WebElement checkBox = element.findElement(By.xpath(finalXpath));
						Thread.sleep(1000);
						js.executeScript("arguments[0].scrollIntoView();", column);
						Thread.sleep(1000);
						checkBox.click();
						

					}
					
				}

				columnNumber++;	
			}
			
			rowNumber++;

			}
			}
		
		
		}
	
	
	
	
	}
	


