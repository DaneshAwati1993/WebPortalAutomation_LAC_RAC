package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://bimbo-cr-qa.ivycpg.com/web/DMS");
        
    }
    

    /*
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
    */
}
