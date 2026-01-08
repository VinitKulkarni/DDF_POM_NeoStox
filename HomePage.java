package pom.neostox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Web element
	@FindBy (xpath = "//a[text()='Sign In']") private WebElement signInButton;
	
	//constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//method
	public void clickOnSignIn() {
		signInButton.click();
	}
}
