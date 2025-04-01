package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtilities;


public class AdminUsersPage 
{
	
	public WebDriver driver; //globally
	
	public AdminUsersPage(WebDriver driver)  //constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")private WebElement moreinfo_button ;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newButton;
	@FindBy(xpath="//input[@id='username']")private WebElement adminUsernameField ;
	@FindBy(xpath="//input[@id='password']")private WebElement adminPasswordField;
	@FindBy(xpath="//select[@id='user_type']")private WebElement userTypeDropdownField ;
	@FindBy(xpath="(//button[@class='btn btn-block-sm btn-danger'])[2]")private WebElement saveButton ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement userInputSuccessAlertBox ;
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[1]")private WebElement userDetailsDeleteButton ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement userDeleteSuccessAlertBox ;

	
//	public void moreinfoAdminUser() 
//	{
//		moreinfoButton.click();
//
//		
//	}
	public AdminUsersPage newUser()
	{
		newButton.click();
		return this;
	}
	
	public AdminUsersPage InputAdminUserName(String adminusername)
	{
		adminUsernameField.sendKeys(adminusername);
		return this;
		
		
		
	}
	public AdminUsersPage InputAdminUserPassword(String adminpassword)
	{
		adminPasswordField.sendKeys(adminpassword);
		return this;
	}
	
	public AdminUsersPage userDetailsDropdown()
	{	
		PageUtilities pageutilities=new PageUtilities();
		pageutilities.selectByIndex(userTypeDropdownField, 2);
		return this;
	}
	
	public AdminUsersPage saveUserDetails()
	{  
		
		saveButton.click();
		return this;
	}
	
	public boolean isUserInputAlertBoxLoaded()
	{
		return userInputSuccessAlertBox.isDisplayed();
	}
	
	
	public AdminUsersPage deleteAdminUserInformation()
	{
		userDetailsDeleteButton.click();
		driver.switchTo().alert().accept();
		return this;
	
	}
	public boolean isUserDeleteAlertBoxLoaded()
	{
		return userDeleteSuccessAlertBox.isDisplayed();
	}

}