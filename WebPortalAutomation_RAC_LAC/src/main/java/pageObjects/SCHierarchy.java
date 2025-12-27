package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class SCHierarchy extends BasePage {

    public SCHierarchy(WebDriver driver) {
        super(driver);
    }
    

    @FindBy(xpath = "//iframe[@id='iContent']") 
    WebElement IFrame;
    
    @FindBy(xpath = "//a[@value='DIS']")
    WebElement sc;

    @FindBy(xpath = "//a[@value='SPVR']")
    WebElement supervisor;

    @FindBy(xpath = "//a[@value='DummySeller']")
    WebElement seller;

    @FindBy(xpath="(//input[@type='text'])[1]")
    WebElement SCSearch;
    
    @FindBy(xpath="//td[@title='901976']")
    WebElement SCSelect;
    
    @FindBy(id = "Flex_8")
    WebElement scActivityCode;
    
    @FindBy(id = "Flex_8-error")
    WebElement ActivityCodeError;
    
    // ---------- Actions ----------

    public void clickSC() {
		switchToIFrame();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	    // wait for loader INSIDE iframe
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector(".loader-section")
	    ));
	
	    wait.until(ExpectedConditions.elementToBeClickable(sc)).click();
	}
    
    public void EnterSCCode() throws InterruptedException {
		//switchToIFrame();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	    SCSearch.sendKeys("901976");
	
	}
    public void SelectSCCode() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
		// wait for loader INSIDE iframe
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	            By.cssSelector(".loader-section")
	    ));
	
	    wait.until(ExpectedConditions.elementToBeClickable(SCSelect)).click();
		
	}

    public void clickSupervisor() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // wait for loader INSIDE iframe
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".loader-section")
        ));

        wait.until(ExpectedConditions.elementToBeClickable(supervisor)).click();
    }

    public void clickSeller() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // wait for loader INSIDE iframe
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".loader-section")
        ));

        wait.until(ExpectedConditions.elementToBeClickable(seller)).click();
    }

    public void setSCActivityCode(String code) {
        scActivityCode.clear();
        scActivityCode.sendKeys(code);
    }

	public String ErrorActivityCode() {
		return ActivityCodeError.getText();
	}

}