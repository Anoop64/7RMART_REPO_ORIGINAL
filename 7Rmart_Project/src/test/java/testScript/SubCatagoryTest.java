package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCatagory;
import utilities.ExelUtilities;

public class SubCatagoryTest extends Base {
	
	@Test(priority=1,description="adding sub category list")
	public void insertSubCategoryList() throws IOException
	{
		String username=ExelUtilities.getStringdata(1,0,"loginpage");
		String password=ExelUtilities.getStringdata(1,1,"loginpage");
		String datainput=ExelUtilities.getStringdata(1,0,"subcategory");
		String pathinput=ExelUtilities.getStringdata(1,1,"subcategory");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean isloaded=loginpage.isHomePageLoaded();
		Assert.assertTrue(isloaded, "login page not loaded");
		
		SubCatagory subcatagory = new SubCatagory(driver);
		subcatagory.clickMoreInfo();
		subcatagory.clickNewButton();
		subcatagory.selectCategory();
		subcatagory.inputSubCategory_field(datainput);
		subcatagory.uploadImage();
		subcatagory.clickSaveButton();
		boolean checkAlert=subcatagory.verifyAlertMsg();
		Assert.assertTrue(checkAlert,"error loading alertmsg");
		
		
		
	}
	
	@Test(priority=2,description="deleting sub category list")
	public void deleteSubCategoryList() throws IOException
	{
		String username=ExelUtilities.getStringdata(1,0,"loginpage");
		String password=ExelUtilities.getStringdata(1,1,"loginpage");
		String datainput=ExelUtilities.getStringdata(1,0,"subcategory");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean isloaded = loginpage.isHomePageLoaded();
		Assert.assertTrue(isloaded, "login page not loaded");
		
		SubCatagory subcatagory = new SubCatagory(driver);
		subcatagory.clickMoreInfo();
		subcatagory.deleteSubCategory();
		boolean checkAlert=subcatagory.verifyDeleteAlertMsg();
		Assert.assertTrue(checkAlert,"Delete success msg note found");
		
	}

}