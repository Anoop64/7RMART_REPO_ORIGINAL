package testScript;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContacts;
import utilities.ExelUtilities;


public class ManageContactsTest extends Base 
{   
	
	@Test(description="manageContacts")
	public void manageContact() throws Exception
	{

		
		String username=ExelUtilities.getStringdata(1,0,"loginpage");
		String password= ExelUtilities.getStringdata(1,1,"loginpage");
		String phone=ExelUtilities.getIntegerdata(2,0,"managecontact");
		String email= ExelUtilities.getStringdata(2,1,"managecontact");
		String address= ExelUtilities.getStringdata(2,2,"managecontact");
		String deliveryTime= ExelUtilities.getIntegerdata(2,3,"managecontact");
		String deliveryCharge= ExelUtilities.getIntegerdata(2,4,"managecontact");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		loginpage.isHomePageLoaded();
		
		
		ManageContacts managecontacts = new ManageContacts(driver);
		
		managecontacts.loginButton();
		managecontacts.enterPhoneNumber(phone);
		managecontacts.enterEmail(email);
		managecontacts.enteraddress(address);
		managecontacts.enterDeliveryTime(deliveryTime);
		managecontacts.enterDeliveryCharge(deliveryCharge);
		
	
		boolean verifyAlert = managecontacts.isAlertLoaded();
		Assert.assertTrue(verifyAlert, "error update contacts");
		
	}
	
	

}