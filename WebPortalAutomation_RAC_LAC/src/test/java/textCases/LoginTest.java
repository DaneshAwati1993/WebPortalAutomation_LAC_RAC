package textCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.LoginPage;
import utilities.WaitUtils;
public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage lp = new LoginPage(driver);
        lp.login("L1_user","1");

        WaitUtils.waitForTitle(driver, "IvyDMS");
        Assert.assertEquals(driver.getTitle(), "IvyDMS",
                "Login failed – Title mismatch");
    }
}
