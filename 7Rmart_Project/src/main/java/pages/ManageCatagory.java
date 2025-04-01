package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCatagory {
	
	public WebDriver driver;
	
	public ManageCatagory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[11]")private WebElement moreinfoManageCategory;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
	@FindBy(xpath="//input[@class='form-control']")private WebElement inputCatagoryfield;
	@FindBy(xpath="(//span[text()='discount'])[1]")private WebElement discountbutton;
	@FindBy(xpath="//input[@id='main_img']")private WebElement choosefile;
//	@FindBy(xpath="(//input[@type='radio'])[2]")private WebElement showOnTopMenubutton;
//	@FindBy(xpath="(//input[@type='radio'])[4]")private WebElement showOnLeftMenubutton;
	@FindBy(xpath="//button[text()='Save']")private WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertmsg;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")private WebElement searchbutton;
	@FindBy(xpath="//input[@class='form-control']")private WebElement categorySearchfield;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")private WebElement submitSearchbutton;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")private WebElement deletebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alertMsg;
	
	
	
	
	public void clickMoreInfoManageCategory()
	{
		moreinfoManageCategory.click();
	}
	
	public void clickNewButton() 
	{
		newbutton.click();
	}
	public void inputCatagoryField(String category) 
	{
		inputCatagoryfield.sendKeys(category);
	}
	
	public void clickDiscount()
	{
		discountbutton.click();
	}
	
	public void uploadFile()
	{
		choosefile.sendKeys("C:\\Users\\Arun\\Downloads\\mogu-guava.jpg");
		
	}
//	
//	public void clickRadioButtonTopMenu()
//	{
//		showOnTopMenu_button.click();
//	}
//	public void clickRadioButtonLeftMenu()
//	{
//		showOnLeftMenu_button.click();
//	}
	
	
	public void clickSaveButton()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",savebutton );
		js.executeScript("arguments[0].click();", "");

		
		savebutton.click();
	}
	public boolean verifyAlert()
	{
		return alertmsg.isDisplayed();
	}
	
	public void clickSearchButton()
	{
		searchbutton.click();
	}
	public void inputCategoryfield(String searchCategory)
	{
		categorySearchfield.sendKeys(searchCategory);
	}
	public void clickSubmitSearch()
	{
		submitSearchbutton.click();
	}

	public void clickDeleteButton()
	{
		deletebutton.click();
		driver.switchTo().alert().accept();
	}
	
	public boolean checkAlertMsg() 
	{
		return alertMsg.isDisplayed();
		
	}
}
