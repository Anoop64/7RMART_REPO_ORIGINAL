package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCatagory;
import utilities.ExelUtilities;

public class ManageCatagoryTest extends Base {
	@Test(priority=1)
	public void enterCategoryInformation() throws IOException
	{
		String username=ExelUtilities.getStringdata(1,0,"loginpage");
		String password=ExelUtilities.getStringdata(1,1,"loginpage");
		String category="drink";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean isloaded = loginpage.isHomePageLoaded();
		Assert.assertTrue(isloaded, "login page not loaded");
		
		ManageCatagory managecatagory = new ManageCatagory(driver);
		managecatagory.clickMoreInfoManageCategory();
		managecatagory.clickNewButton();
		managecatagory.inputCatagoryField(category);
		managecatagory.clickDiscount();
		managecatagory.uploadFile();
		
		
//		managecategorypage.clickRadioButtonTopMenu();
//		managecategorypage.clickRadioButtonLeftMenu();
		managecatagory.clickSaveButton();
		boolean checkAlertMSg = managecatagory.verifyAlert();
		Assert.assertTrue(checkAlertMSg,"error loading alert msg" );
		
		
		
		
	}
	@Test(priority=2)
	public void categoryInformation() throws IOException
	{
		String username=ExelUtilities.getStringdata(1,0,"loginpage");
		String password=ExelUtilities.getStringdata(1,1,"loginpage");
		String searchCategory="drink";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean isloaded = loginpage.isHomePageLoaded();
		Assert.assertTrue(isloaded, "login page not loaded");
		
		ManageCatagory managecatagory = new ManageCatagory(driver);
		managecatagory.clickMoreInfoManageCategory();
		managecatagory.clickSearchButton();
		managecatagory.inputCategoryfield(searchCategory);
		managecatagory.clickSubmitSearch();
		managecatagory.clickDeleteButton();
		managecatagory.checkAlertMsg();
		
		
		
	}

}