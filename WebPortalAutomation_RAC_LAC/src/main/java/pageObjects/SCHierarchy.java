package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class SCHierarchy extends BasePage {

    public SCHierarchy(WebDriver driver) {
        super(driver);
    }
    

    @FindBy(xpath = "//iframe[@id='iContent']") 
    WebElement SCFrame;
    
    @FindBy(xpath = "//a[@value='DIS']")
    WebElement sc;

    @FindBy(xpath = "//a[@value='SPVR']")
    WebElement supervisor;

    @FindBy(xpath = "//a[@value='DummySeller']")
    WebElement seller;

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

    @FindBy(id="//table//tbody/tr[1]/td[1]//input")
    WebElement SCSearch;
    
    @FindBy(id="//td[@title='901976']")
    WebElement SCSelect;
    
    @FindBy(id = "Flex_8")
    WebElement scActivityCode;
    
    // ---------- Actions ----------

    public void clickSC() {
    	switchToSCFrame();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // wait for loader INSIDE iframe
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".loader-section")
        ));

        wait.until(ExpectedConditions.elementToBeClickable(sc)).click();
    }
    
    public void EnterSCCode() throws InterruptedException {
    	//switchToSCFrame();
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        SCSearch.sendKeys("901976");

    }
    public void SelectSCCode() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

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
        saveBtn.click();
    }

    public void clickCancelBtn() {
        cancelBtn.click();
    }

    public void setSCActivityCode(String code) {
        scActivityCode.clear();
        scActivityCode.sendKeys(code);
    }

    
}
