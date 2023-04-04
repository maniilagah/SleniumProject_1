package DemoQAPractice;

//import java.sql.Date;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Date;



public class WorldPopulation {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");	 
		 
		 Date time = new Date();
		 
		 time.setSeconds(time.getSeconds() + 10);
		 
		 Boolean flag = true;
		 List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"maincounter-number\"]/span"));		 
		 
		 do
		 {
		 for(WebElement ele : elements)
		 {
			 Date current_Time = new Date();
			 
			 if( current_Time.before(time))
			 {
				 System.out.println("the current time is " + current_Time);
				 System.out.println("the current time is " + time);

			System.out.println(ele.getText());
			 
			 }
			 else
			 {
				 flag = false;
				 System.out.println("I am here ");
			 } 
		 
	}}while(flag);
		 
		 }
}
