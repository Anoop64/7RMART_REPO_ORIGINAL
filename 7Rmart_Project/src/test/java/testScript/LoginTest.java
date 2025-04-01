package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExelUtilities;

public class LoginTest extends Base {
	@Test(groups= {"Regression"},description="verifyLoginWithValidCredentials")
	public void verifyLoginWithValidCredentials() throws Exception
	{
		String username=ExelUtilities.getStringdata(1,0,"loginpage");
		String password=ExelUtilities.getStringdata(1,1,"loginpage");
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		loginpage.isHomePageLoaded();
		boolean isloaded = loginpage.isHomePageLoaded();
		Assert.assertTrue(isloaded, "home page not login with correct credentials");
		
		
		
	}
	@Test(description="verifyInvalidePasswordEntry")
	public void verifyInvalidePasswordEntry() throws IOException
	{
		String username=ExelUtilities.getStringdata(2,0,"loginpage");
		String password=ExelUtilities.getStringdata(2,1,"loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean checkAlert = loginpage.checkAlertMsg();
		Assert.assertTrue(checkAlert,"Green Alert not displayed ");
		
		
		
	}
	@Test(description="verifyInvalideUserNameEntry")
	public void verifyInvalideUserNameEntry() throws IOException
	{
		String username=ExelUtilities.getStringdata(3,0,"loginpage");
		String password=ExelUtilities.getStringdata(3,1,"loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean checkAlert = loginpage.checkAlertMsg();
		Assert.assertTrue(checkAlert,"Green Alert not displayed");
		
		
		
	}
	@Test(description="verifyInvalidUsernameAndPassword")
	public void verifyInvalidUsernameAndPassword() throws IOException
	{
		String username=ExelUtilities.getStringdata(4,0,"loginpage");
		String password=ExelUtilities.getStringdata(4,1,"loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean checkAlert = loginpage.checkAlertMsg();
		Assert.assertTrue(checkAlert,"Green alert not displayed");
		
	}

}