package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {

    public static void waitForTitle(WebDriver driver, String title) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.titleContains(title));
    }
}
