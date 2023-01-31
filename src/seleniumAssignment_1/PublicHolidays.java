package seleniumAssignment_1;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PublicHolidays {

	static WebDriver driver;

	static JavascriptExecutor js;
	public static void main(String args[]) throws ParseException 
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");  
 
		 driver = new ChromeDriver();
		 js = (JavascriptExecutor) driver;
		driver.get("https://www.officeholidays.com/countries/usa/2022");
		  
		driver.manage().window().maximize();
		// Methods calls are commented
		
//		assignment1_printTables();
		
//		assignment2_FederalHolidayOnly();
//		assignment3_TodayIsFederalHoliday();
		
//		assignment3_HowManyFederalHolidayLeft();
	
		
	}
	
public static void assignment1_printTables()
	
	{
		WebElement tables = driver.findElement(By.className("country-table"));
		js.executeScript("arguments[0].scrollIntoView();", tables);
		WebElement table = driver.findElement(By.xpath("//table[@class='country-table']"));
		List<WebElement> tabless = table.findElements(By.xpath("./child::*"));
				int count = 1 ;
		for(WebElement element:tabless)
		{	
			System.out.println(element.getTagName() + count);
			count++;
			
			if ("tbody".equals(element.getTagName()))
			{
				
				List<WebElement> row_col = element.findElements(By.xpath("./child::*"));
				
				for(WebElement ele:row_col)
				{
			
					if ("tr".equals(ele.getTagName()))
					{
						List<WebElement> tableColumns = ele.findElements(By.xpath("./child::*"));
		
					for(WebElement column:tableColumns)
					{
			
						if("td".equals(column.getTagName()))
						{				
							System.out.print(column.getText() + "                 ");

						}
					}
					System.out.println();
					}
				}
		}
		}
	}	


public static void assignment2_FederalHolidayOnly()

{
	WebElement tables = driver.findElement(By.className("country-table"));
	js.executeScript("arguments[0].scrollIntoView();", tables);
	WebElement table = driver.findElement(By.xpath("//table[@class='country-table']"));
	List<WebElement> tabless = table.findElements(By.xpath("./child::*"));
			
	for(WebElement element:tabless)
	{	
		
		
		
		if ("tbody".equals(element.getTagName()))
		{
			
			
			List<WebElement> row_col = element.findElements(By.xpath("./child::*"));
			int rowNumber = 1;
			for(WebElement ele:row_col)
			{
				int columNumber = 1;
				
				if ("tr".equals(ele.getTagName()))
				{
					List<WebElement> tableColumns = ele.findElements(By.xpath("./child::*"));
	
				for(WebElement column:tableColumns)
				{
		
					if("td".equals(column.getTagName())  && columNumber == 4 && "Federal Holiday".equals(column.getText()))
					{			
						
						String leftXPath = "//table[@class='country-table']/tbody/tr[";
						String row = String.valueOf(rowNumber);
						String lastXpath = "]/td[2]";
						
						String finalXpath = leftXPath + row + lastXpath;
						WebElement DateColumn = element.findElement(By.xpath(finalXpath));
						System.out.println("The date with Federal Holiday is " + DateColumn.getText() + "                 ");

					}
					
					columNumber++;
					
				}
//				System.out.println();
				}
				rowNumber++;
			}
	}
	}
}	


public static void assignment3_TodayIsFederalHoliday() throws ParseException

{
	 
	SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");  
	Date todayDate= new Date();
	
	WebElement tables = driver.findElement(By.className("country-table"));
	js.executeScript("arguments[0].scrollIntoView();", tables);
	WebElement table = driver.findElement(By.xpath("//table[@class='country-table']"));
	List<WebElement> tabless = table.findElements(By.xpath("./child::*"));
	
	for(WebElement element:tabless)
	{	
		
		if ("tbody".equals(element.getTagName()))
		{
			
			
			List<WebElement> row_col = element.findElements(By.xpath("./child::*"));
			int rowNumber = 1;
			for(WebElement ele:row_col)
			{
				int columNumber = 1;
				boolean flag = false;
				
				if ("tr".equals(ele.getTagName()))
				{
					List<WebElement> tableColumns = ele.findElements(By.xpath("./child::*"));
	
				for(WebElement column:tableColumns)
				{
		
					if("td".equals(column.getTagName())  && columNumber == 2)
					{
					
						String leftXPath = "//table[@class='country-table']/tbody/tr[";
						String row = String.valueOf(rowNumber);
						String lastXpath = "]/td[2]";
						
						String finalXpath = leftXPath + row + lastXpath;
						WebElement DateColumn = element.findElement(By.xpath(finalXpath));
						System.out.println("The row number is " + rowNumber );
						
						
						
						 String sDate1= String.valueOf(DateColumn.getText()) + "/2022" ;
						 
						 
						 String finalDate = sDate1.replace(" ", "/");
						 
						 String todaysFinalDate = formatter.format(todayDate);
//						 Date date1 =new SimpleDateFormat("MMM/dd/yyyy").parse(finalDate); 
						    
						  
						    if (finalDate.equals(todaysFinalDate))
						    {
//						    	System.out.println("Date matched and col number is  is " + columNumber);
						    	System.out.println("We have today's date in the chart ");
						    	flag = true;
						    }	
						    
						    else
						    {
//						    	System.out.println("col number before break is  is " + columNumber);
						    	break;
						    }
					}
						    
					
						    
					
					  if(columNumber == 4 && flag == true)
					    {
						  if("Federal Holiday".equals(column.getText()))
						  {
						  System.out.println("And today's date " + (formatter.format(todayDate))  + " is Federal Holiday");
						  }
						  else
						  {
							 
						System.out.println("But today's date " + (formatter.format(todayDate))  + " is not Federal Holiday");  
							  
						  }
					    	
					    }
					  
//					  System.out.println("col number is  is " + columNumber);
						columNumber++;

					}
					
				
					flag = false;
					rowNumber++;
					
				}
//				System.out.println();
				}
				
			}
	}
	}

public static void assignment3_HowManyFederalHolidayLeft() throws ParseException

{
	 
	SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");  
	Date todayDate = new Date();
	Date date1 = new Date();
	int dateCounter = 0;
	WebElement tables = driver.findElement(By.className("country-table"));
	js.executeScript("arguments[0].scrollIntoView();", tables);
	WebElement table = driver.findElement(By.xpath("//table[@class='country-table']"));
	List<WebElement> tabless = table.findElements(By.xpath("./child::*"));
	
	for(WebElement element:tabless)
	{	
		
		if ("tbody".equals(element.getTagName()))
		{
			
			
			List<WebElement> row_col = element.findElements(By.xpath("./child::*"));
			int rowNumber = 1;
			for(WebElement ele:row_col)
			{
				int columNumber = 1;
				
				boolean flag = false;
				
				if ("tr".equals(ele.getTagName()))
				{
					List<WebElement> tableColumns = ele.findElements(By.xpath("./child::*"));
	
				for(WebElement column:tableColumns)
				{
		
					if("td".equals(column.getTagName())  && columNumber == 2)
					{
					
						String leftXPath = "//table[@class='country-table']/tbody/tr[";
						String row = String.valueOf(rowNumber);
						String lastXpath = "]/td[2]";
						
						String finalXpath = leftXPath + row + lastXpath;
						WebElement DateColumn = element.findElement(By.xpath(finalXpath));
//						System.out.println("The date is " + DateColumn.getText() + "                 ");
						
						
						
						 String sDate1= String.valueOf(DateColumn.getText()) + "/2022" ;
						 
						 String finalDate = sDate1.replace(" ", "/");
						    date1=new SimpleDateFormat("MMM/dd/yyyy").parse(finalDate); 
						    
//						    System.out.println(formatter.format(date1));
//						    System.out.println(sDate1);  
						    
						    if (todayDate.compareTo(date1) < 0 || finalDate.equals(String.valueOf(formatter.format(todayDate))))
						    {
						    	
						    	
						    	flag = true;
						    	dateCounter++;
						    }
						    else
						    {
						    	columNumber++;
						    	break;
						    	
						    }
					}
					
					 if(columNumber == 4 && "Federal Holiday".equals(column.getText()) && flag == true)
					    {
						 System.out.println("Date for the next Federal holiday is " + formatter.format(date1) );
					    flag = false;
					    break;
					    	
					    }
					 
					columNumber++;
					
					
					
				}
//				
				}
				rowNumber++;
			}
	}
		
		
	}
	
	System.out.println("Number of federal holidays left this year are " + dateCounter);
	
	



}	
}






