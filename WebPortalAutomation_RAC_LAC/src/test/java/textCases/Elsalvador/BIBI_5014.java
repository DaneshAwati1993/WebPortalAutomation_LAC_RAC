package textCases.Elsalvador;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RouteMaster;
import utils.DBUtils;
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
		
		String RT_Fiscal = "34679";
		
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
	    RT.SelectRTFiscalseq(RT_Fiscal);
	    RT.clickSaveBtn();
	    
	 // DB Validation
	    String query =
	            "select AR_Fiscal_Sequence from ADM_Route where ar_id=1646";

	    String dbValue =
	            DBUtils.waitForDBValue(query, RT_Fiscal, 10);

	    Assert.assertNotNull(dbValue, "❌ Record not found in DB");
	    Assert.assertEquals(dbValue, RT_Fiscal, "❌ UI vs DB mismatch");
	    
	 // ✅ PASS print statement
	    System.out.println("✅ DB Validation Passed | Expected: "
	            + RT_Fiscal + " | Actual: " + dbValue);
	    
	}
	
	
//	@Test(priority = 2, dependsOnMethods = "VerifyRtMasterMenu")
//	public void VerifyTheRTFiscalCode() throws InterruptedException {
//
//		RouteMaster RT = new RouteMaster(driver);
//		RT.switchToIFrame();
//	    RT.SelectNSM();
//	    RT.SelectSD();
//	    RT.SelectRSM();
//	    RT.SelectSM();
//	    RT.SelectDM();
//	    RT.SelectSC();
//	    RT.clickAddBtn();
//	    RT.EnterRTCode("9774");
//	    RT.EnterRTName("9774 Name");
//	    RT.EnterRTAliyasName("9774 RT Name");
//	    RT.SelectCostCenter();
//	    RT.SelectRtType();
//	    RT.SelectRTSellType();
//	    RT.SelectRTSup();
//	    RT.SelectRTFiscalseq("12345");
//	    
//	}



}
