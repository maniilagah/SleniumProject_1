package NewTestingPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoToRegistrationPage {
	
	
	
	By btnLogin_Signup = By.xpath("//*[text()=\" Signup / Login\"]");

	public void GoToRegistrationPage(WebDriver driver)
	{
		
	driver.findElement(btnLogin_Signup).click();
		
	}
	

}
