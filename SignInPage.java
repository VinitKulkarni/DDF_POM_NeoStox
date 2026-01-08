package pom.neostox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	//web elements
	@FindBy (xpath = "//input[@id='txt_mobilenumber']") private WebElement mobileNo;
	@FindBy (xpath = "//button[@id='frmsubmit']") private WebElement submitBtn;
	
	//constructor
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	// methods
	public void enterMobileNo(String mobileNumber) {
		mobileNo.sendKeys(mobileNumber);
	}
	
	public void clickOnSubmitButton() {
		submitBtn.click();
	}
}
