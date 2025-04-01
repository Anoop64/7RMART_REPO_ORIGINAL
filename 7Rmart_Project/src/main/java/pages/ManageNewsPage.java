package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver; //globally 
	
	public ManageNewsPage(WebDriver driver) // constructor
	{
		this.driver=driver;
	    PageFactory.initElements(driver,this); 
		
	}

	@FindBy(xpath="//p[text()='Manage News']//parent::a")private WebElement manageNewsbox;
	@FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[9]")private WebElement moreinfobutton;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newClickButton;
	@FindBy(xpath="//textarea[@id='news']")private WebElement newsInputField;
	@FindBy(xpath="//button[@type='submit']")private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertBox;
	
	
	

	
	public void moreInfo()
	{
		moreinfobutton.click();
	}
	public void newClick()
	{
		newClickButton.click();	
	}
	public void enterNews(String news)
	{
		newsInputField.sendKeys(news);
		
	}
	public void saveNews()
	{
		saveButton.click();
	}
	public boolean isSuccessAlertMessageLoaded()
	{
		return alertBox.isDisplayed();
		
	}
	
	
	
	
	

}