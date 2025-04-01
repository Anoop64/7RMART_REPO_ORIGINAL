package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.HomePageLogout;
import utilities.ExelUtilities;

public class HomePageLogoutTest extends Base {
	@Test(groups={"Regression"},description="logout")
	public void logout() throws IOException
	{

		String username=ExelUtilities.getStringdata(1,0,"loginpage");
		String password=ExelUtilities.getStringdata(1,1,"loginpage");
		


		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		loginpage.isHomePageLoaded();
		
		HomePageLogout homepagelogout = new HomePageLogout(driver);
		homepagelogout.adminButtonPress();
		homepagelogout.logoutButtonPress();
		boolean verifylogout = homepagelogout.verifyLogout();
		Assert.assertTrue(verifylogout, "not displayed");
		
		
	}

}