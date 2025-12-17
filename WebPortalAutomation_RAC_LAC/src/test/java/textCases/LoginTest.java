package textCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTest {

	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://bimbo-cr-qa.ivycpg.com/web/DMS");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test
	public void VerifyLogin()
	{
		LoginPage LP=new LoginPage(driver);
		LP.setusername("L1_user");
		LP.setpassword("1");
		LP.clickLoginbtn();
		
		String title=LP.Title();
		
		Assert.assertEquals(title, "IVYDMS");
		
		
	}

}
