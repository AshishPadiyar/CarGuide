package pagelocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mysql.cj.jdbc.Driver;

import utilities.DriverUtils;

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

	@FindBy(xpath = "//*[@class='home-block home-block-pr']/ul/li")
	List<WebElement> select;

	@FindBy(xpath = "//*[@class='home-block home-block-pr']/child::h2")
	public WebElement scroll;


	@FindBy(xpath = "//*[@class='home-block home-block-pr']/ul/li")
	public List<WebElement>  elecarName;

	@FindBy(xpath = "//*[@class='title-container']/child::h1")
	public WebElement carTitle;


	@FindBy(css ="input[id='cgsearch']")
	public WebElement elesearchTextBox;

	@FindBy(css =".uhf-footer-nav>ul>li")
	public List<WebElement> eleFooters;

	@FindBy(xpath = "//*[contains(@class,'popular-articles hidden')]/following-sibling::div/child::div/div/parent::div/parent::div/preceding-sibling::div/child::div/following-sibling::a")
	public WebElement popularArticle;

	@FindBy(xpath = "//*[contains(@class,'popular-articles hidden')]/following-sibling::div/child::div/div")
	public List<WebElement> listpopularArticle;

	@FindBy(css =".bg-container>div>div>h1")
	public WebElement eleArticleText;



}
