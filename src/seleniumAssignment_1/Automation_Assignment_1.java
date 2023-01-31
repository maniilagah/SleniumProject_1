package seleniumAssignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation_Assignment_1 {
	
	static WebDriver driver;
	static JavascriptExecutor js;

	public static void main(String[] args) throws InterruptedException {
		
 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");  

		  driver = new ChromeDriver();
		   js = (JavascriptExecutor) driver;
//		  openThisWebsite("https://demoqa.com/automation-practice-form");
		   
		  openThisWebsite("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		 
		driver.manage().window().maximize();
//		Thread.sleep(1000);
//		automateName_textField();
//		Thread.sleep(1000);
//		automateEmail_textField();
//		  
//		  Thread.sleep(1000);
//		automateGender_buttons();
//		
//		Thread.sleep(1000);
//		automateMobile_textField();
//		
//		Thread.sleep(1000);
//		automateDOB_textField();
//		
//		Thread.sleep(1000);
//		automateSubjects_textField();
//		
//		Thread.sleep(1000);
//		automateHobbies_checkBoxes();
//		
//		Thread.sleep(1000);
//		automateChoosePicture_Button();
//		
//		Thread.sleep(1000);
//		automateAddress_textField();
//		
//		Thread.sleep(1000);
//		automate_SelectCityDropDown();
//		
		
//        driver.quit();
		
		abcTest();
		

	}
	
	
	public static void openThisWebsite(String address)
	{
		
	driver.get(address);
        
	}
	public static void abcTest() throws InterruptedException
	{
		 WebElement element = driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/div/input"));
		 js.executeScript("arguments[0].scrollIntoView();", element);
		 Thread.sleep(2000);
		 try {
		 element.click();
		 }
		 catch(Exception e)
		 {
		 System.out.print("error is " + e.getLocalizedMessage());
			 
		 }
		 System.out.print(element.isSelected() + " new i ashvasd asdhb alsdc");
	}
	
	public static void automateName_textField()
	{
//		 element = new WebElement();
		 WebElement element = driver.findElement(By.id("firstName"));
		 WebElement element2 = driver.findElement(By.id("lastName"));
		 element.sendKeys("Manish");
		 element2.sendKeys("Kumar");
		
	}
	public static void automateEmail_textField()
	{
		var element = driver.findElement(By.id("userEmail"));
		
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.sendKeys("maniilagah@gmail.com");
	}
	
	public static void automateGender_buttons()
	{
		
		var a = driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]"));   //For male
//		var a = driver.findElement(By.xpath("//label[@for=\"gender-radio-2\"]"));    // For Female
//		var a = driver.findElement(By.xpath("//label[@for=\"gender-radio-3\"]"));	// For others
		a.click();
		
		
//		System.out.println("im here 1");
//		WebElement b = driver.findElement(By.id("gender-radio-3"));							
//		System.out.println("im here 2 ");
//		for (int i=1; i<2; i++) {
//			
//        	System.out.println("im here " + b.getTagName() );
////            chkFBPersist.click (); 			
//            System.out.println("Facebook Persists Checkbox Status is -  "+b.isSelected());							
//        }		
		//driver.close();		
        			
	}
	public static void automateMobile_textField()
	{
		driver.findElement(By.id("userNumber")).sendKeys("4379746709");	
	}
	public static void automateDOB_textField()
	{
		WebElement date = driver.findElement(By.id("dateOfBirthInput"));
		
	}
	public static void automateSubjects_textField()
	{
		
	driver.findElement(By.id("subjectsInput")).sendKeys("Math,Secience and English");

		
	}
	public static void automateHobbies_checkBoxes()
	{
		
		driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1' and @class='custom-control-label']")).click();
		driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2' and @class='custom-control-label']")).click();
		driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3' and @class='custom-control-label']")).click();
//		var a = driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]"));   //For male
//		var a = driver.findElement(By.xpath("//label[@for=\"gender-radio-2\"]"));    // For Female
//		var a = driver.findElement(By.xpath("//label[@for=\"gender-radio-3\"]"));	// For others
		
		
	}
	public  static void automateChoosePicture_Button()
	{
		driver.findElement(By.id("uploadPicture")).click();
		
	}
	public  static void automateAddress_textField()
	{
		//textarea[@placeholder='Current Address' and @id='currentAddress']
		
		
		 var element = driver.findElement(By.xpath("//textarea[@placeholder='Current Address' and @id='currentAddress']"));
		 js.executeScript("arguments[0].scrollIntoView();", element);
		 element.sendKeys("116 dorcot ave, Scarborough, ON");
		
		
	}
	
	public static void automate_SelectCityDropDown()
	{
		
		
		var element = driver.findElement(By.id("react-select-3-input"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
		
	}
	

}
