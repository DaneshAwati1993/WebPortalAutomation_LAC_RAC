package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BasePage;

public class FiscalReasonMaster extends BasePage {
	
	   // loader used in your application
 By loader = By.cssSelector("div.loader-section");

	public FiscalReasonMaster(WebDriver driver) {
		super(driver);

	}
	
	@FindBy (xpath="(//input[@value='--Select--'])[1]") WebElement MasterDD;
	
	
	@FindBy (xpath="//span[normalize-space()='Product Master']") WebElement ProductMaster;
	@FindBy (xpath="//span[normalize-space()='Discount Master']") WebElement DiscountMaster;
	@FindBy (xpath="//span[normalize-space()='Retailer Attribute']") WebElement AretattrMaster;
	@FindBy (xpath="//span[normalize-space()='Retailer Master']") WebElement RetailerMaster;
	
	@FindBy (xpath="(//input[@value='--Select--'])[2]") WebElement DataTypedd;
	
	@FindBy (xpath="//span[normalize-space()='TipoTransaccion']") WebElement TipoTransaccion;
	@FindBy (xpath="//span[normalize-space()='TipoDesc']") WebElement TipoDesc;
	@FindBy (xpath="//span[normalize-space()='TipoPago']") WebElement TipoPago;
	@FindBy (xpath="//span[normalize-space()='Institucion']") WebElement Institucion;
	@FindBy (xpath="//span[normalize-space()='Tipo Doc Exo']") WebElement TipoDocExo;

	@FindBy (xpath="//input[@id='Description']") WebElement EnterDescription;
	@FindBy (xpath="//input[@id='ReasonCode']") WebElement EnterReasonCode;
	
	@FindBy (xpath="//button[@id='btnReasonSave']") WebElement SaveReason;
	@FindBy (xpath="//button[@id='btnReasonCancel']") WebElement CancelReason;
	
	@FindBy (xpath="//p[normalize-space()='Saved Successfully']") WebElement SuccessMessage;
	@FindBy (xpath="//p[normalize-space()='Code already exists for this data type']") WebElement ErrorMessage;
	
	
	//Select Fiscal Reason Master : 
	public void selectMasterByName(String masterName) {
	    MasterDD.click();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement option = driver.findElement(
	        By.xpath("//span[normalize-space()='" + masterName + "']"));

	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", option);
	    wait.until(ExpectedConditions.elementToBeClickable(option));
	    option.click();
	}

		
//	public void selectProductMaster()
//	{
//		MasterDD.click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	// scroll to element
//    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", ProductMaster);
//    	// wait until element is clickable
//    	wait.until(ExpectedConditions.elementToBeClickable(ProductMaster));
//    	wait.until(ExpectedConditions.visibilityOfAllElements(ProductMaster));
//    	ProductMaster.click();
//	}
//	
//	public void selectDiscountMaster()
//	{
//		MasterDD.click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	// scroll to element
//    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", DiscountMaster);
//    	// wait until element is clickable
//    	wait.until(ExpectedConditions.elementToBeClickable(DiscountMaster));
//    	wait.until(ExpectedConditions.visibilityOfAllElements(DiscountMaster));
//    	DiscountMaster.click();
//	}
//	
//	public void selectAretattrMaster()
//	{
//		MasterDD.click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	// scroll to element
//    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", AretattrMaster);
//    	// wait until element is clickable
//    	wait.until(ExpectedConditions.elementToBeClickable(AretattrMaster));
//    	wait.until(ExpectedConditions.visibilityOfAllElements(AretattrMaster));
//    	AretattrMaster.click();
//	}
//	
//	public void selectRetailerMaster()
//	{
//		MasterDD.click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	// scroll to element
//    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", RetailerMaster);
//    	// wait until element is clickable
//    	wait.until(ExpectedConditions.elementToBeClickable(RetailerMaster));
//    	wait.until(ExpectedConditions.visibilityOfAllElements(RetailerMaster));
//    	RetailerMaster.click();
//	}
//	
	//Select Data type as per the Fiscal Reason selected
	public void selectDataTypeByName(String dataType) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector(".loader-section")));

	    DataTypedd.click();

	    WebElement option = driver.findElement(
	        By.xpath("//span[normalize-space()='" + dataType + "']"));

	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", option);
	    wait.until(ExpectedConditions.elementToBeClickable(option));
	    option.click();
	}	
	
	
//	public void selectTipoTransaccion()
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//	    // wait for loader INSIDE iframe
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
//	            By.cssSelector(".loader-section")));
//	    
//		DataTypedd.click();
//    	// scroll to element
//    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", TipoTransaccion);
//    	// wait until element is clickable
//    	wait.until(ExpectedConditions.elementToBeClickable(TipoTransaccion));
//    	wait.until(ExpectedConditions.visibilityOfAllElements(TipoTransaccion));
//    	TipoTransaccion.click();
//	}
//	
//	public void selectTipoDesc()
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//	    // wait for loader INSIDE iframe
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
//	            By.cssSelector(".loader-section")));
//	    
//		DataTypedd.click();
//    	// scroll to element
//    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", TipoDesc);
//    	// wait until element is clickable
//    	wait.until(ExpectedConditions.elementToBeClickable(TipoDesc));
//    	wait.until(ExpectedConditions.visibilityOfAllElements(TipoDesc));
//    	TipoDesc.click();
//	}
//	
//	public void selectTipoPago()
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//	    // wait for loader INSIDE iframe
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
//	            By.cssSelector(".loader-section")));
//	    
//		DataTypedd.click();
//    	// scroll to element
//    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", TipoPago);
//    	// wait until element is clickable
//    	wait.until(ExpectedConditions.elementToBeClickable(TipoPago));
//    	wait.until(ExpectedConditions.visibilityOfAllElements(TipoPago));
//    	TipoPago.click();
//	}
//	
//	public void selectInstitucion()
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//	    // wait for loader INSIDE iframe
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
//	            By.cssSelector(".loader-section")));
//	    
//		DataTypedd.click();
//    	// scroll to element
//    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", Institucion);
//    	// wait until element is clickable
//    	wait.until(ExpectedConditions.elementToBeClickable(Institucion));
//    	wait.until(ExpectedConditions.visibilityOfAllElements(Institucion));
//    	Institucion.click();
//	}
//	
//	public void selectTipoDocExo()
//	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//	    // wait for loader INSIDE iframe
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
//	            By.cssSelector(".loader-section")));
//	    
//		DataTypedd.click();
//    	// scroll to element
//    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", TipoDocExo);
//    	// wait until element is clickable
//    	wait.until(ExpectedConditions.elementToBeClickable(TipoDocExo));
//    	wait.until(ExpectedConditions.visibilityOfAllElements(TipoDocExo));
//    	TipoDocExo.click();
//	}
	
	//Enter the Reason Code
	public void EnterReasonCode(String ReasonCode) throws InterruptedException {
		
		EnterReasonCode.sendKeys(ReasonCode);
	
	}
	//Enter the Description
	public void EnterDescription(String Description) throws InterruptedException {
		
		EnterDescription.sendKeys(Description);
	
	}
	
	public void clickSaveReason() {
		SaveReason.click();
    }

    public void clickCancelReason() {
    	CancelReason.click();
    }
    
    public boolean isSuccessMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='card-alert']/div/p/i[@class='fa fa-check']")));
        	wait.until(ExpectedConditions.visibilityOfAllElements(SuccessMessage));
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='card-alert']/button")));
            return SuccessMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='card-alert']/div/p/i[@class='fa fa-check']")));
        	wait.until(ExpectedConditions.visibilityOfAllElements(ErrorMessage));
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='card-alert']/button")));
            return ErrorMessage.isDisplayed();
            
        } catch (Exception e) {
            return false;
        }
    }

    public String getSuccessMessageText() {
        return SuccessMessage.getText();
    }

    public String getErrorMessageText() {
        return ErrorMessage.getText();
    }
    
    public void returnToGrid() {
        switchToIFrame();
    }

	
}
