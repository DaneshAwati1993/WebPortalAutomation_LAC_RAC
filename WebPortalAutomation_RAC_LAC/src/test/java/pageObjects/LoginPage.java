package pageObjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}


	@FindBy(xpath="//input[@id='UserName']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='Login']")
	WebElement Loginbtn;
	
	
	public void setusername(String uname)
	{
		userName.clear();
		userName.sendKeys(uname);
	}
	
	public void setpassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLoginbtn()
	{
		Loginbtn.click();
	}
	
	
	public String Title()
	{
		try
		{
			return(driver.getTitle());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}

}
