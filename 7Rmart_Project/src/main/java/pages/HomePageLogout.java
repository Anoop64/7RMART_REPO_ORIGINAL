package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageLogout {
	
	public WebDriver driver;
	
	public HomePageLogout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	
	@FindBy(xpath="(//a[@class='nav-link'])[2]")private WebElement adminButton;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")private WebElement logoutButton;
	@FindBy(xpath="//p[text()='Sign in to start your session']")private WebElement verifylogout ;
	
	
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")private WebElement moreinfoButton ;
	
	
	public AdminUsersPage moreinfoAdminUser() 
	{
		moreinfoButton.click();
		return new AdminUsersPage(driver);

		
	}
	public void adminButtonPress()
	{
		adminButton.click();
	}
	public void logoutButtonPress()
	{
		logoutButton.click();
	}
	
	public boolean verifyLogout()
	{
		return verifylogout.isDisplayed();
	}

}