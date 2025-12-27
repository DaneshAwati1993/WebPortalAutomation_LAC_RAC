package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
	protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    //----------------Objects----------
    @FindBy(xpath = "//a[normalize-space()='Add']")
    WebElement addBtn;

    @FindBy(xpath = "//a[normalize-space()='Edit']")
    WebElement editBtn;

    @FindBy(xpath = "//a[normalize-space()='Delete']")
    WebElement deleteBtn;

    @FindBy(xpath = "//button[@onclick='javascript: fnSave();']")
    WebElement saveBtn;

    @FindBy(xpath = "//button[@onclick='javascript: fnClose();']")
    WebElement cancelBtn;
    
    
    //------Object Handling Methods
    
    public void clickAddBtn() {
        addBtn.click();
    }

    public void clickEditBtn() {
        editBtn.click();
    }

    public void clickDeleteBtn() {
        deleteBtn.click();
    }

    public void clickSaveBtn() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    	By loader = By.cssSelector("div.loader-section.section-right");

    	wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    	saveBtn.click();
	}

    public void clickCancelBtn() {
        cancelBtn.click();
    }
    
    //---Frame Handling
    
    public void switchToIFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.id("iContent")));
    }

    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }
}
