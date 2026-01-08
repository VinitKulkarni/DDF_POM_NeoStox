package pom.neostox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
	//web elements
	@FindBy (xpath = "//input[@id='accessPinModel_accsspin']") private WebElement password;
	@FindBy (xpath = "//button[@id='frmsubmit']") private WebElement submitBtn;
	
	//constructor
	public PasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public void enterPassword(String passW) {
		password.sendKeys(passW);
	}
	
	public void clickOnSubmitBtn() {
		submitBtn.click();
	}
}
