package BIBI_5004;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Activity_field {

	public static void main(String[] args) throws InterruptedException {



		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://bimbo-cr-qa.ivycpg.com/web/DMS/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("L1_user");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("1");
		driver.findElement(By.xpath("//button[@id='Login']")).click();
		
		//Click on Masters menu
		WebElement master=driver.findElement(By.xpath("//a[@title='Masters']"));
		try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    // Scroll into view using JavaScript (more reliable than Actions.scrollToElement in some cases)
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", master);
		    // Wait for visibility
		    wait.until(ExpectedConditions.visibilityOf(master));
		    // Wait until clickable
		    wait.until(ExpectedConditions.elementToBeClickable(master));
		    // Click using Actions (or you can use master.click())
		    Actions actions = new Actions(driver);
		    actions.moveToElement(master).click().perform();
		} 
		catch(Exception e)
		{
			System.out.println("Failed to click on Master menu: " + e.getMessage());
	        Assert.fail("PrivateAccessModifier failed due to exception: " + e.getMessage());
		}
		
		//Click on Sales center Hierarchy menu
		WebElement SCH=driver.findElement(By.xpath("//a[@title='Sales Center Hierarchy']"));
		try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		    // Scroll into view using JavaScript (more reliable than Actions.scrollToElement in some cases)
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCH);
		    // Wait for visibility
		    wait.until(ExpectedConditions.visibilityOf(SCH));
		    // Wait until clickable
		    wait.until(ExpectedConditions.elementToBeClickable(SCH));
		    // Click using Actions (or you can use master.click())
		    Actions actions = new Actions(driver);
		    actions.moveToElement(SCH).click().perform();		} 

		catch(Exception e)
		{
			System.out.println("Failed to click on Master menu: " + e.getMessage());
	        Assert.fail("PrivateAccessModifier failed due to exception: " + e.getMessage());
		}
		//Switch to Frame
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iContent']"));
		driver.switchTo().frame(frameElement);		
		//Click on Centro De Ventas
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@value='DIS']")).click();
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement SC_Code = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[4]/div[1]/input[1]")));
		// Scroll into view (optional but helps with ElementNotInteractable)
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", SC_Code);
        // Type the value
        SC_Code.sendKeys("901976");
        
		//Enter Sc Code in centro de ventas column text field
		WebElement Sc_Search=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[4]"));
		try {
		    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		    // Wait for visibility
		    wait1.until(ExpectedConditions.visibilityOf(Sc_Search));
		    // Wait until clickable
		    wait1.until(ExpectedConditions.elementToBeClickable(Sc_Search));
		    // Click using Actions (or you can use master.click())
		    Actions actions = new Actions(driver);
		    actions.moveToElement(Sc_Search).click().perform();

		} 

		catch(Exception e)
		{
			System.out.println("Failed to click on Master menu: " + e.getMessage());
	        Assert.fail("PrivateAccessModifier failed due to exception: " + e.getMessage());
		}
	
	
	
	}

}
