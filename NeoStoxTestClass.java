package pom.neostox;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NeoStoxTestClass {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		File myfile = new File("C:\\Users\\vinit\\OneDrive\\Desktop\\Book1.xlsx");
		Sheet Mysheet = WorkbookFactory.create(myfile).getSheet("Sheet3");
		String mobileNo = Mysheet.getRow(0).getCell(0).getStringCellValue();
		String password = Mysheet.getRow(0).getCell(1).getStringCellValue();
		String expUserName = Mysheet.getRow(0).getCell(2).getStringCellValue();
		
		System.out.println("from sheet:" + expUserName);
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://neostox.com/");
		driver.manage().window().maximize();
		
		HomePage homePageObj = new HomePage(driver);
		homePageObj.clickOnSignIn();
		
		
		SignInPage sip = new SignInPage(driver);
		sip.enterMobileNo(mobileNo);
		sip.clickOnSubmitButton();
		
		
		PasswordPage passwordPageObj = new PasswordPage(driver);
		passwordPageObj.enterPassword(password);
		passwordPageObj.clickOnSubmitBtn();
		
		
		Thread.sleep(40000); // wait to open two popups
		DashBoardPage dashBoardPageObj = new DashBoardPage(driver);
		dashBoardPageObj.clickOkOnSecondPopUp(driver);
		Thread.sleep(10000);
		dashBoardPageObj.clickOkOnFirstPopUp();
		Thread.sleep(10000);
		dashBoardPageObj.validateUserName(expUserName);
		dashBoardPageObj.clickOnMenuOption();
		Thread.sleep(10000);
		dashBoardPageObj.clickOnLogoutBtn();
		
		driver.quit();
		
	}
}
