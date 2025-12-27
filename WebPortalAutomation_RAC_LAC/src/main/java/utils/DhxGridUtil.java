package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DhxGridUtil {

    private WebDriverWait wait;
    private JavascriptExecutor js;

    public DhxGridUtil(WebDriver driver, Duration timeout) {
        this.wait = new WebDriverWait(driver, timeout);
        this.js = (JavascriptExecutor) driver;
    }

    /**
     * Clicks a dhxGrid row by visible cell text and validates selection.
     */
    public void clickRowByCellText(
            By loader,
            String cellText,
            ExpectedCondition<?> postClickCondition
    ) {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

        By rowLocator = By.xpath(
            "//tr[td[normalize-space()='" + cellText + "']]"
        );

        WebElement row = wait.until(
            ExpectedConditions.visibilityOfElementLocated(rowLocator)
        );

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});", row
        );

        js.executeScript("arguments[0].click();", row);

        // ✅ REAL validation
        wait.until(postClickCondition);

        System.out.println("✅ dhxGrid click processed: " + cellText);
    }

}

