package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class SubCatagory {
	
	public WebDriver driver;
	
	public SubCatagory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[4]")private WebElement moreinfoSubCatagory ;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newButton ;
	@FindBy(xpath="//select[@id='cat_id']")private WebElement catagoryDropdown;
	@FindBy(xpath="//input[@id='subcategory']")private WebElement subCategoryField ;
	@FindBy(xpath="//input[@id='main_img']")private WebElement uploadImageButton;
	@FindBy(xpath="//button[@type='submit']")private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alerMsg;
	
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[1]")private WebElement deleteButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement deleteAlertMsg;
	
	public void clickMoreInfo()
	{
		moreinfoSubCatagory.click();
	}
	
	public void clickNewButton() 
	{
		newButton.click();
	}
	public void selectCategory()
	{
		PageUtilities pageutilities=new PageUtilities();
		pageutilities.selectByIndex(catagoryDropdown,3);
	}
	
	public void inputSubCategory_field(String datainput)
	{
		subCategoryField.sendKeys(datainput);
	}
	public void uploadImage()
	{
		uploadImageButton.sendKeys("C:\\Users\\Arun\\Downloads\\mango.jpg");
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
	public boolean verifyAlertMsg()
	{
		return alerMsg.isDisplayed();
		
	}
	
	public void deleteSubCategory()
	{
		deleteButton.click();
		driver.switchTo().alert().accept();
	}
	public boolean verifyDeleteAlertMsg()
	{
		return deleteAlertMsg.isDisplayed();
	}

}