package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooter {
	
	public WebDriver driver;
	
	public ManageFooter(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="(//a[text()='More info '])[10]")private WebElement footermoreinfo;
	@FindBy(xpath="(//i[@class='fas fa-edit'])[1]")private WebElement actionButton;
	@FindBy(xpath="//textarea[@id='content']")private WebElement addressInputField;
	@FindBy(xpath="//input[@id='email']")private WebElement emailInputField;
	@FindBy(xpath="//input[@id='phone']")private WebElement phoneInputField;
	@FindBy(xpath="//button[@name='Update']")private WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertMsg;
	
	public void clickMoreinfo_footer()
	{
		footermoreinfo.click();
	}
	public void clickAction_footer()
	{
		actionButton.click();
	}
	public void enterAddress(String address)
	{
		addressInputField.clear();
		addressInputField.sendKeys(address);
	}
	public void enterEmail(String email)
	{
		emailInputField.clear();
		emailInputField.sendKeys(email);
	}
	public void enterPhone(String phone)
	{
		phoneInputField.clear();
		phoneInputField.sendKeys(phone);
	}
	public void clickUpdate()
	{
		updateButton.click();
		
	}
	
	public boolean verifyAlert()
	{
		return alertMsg.isDisplayed();
		
	}

}