package pom.neostox;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	//web elements
	@FindBy (xpath = "//span[@class='righttopmenu1']") private WebElement menuOption;
	@FindBy (xpath = "//a[@id='lnk_logout']") private WebElement logout;
	@FindBy (xpath = "(//a[@class=\"btn btn-sm neobutton\"])[7]") private WebElement secondPopUp;
	@FindBy (xpath = "//a[@class=\"btn btn-success\"]") private WebElement firstPopUp;
	@FindBy (xpath = "//span[@id='lbl_username']") private WebElement userName;
	
	
	
	//constructor
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//methods
	public void clickOkOnSecondPopUp(WebDriver driver) throws IOException {
		File Temp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		File Desirdlc = new File("C:\\Users\\vinit\\OneDrive\\Pictures\\Screenshots\\popup_imag2.jpg");
		FileHandler.copy(Temp, Desirdlc);
		secondPopUp.click();
	}
	
	public void clickOkOnFirstPopUp() {
		firstPopUp.click();
	}
	
	public void validateUserName(String uName) {
		String actualUserName = userName.getText();
		System.out.println("from website:" + actualUserName);
		if(uName.equals(actualUserName)) {
			System.out.println("MATCH FOUND TEST CASE PASSED");
		}else {
			System.out.println("NO MATCH TEST CASE FAILED");
		}
	}
	
	public void clickOnMenuOption() {
		menuOption.click();
	}
	
	public void clickOnLogoutBtn() {
		logout.click();
	}
}
