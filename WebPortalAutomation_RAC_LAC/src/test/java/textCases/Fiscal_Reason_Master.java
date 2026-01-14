package textCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.FiscalReasonMaster;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.ExcelUtils;
import utils.WaitUtils;

public class Fiscal_Reason_Master extends BaseTest {
	
	@Test(priority=1)
    public void verifyLogin() {

        LoginPage lp = new LoginPage(driver);
        lp.login("L1_user","1");

        WaitUtils.waitForTitle(driver, "IvyDMS");
        Assert.assertEquals(driver.getTitle(), "IvyDMS",
                "Login failed – Title mismatch");
        
    }

	@Test(priority = 2, dependsOnMethods = "verifyLogin")
	public void VerifyFSMMasterMenu() {

	    HomePage hp = new HomePage(driver);

	    hp.clickMasterMenu();
	    hp.ClickFSMMaster();
	    hp.switchToIFrame();

	}
	
	@DataProvider(name = "FiscalReasonData")
	public Object[][] getFiscalReasonData() {
	    return ExcelUtils.getFiscalReasonData(
	        System.getProperty("user.dir") + "/testdata/Fiscal_Reason_Master.xlsx",
	        "Reasons");
	}
	
	@Test(priority = 3, dependsOnMethods = "VerifyFSMMasterMenu", dataProvider = "FiscalReasonData")
		public void verifyAddFiscalReason(
		        String master,
		        String dataType,
		        String reasonCode,
		        String description) throws InterruptedException {

		    FiscalReasonMaster FSM = new FiscalReasonMaster(driver);
		    
		    
		    try {		    	
		    	
		        FSM.clickAddBtn();

		        FSM.selectMasterByName(master);
		        FSM.selectDataTypeByName(dataType);
		        FSM.EnterReasonCode(reasonCode);
		        FSM.EnterDescription(description);
		        FSM.clickSaveReason();

		     if (FSM.isErrorMessageDisplayed()) {

		            System.out.println("❌ FAILED: " + reasonCode);
		            FSM.clickCancelReason();

		        }  else {

		            System.out.println("✅ SUCCESS: " + reasonCode);
		        }

		        

		    } catch (Exception e) {

		        System.out.println("🔥 EXCEPTION for " + reasonCode + " → " + e.getMessage());
		        FSM.clickCancelReason();
		        FSM.returnToGrid();
		    }
		}


}
