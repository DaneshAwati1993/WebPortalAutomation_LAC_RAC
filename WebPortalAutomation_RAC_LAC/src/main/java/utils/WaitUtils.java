package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	private WebDriver driver;
    public WebDriverWait wait;

    public WaitUtils(WebDriver driver, long timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public static void waitForTitle(WebDriver driver, String title) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.titleContains(title));
    }
    
    /* ------------------ Element Waits ------------------ */

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /* ------------------ Frame / Alert ------------------ */

    public void waitForFrameAndSwitch(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    /* ------------------ Page / JS ------------------ */

    public void waitForPageLoad() {
        wait.until(driver ->
            ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete")
        );
    }

    public void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    


}
