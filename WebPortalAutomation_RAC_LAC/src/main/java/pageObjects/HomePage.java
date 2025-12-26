package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Masters']")
    WebElement masterMenu;

    @FindBy(xpath = "//a[@title='Sales Center Hierarchy']")
    WebElement scHierarchy;
    
    @FindBy(xpath = "//a[@title='Route Management']")
    WebElement Route_Management;
    
    @FindBy(xpath = "//a[@title='Route Master']")
    WebElement RTMaster;
    
    
    public void clickMasterMenu() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	// scroll to element
    	((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView({block:'center'});", masterMenu);
    	
    	// wait until element is clickable
    	wait.until(ExpectedConditions.elementToBeClickable(masterMenu));

    	// click
        masterMenu.click();
    }
    
    public void clickSCHierarchy() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	// scroll to element
    	((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView({block:'center'});", scHierarchy);
    	
    	// wait until element is clickable
    	wait.until(ExpectedConditions.elementToBeClickable(scHierarchy));

    	// click
        scHierarchy.click();
    
    }

    public void ClickRouteManagement() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	// scroll to element
    	((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView({block:'center'});", Route_Management);
    	
    	// wait until element is clickable
    	wait.until(ExpectedConditions.elementToBeClickable(Route_Management));

    	// click
    	Route_Management.click();
        
    }
    
    public void ClickRTMaster() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	// scroll to element
    	((JavascriptExecutor) driver)
    	        .executeScript("arguments[0].scrollIntoView({block:'center'});", RTMaster);
    	
    	// wait until element is clickable
    	wait.until(ExpectedConditions.elementToBeClickable(RTMaster));

    	// click
    	RTMaster.click();
        
    }
}
