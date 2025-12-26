package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class RouteMaster extends BasePage {

	public RouteMaster(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="(//input[@value='-Select-'])[1]") WebElement NSMdd;
	
	@FindBy (xpath="(//input[@value='-Select-'])[2]") WebElement SDdd;
	
	@FindBy (xpath="(//input[@value='-Select-'])[3]") WebElement RSMdd;
	
	@FindBy (xpath="(//input[@value='-Select-'])[4]") WebElement SMdd;
	
	@FindBy (xpath="(//input[@value='-Select-'])[5]") WebElement DMdd;
	
	@FindBy (xpath="(//input[@value='-Select-'])[6]") WebElement SCdd;
	
	@FindBy (xpath="//span[normalize-space()='DANESH_NSM']") WebElement NSMdata;
	
	@FindBy (xpath="//span[normalize-space()='DANESH_SD']") WebElement SDdata;
	
	@FindBy (xpath="//span[normalize-space()='DANESH_RSM']") WebElement RSMdata;
	
	@FindBy (xpath="//span[normalize-space()='DANESH_SM']") WebElement SMdata;
	
	@FindBy (xpath="//span[normalize-space()='DANESH_DM']") WebElement DMdata;
	
	@FindBy (xpath="//span[normalize-space()='901976']") WebElement SCdata;
	
	@FindBy (xpath="//td[@title='9761']") WebElement RTSelect;
	
	public void SelectNSM()
	{
		NSMdd.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	// scroll to element
    	((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView({block:'center'});", NSMdata);
    	// wait until element is clickable
    	wait.until(ExpectedConditions.elementToBeClickable(NSMdata));
    	wait.until(ExpectedConditions.visibilityOfAllElements(NSMdata));
		NSMdata.click();
		System.out.println("Selected NSM is : "+NSMdata.getText());
	}
	
	public void SelectSD()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // wait for loader INSIDE iframe
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector(".loader-section")));
		SDdd.click();

    	// scroll to element
    	((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView({block:'center'});", SDdata);
    	// wait until element is clickable
    	wait.until(ExpectedConditions.elementToBeClickable(SDdata));
    	wait.until(ExpectedConditions.visibilityOfAllElements(SDdata));
		SDdata.click();
		System.out.println("Selected SD is : "+SDdata.getText());
	}
	
	public void SelectRSM()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // wait for loader INSIDE iframe
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector(".loader-section")));
		RSMdd.click();

    	// scroll to element
    	((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView({block:'center'});", RSMdata);
    	// wait until element is clickable
    	wait.until(ExpectedConditions.elementToBeClickable(RSMdata));
    	wait.until(ExpectedConditions.visibilityOfAllElements(RSMdata));
    	RSMdata.click();
		System.out.println("Selected RSM is : "+RSMdata.getText());
	}
	public void SelectSM()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // wait for loader INSIDE iframe
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector(".loader-section")));
		SMdd.click();

    	// scroll to element
    	((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView({block:'center'});", SMdata);
    	// wait until element is clickable
    	wait.until(ExpectedConditions.elementToBeClickable(SMdata));
    	wait.until(ExpectedConditions.visibilityOfAllElements(SMdata));
    	SMdata.click();
		System.out.println("Selected SM is : "+SMdata.getText());
		
	}
	public void SelectDM()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // wait for loader INSIDE iframe
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector(".loader-section")));
		DMdd.click();

    	// scroll to element
    	((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView({block:'center'});", DMdata);
    	// wait until element is clickable
    	wait.until(ExpectedConditions.elementToBeClickable(DMdata));
    	wait.until(ExpectedConditions.visibilityOfAllElements(DMdata));
    	DMdata.click();
		System.out.println("Selected DM is : "+DMdata.getText());
	}
	public void SelectSC()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // wait for loader INSIDE iframe
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector(".loader-section")));
		SCdd.click();

    	// scroll to element
    	((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView({block:'center'});", SCdata);
    	// wait until element is clickable
    	wait.until(ExpectedConditions.elementToBeClickable(SCdata));
    	wait.until(ExpectedConditions.visibilityOfAllElements(SCdata));
    	SCdata.click();
		System.out.println("Selected SC is : "+SCdata.getText());
	}
	
	public void SelectRoute()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//
//    	// scroll to element
//    	((JavascriptExecutor) driver)
//    	        .executeScript("arguments[0].scrollIntoView({block:'center'});", RTSelect);
//    	// wait until element is clickable
//    	wait.until(ExpectedConditions.elementToBeClickable(RTSelect));
//    	wait.until(ExpectedConditions.visibilityOfAllElements(RTSelect));
    	RTSelect.click();
	}
	

}
