package textCases.Elsalvador;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RouteMaster;
import utils.WaitUtils;

public class BIBI_5014 extends BaseTest {
	
	@Test(priority=1)
    public void verifyLogin() {

        LoginPage lp = new LoginPage(driver);
        lp.login("L1_user","1");

        WaitUtils.waitForTitle(driver, "IvyDMS");
        Assert.assertEquals(driver.getTitle(), "IvyDMS",
                "Login failed – Title mismatch");
        
    }

	@Test(priority = 2, dependsOnMethods = "verifyLogin")
	public void VerifyRtMasterMenu() {

	    HomePage hp = new HomePage(driver);

	    hp.clickMasterMenu();
	    hp.ClickRouteManagement();
	    hp.ClickRTMaster();

	}
	
	@Test(priority = 2, dependsOnMethods = "VerifyRtMasterMenu")
	public void VerifyTheRTFiscalCode() throws InterruptedException {

		RouteMaster RT = new RouteMaster(driver);
		RT.switchToIFrame();
	    RT.SelectNSM();
	    RT.SelectSD();
	    RT.SelectRSM();
	    RT.SelectSM();
	    RT.SelectDM();
	    RT.SelectSC();
	    RT.selectRoute();
	    Thread.sleep(300);
	    RT.clickEditBtn();

	    
	}

}
