package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.HomePageLogout;
import pages.LoginPage;
import utilities.ExelUtilities;

public class AdminUsersTest extends Base {
	
	public AdminUsersPage adminuserpage;    //globally declare
	public HomePageLogout homepagelogout;

	@Test(priority=1,description="input_AdminUserDetails")
	public void inputAdminUserDetails() throws IOException {
//
//		String username=Excel_utilities.getStringdata(1,0,"loginpage");
//		String password=Excel_utilities.getStringdata(1,1,"loginpage");
		
		String username="admin";
		String password="admin";
		
		
//		Faker_utilities fakerutilities=new Faker_utilities();           //usig FAKER  for random inputs
//		String adminusername=fakerutilities.creatARandomFirstName();
//		String adminpassword=fakerutilities.creatARandomLastName();
	
		// login
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		homepagelogout=loginpage.clickSignIn();
//		loginobject.enterPassword(password);
//		loginobject.clickSignIn();
		boolean isloaded=loginpage.isHomePageLoaded();
		Assert.assertTrue(isloaded,"Not able to login");
		
		//AdminUsers_page adminUserInput = new AdminUsers_page(driver);

	//	adminUserInput.moreinfo_AdminUser();
		adminuserpage=homepagelogout.moreinfoAdminUser();
		adminuserpage.newUser().InputAdminUserName(username).InputAdminUserPassword(password).userDetailsDropdown().saveUserDetails();
//		adminuserpage.InputAdminUserName(admin_username);
//		adminuserpage.InputAdminUserPassword(admin_password);
//		adminuserpage.userDetailsDropdown();
//		adminuserpage.saveUserDetails();
		boolean verifyalertmsg=adminuserpage.isUserInputAlertBoxLoaded();
		Assert.assertTrue(verifyalertmsg,"Alert msg not displayed");

	}

	@Test(priority = 2)
	public void delete_AdminUserDetails() throws IOException {
		
		String username=ExelUtilities.getStringdata(1,0,"loginpage");
		String password=ExelUtilities.getStringdata(1,1,"loginpage");
		
	
		
		// login
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password).clickSignIn();
		homepagelogout=loginpage.clickSignIn();// fix this   // verify alert
		adminuserpage=homepagelogout.moreinfoAdminUser();                                         
		adminuserpage.deleteAdminUserInformation();
		boolean checkAlertMsg=adminuserpage.isUserDeleteAlertBoxLoaded();
		Assert.assertTrue(checkAlertMsg,"delete success msg not found");

	}

}