package abc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.Given;

public class newabc {

	WebDriver neww;
	//afrfasf/asadfas/dfasdf//sdfasdf
	//sadfasfdsdf/sfd
	WebDriver driver;


	@Given("^User is already on login page$")
	public void user_is_already_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\Downloads\\chromedriver_win32\\chromedriver.exe");  
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/");
	    throw new PendingException();
	}
	
	@When("title of login page is Free CRM")
	public void title_of_login_page_is_Free_CRM()
	{
		String title = driver.getTitle();
		Assert.assertEquals("Free CRM Software for every business", title);
		
		
	}
	
	@Then("User enters UsernamePassword")
	public void user_enters_Username_Password() {
		
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("");
		
		
		
	   
	}
	@Then("User clicks on Login Button")
	public void user_clicks_on_Login_Button() {
		driver.findElement(By.xpath("//div[@class=\"ui fluid large blue submit button\"]")).click();

	}

//	@Then("^User is on Home Page$")
//	public void user_is_on_Home_Page() {
//	    
//	}
	
}
