package textCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SCHierarchy;
import utils.AlertUtils;
import utils.WaitUtils;

public class BIBI_5004_Testing extends BaseTest {
	
	
	@Test(priority=1)
    public void verifyLogin() {

        LoginPage lp = new LoginPage(driver);
        lp.login("L1_user","1");

        WaitUtils.waitForTitle(driver, "IvyDMS");
        Assert.assertEquals(driver.getTitle(), "IvyDMS",
                "Login failed – Title mismatch");
        
    }

	@Test(priority = 2, dependsOnMethods = "verifyLogin")
	public void verifyActivityField() {

	    HomePage hp = new HomePage(driver);

	    hp.clickMasterMenu();
	    hp.clickSCHierarchy();

	}
	
	@Test(priority = 3, dependsOnMethods = "verifyActivityField")
	public void SCActivityCode() throws InterruptedException {
		
		SCHierarchy sch = new SCHierarchy(driver);
		sch.clickSC();
		sch.EnterSCCode();
		sch.SelectSCCode();
		sch.clickEditBtn();
		sch.setSCActivityCode("123456");
		sch.clickSaveBtn();
		if (AlertUtils.isAlertPresent(driver)) {
		    String msg = AlertUtils.getAlertText(driver);
		    System.out.println("Alert message: " + msg);
		    AlertUtils.acceptAlert(driver);
		}
	}
	
	

}
