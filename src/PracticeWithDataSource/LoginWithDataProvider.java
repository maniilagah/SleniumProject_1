package PracticeWithDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginWithDataProvider {

	
		WebDriver driver;
		Properties prop;
		
		@BeforeSuite
		public void readProperties() throws IOException
		{
		try {
			
			
			System.out.println("Im in bewfoewkgbsdfvbsdfv sd.va");
		InputStream input = new FileInputStream("src/config.properties");
	  prop = new Properties();
		
		prop.load(input);
		
		}
		catch(FileNotFoundException e)
		{
			System.out.print(e.getLocalizedMessage());
			e.printStackTrace();
			
		}
			
		
		}
		
		
		@BeforeTest
		public void setPth()
		{
		System.out.println(prop.getProperty("driverPath"));
		System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));  

		}
		
		
		
		
		@BeforeClass
		public void beforeClass()
		{
		System.out.println("This is before Class");
		
		}
		
		@BeforeMethod
		@Parameters({"url"})
		public void beforeMethod(String dynamicURL)
		
		{
			//Call thsi method setUP
			
			System.out.print("This is before method");
			 driver = new ChromeDriver();
			driver.navigate().to(dynamicURL);

			driver.manage().window().maximize();
			System.out.println("This is before method");
		
		}
		
		@Test(dataProvider = "loginData")
		
		public void loginPage(String userName, String password) throws InterruptedException, IOException
//		public void loginPage() throws InterruptedException, IOException
		{	
		System.out.println("This is original test 1");
		
		// validate button
		Thread.sleep(4000);
		
		WebElement txtFieldUserName = driver.findElement(By.xpath("//*[@name='username']"));
		txtFieldUserName.sendKeys(userName);
		WebElement txtFieldPassword  = driver.findElement(By.xpath("//*[@name='password']"));
		
		txtFieldPassword.sendKeys(password);
		WebElement loginButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		
		Thread.sleep(2000);
		loginButton.click();
		
		}
		
		@DataProvider(name = "loginData")
		public Object[][] myTestData() throws IOException
		{
			
			FileInputStream stream1 = new FileInputStream(new File("C:\\Users\\Owner\\Desktop\\assignment\\Test1.xlsx"));
			//XSSFWorkbook workBook1 = new XSSFWorkbook(stream1);
			XSSFWorkbook book1 = new XSSFWorkbook(stream1);
			XSSFSheet sheet1 =  book1.getSheetAt(0);
			int rows = sheet1.getLastRowNum();
			
			int column = (sheet1.getRow(0)).getLastCellNum();
			Object[][] data = new Object[rows][column];
			System.out.println("number of rows and column is " + rows + "  " + column);
			for(int i = 1;i<=rows;i++)
			{
				
				
				for (int j = 0;j<=column-1;j++)
				{
					System.out.println("value of i and j  " + i + "  " + j);
					var rowData = sheet1.getRow(i).getCell(j);
					System.out.println("and value are   " +  rowData);
					data[i-1][j] = String.valueOf(rowData);	
				}	
			}
			return data;
			
		}
		@AfterMethod
		public void afterMethod()
		{
			
			// Tear Down
		System.out.println("This is after method");
		driver.quit();
		
		}
		
		@AfterClass
		public void afterClass()
		{
		System.out.println("This is after Class");
		
		}
		
		
		@AfterTest
		public void afterTest()
		{
		System.out.println("This is after Test");
		
		}
		
		
	}


