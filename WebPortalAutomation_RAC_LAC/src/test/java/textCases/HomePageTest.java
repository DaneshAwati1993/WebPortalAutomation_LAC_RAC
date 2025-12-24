package textCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @Test(priority = 2, dependsOnMethods = "verifyLogin")
    public void verifyHomePage() {
        homePage = new HomePage(driver);
        homePage.clickMasterMenu();
        homePage.clickSCHierarchy();
        Assert.assertTrue(driver.getTitle().contains("Sales Center"));
    }
}
