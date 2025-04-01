package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooter;
import utilities.ExelUtilities;

public class ManageFooterTest extends Base {

	@Test(description="manageFooterText")
	public void manageFooterText() throws IOException 
	{
	
		String username=ExelUtilities.getStringdata(1,0,"loginpage");
		String password=ExelUtilities.getStringdata(1,1,"loginpage");
		String address=ExelUtilities.getStringdata(1,0,"managefooter");
		String email=ExelUtilities.getStringdata(1,1,"managefooter");
		String phone=ExelUtilities.getIntegerdata(1,2,"managefooter");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		loginpage.isHomePageLoaded();
		
		
		ManageFooter managefooter = new ManageFooter(driver);
		managefooter.clickMoreinfo_footer();
		managefooter.clickAction_footer();
		managefooter.enterAddress(address);
		managefooter.enterEmail(email);
		managefooter.enterPhone(phone);
		managefooter.clickUpdate();
		managefooter.verifyAlert();
		
	
	}

}