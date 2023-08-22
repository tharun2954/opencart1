package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test
	public void test_account_registration() throws InterruptedException {
		logger.info("********** Starting TC_001_AccountRegistrationTest ***********");
		logger.trace("Capturing tracing logs...............");
		logger.debug("Capturing debug logs..............");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicking on myAccount link...");
			hp.clickRegiset();
			logger.info("Clicking on register link....");
			
			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			logger.info("Providing customer details...");
			
			regPage.setFirstname(randomString().toUpperCase());
			regPage.setLastname(randomString().toUpperCase());
			regPage.setEmail(randomAlphaNumeric() + "@gmail.com");
			regPage.setTelephone(randomNumber());
			String pwd = randomString();
			regPage.setPassword(pwd);
			regPage.setConfirmPassword(pwd);
			regPage.setPrivacyPolicy();
			logger.info("clicked on continue");
			regPage.clickContinue();
			
			String cnfmsg = regPage.getConfirmationMsg();
			logger.info("Validation Expected message");
			
			if (cnfmsg.equals("Your Account Has Been Created!")) {
				logger.info("Test Passed");
				Assert.assertTrue(true);
			} else {
				logger.info("Customer registration is not successfull");
				logger.info("Test Failed");
				Assert.fail();
			}
			
		} catch (Exception e) {
			logger.info("Test Failed!!!!!!!");
			Assert.fail();
		}
		
		logger.info("************Finished TC_001_AccountRegistrationTest**************");
	}
	
}
