package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info("********** Starting TC_003_LoginDataDrivernTest *******");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicking my account link");
			hp.clickLogin();
			logger.info("Clicking login link");
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			logger.info("entered username");
			
			lp.setPassword(pwd);
			logger.info("Entered password");
			
			lp.clickLogin();
			logger.info("Clicking login button");
			
			MyAccountPage myacc = new MyAccountPage(driver);
			boolean targetpage = myacc.isMyAccountPageExists();
			
			if(exp.equals("Valid")) {
				if (targetpage == true) {
					myacc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equals("Invalid")) {
				if(targetpage == true) {
					MyAccountPage myaccpage = new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				} else { 
					Assert.assertTrue(true);
				}
			}
		} catch(Exception e) {
			Assert.fail();
		}
		logger.info("Finished TC_003_LoginDataDriverTest");
	}
}
