package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExelUtilities;


public class ManageNewsTest extends Base{
	@Test(priority=1,description="manageNewsInput")
	public void manageNewsInput() throws Exception
	{   
		

		String username=ExelUtilities.getStringdata(1,0,"loginpage");  //excel read
		String password=ExelUtilities.getStringdata(1,1,"loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		loginpage.isHomePageLoaded();
		
		
		//creating object of other page class
		
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.moreInfo();
		managenewspage.newClick();
		//String news="Diwali sale on Myntra tonight";
		
		String news=ExelUtilities.getStringdata(1,0,"managenews");   //excel read
		managenewspage.enterNews(news);
		managenewspage.saveNews();
	    boolean alertVerification = managenewspage.isSuccessAlertMessageLoaded();
	    Assert.assertTrue(alertVerification,Constants.MANAGENEWSINPUT);
	}
}