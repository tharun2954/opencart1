package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	//url http://localhost/opencart/upload/index.php
	
	//Elements
	@FindBy(xpath="//a[@title='My Account']") WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement lnkLogin;
	
	//Actions
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickRegiset() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
}
