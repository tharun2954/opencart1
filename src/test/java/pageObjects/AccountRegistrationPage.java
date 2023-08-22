package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	//url http://localhost/opencart/upload/index.php
	
	//Elements
	@FindBy(xpath="//input[@name='firstname']") WebElement txtFirstname;
	@FindBy(xpath="//input[@name='lastname']") WebElement txtLastname;
	@FindBy(xpath="//input[@name='email']") WebElement txtEmail;
	@FindBy(xpath="//input[@name='telephone']") WebElement txtTelephone;
	@FindBy(xpath="//input[@name='password']") WebElement txtPassword;
	@FindBy(xpath="//input[@name='confirm']") WebElement txtPasswordConfirm;
	@FindBy(xpath="//input[@name='agree']") WebElement chkPolicy;
	@FindBy(xpath="//input[@type='submit']") WebElement btnContinue;
	@FindBy(xpath="//div[@id='content']//h1") WebElement msgConfirmation;
	//Actions
	public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) {
		txtPasswordConfirm.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy() {
		chkPolicy.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	
}
