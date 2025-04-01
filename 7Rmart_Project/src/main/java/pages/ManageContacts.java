package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContacts {
	
	public WebDriver driver;  // globally
	
	public ManageContacts(WebDriver driver) //constructor
	{
		this.driver=driver;
		PageFactory.initElements( driver,this); //webelements initialize cheyan
		
		
	}
	
	@FindBy(xpath="(//a[text()='More info '])[5]")private WebElement moreInfo;
	@FindBy(xpath="//a[@role='button']")private WebElement actionbutton;
	
	@FindBy(xpath="//input[@id='phone']")private WebElement phonefield;
	@FindBy(xpath="//input[@id='email']")private WebElement emailfield ;
	@FindBy(xpath="(//textarea[@id='content'])[1]")private WebElement addressfield ;
	@FindBy(xpath="(//textarea[@id='content'])[2]")private WebElement deliveryTimefield;
	@FindBy(xpath="//input[@id='del_limit']")private WebElement deliveryChargefield;
	@FindBy(xpath="//button[@name='Update']")private WebElement updatebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertbutton;
	
	
	
	
	
	
	public void loginButton()
	{
		moreInfo.click();
		actionbutton.click();
	}
	
	public void enterPhoneNumber(String phone)
	{
		phonefield.clear();
		phonefield.sendKeys(phone);
		
	}
	

	public void enterEmail(String email)
	{
	emailfield.clear();
	emailfield.sendKeys(email);
	}
		
	public void enteraddress(String address)
	{
	addressfield.clear();
	addressfield.sendKeys(address);
		
	}
	public void enterDeliveryTime(String deliveryTime)
	{
	deliveryTimefield.clear();
	deliveryTimefield.sendKeys(deliveryTime);
	}
	public void enterDeliveryCharge(String deliveryCharge)
	{
	deliveryChargefield.sendKeys(deliveryCharge);
	updatebutton.click();
	}	
	public void pressUpdate()
	{
		updatebutton.click();
	}
	
	public boolean isAlertLoaded()
	{
		return alertbutton.isDisplayed();
	}
	
	


}