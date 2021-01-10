package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarsGuideHomePageLocators {
	
	
	@FindBy(css="[data-gtm-label='top nav car buy and sell']")
	public WebElement BuyandSell;
	
	@FindBy(css="[data-gtm-label='top nav car reviews']")
	public WebElement Reviews;
	
	@FindBy(css="[data-gtm-label='top nav car news']")
	public WebElement News;
	
	@FindBy(css="[data-gtm-label='top nav car advice']")
	public WebElement Advice;
	
	@FindBy(css="[data-gtm-label='top nav pricing and specs']")
	public WebElement PricingAndSpecs;
	
	@FindBy(css="[data-gtm-label='sub nav search cars']")
	public WebElement SearchCarsSubMenu;
	
	@FindBy(css="[data-gtm-label='sub nav used cars search']")
	public WebElement SearchUsedCarsSubMenu;
	
	@FindBy(id = "makes")
	public WebElement DropDwnAnyMake;
			
	@FindBy(id = "models")
	public WebElement DropDwnModel;
	
	@FindBy(id = "search-submit")
	public WebElement ShowMeCars;
	
	@FindBy(xpath = "//*[@id='u_H-white']/div/div[2]/div[1]/ul/li[3]/a/span[1]")
	public  WebElement SignIn;
	
	@FindBy(xpath = "//*[@class='uhf-menu-wrapper']/div/ul/li")
	public  WebElement homePageTabs;
	

}
