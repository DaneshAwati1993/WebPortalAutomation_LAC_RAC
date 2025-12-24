package utils;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertUtils {

    private static WebDriverWait wait;

    private static Alert waitForAlert(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void acceptAlert(WebDriver driver) {
        waitForAlert(driver).accept();
    }

    public static void dismissAlert(WebDriver driver) {
        waitForAlert(driver).dismiss();
    }

    public static String getAlertText(WebDriver driver) {
        return waitForAlert(driver).getText();
    }

    public static void sendTextToAlert(WebDriver driver, String text) {
        Alert alert = waitForAlert(driver);
        alert.sendKeys(text);
        alert.accept();
    }

    public static boolean isAlertPresent(WebDriver driver) {
        try {
            waitForAlert(driver);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
