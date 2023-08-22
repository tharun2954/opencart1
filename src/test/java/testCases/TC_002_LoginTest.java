package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	@Test
	public void test_login() {
		logger.info("************Starting TC_002_LoginTest*******************");
		logger.trace("Capturing tracing Logs......");
		logger.debug("Capturing Debug Logs..........");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicking on my account link");
			hp.clickLogin();
			logger.info("Clicking on login link");
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(rb.getString("userName"));
			logger.info("Entered user name");
			lp.setPassword(rb.getString("password"));
			logger.info("Entered password");
			lp.clickLogin();
			logger.info("Clicked on login button");
			
			MyAccountPage myacc = new MyAccountPage(driver);
			boolean targetVlaue = myacc.isMyAccountPageExists();
			Assert.assertEquals(targetVlaue, true);
			
			logger.info("Login Success");
			logger.info("Test Passed.......");
		} catch(Exception e) {
			Assert.fail();
			logger.info("Test Fialed");
		}
		
		logger.info("******************Finishing TC_002_LoginTest*************");
	}

}
