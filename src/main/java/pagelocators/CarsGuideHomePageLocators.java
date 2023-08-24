package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarsGuideHomePageLocators {


    @FindBy(css = "[data-gtm-label='top nav car buy and sell']")
    public WebElement BuyandSell;

    @FindBy(css = "[data-gtm-label='top nav car reviews']")
    public WebElement Reviews;

    @FindBy(css = "[data-gtm-label='top nav car news']")
    public WebElement News;

    @FindBy(css = "[data-gtm-label='top nav car advice']")
    public WebElement Advice;

    @FindBy(css = "[data-gtm-label='top nav pricing and specs']")
    public WebElement PricingAndSpecs;

    @FindBy(css = "[data-gtm-label='sub nav search cars']")
    public WebElement SearchCarsSubMenu;

    @FindBy(css = "[data-gtm-label='sub nav used cars search']")
    public WebElement SearchUsedCarsSubMenu;

    @FindBy(id = "makes")
    public WebElement DropDwnAnyMake;

    @FindBy(id = "models")
    public WebElement DropDwnModel;

    @FindBy(id = "search-submit")
    public WebElement ShowMeCars;

    @FindBy(xpath = "//*[@id='u_H-white']/div/div[2]/div[1]/ul/li[3]/a/span[1]")
    public WebElement SignIn;

    @FindBy(xpath = "//*[@class='uhf-menu-wrapper']/div/ul/li")
    public WebElement homePageTabs;
    @FindBy(xpath = "//*[@class='home-block home-block-pr']/child::h2")
    public WebElement scroll;
    @FindBy(xpath = "//*[@class='home-block home-block-pr']/ul/li")
    public List<WebElement> elecarName;
    @FindBy(xpath = "//*[@class='title-container']/child::h1")
    public WebElement carTitle;
    @FindBy(css = "input[id='cgsearch']")
    public WebElement elesearchTextBox;
    @FindBy(css = ".uhf-footer-nav>ul>li")
    public List<WebElement> eleFooters;
    @FindBy(xpath = "//*[contains(@class,'popular-articles hidden')]/following-sibling::div/child::div/div/parent::div/parent::div/preceding-sibling::div/child::div/following-sibling::a")
    public WebElement popularArticle;
    @FindBy(xpath = "//*[contains(@class,'col-sm-12 group-main-3')]/child::div/following-sibling::div/h2")
    public WebElement buyingGuides;
    @FindBy(xpath = "//*[contains(@class,'home-shared-block')]/div/a")
    public List<WebElement> buyingGuidesItem;
    @FindBy(css = ".title-container>h1")
    public WebElement eleBuyingGuidePageText;
    @FindBy(xpath = "//*[contains(@class,'topmodels-rows')]/div[contains(@id,'expert')]")
    public List<WebElement> bestCarAsPerExperts;
    @FindBy(xpath = "//*[contains(@class,'popular-articles hidden')]/following-sibling::div/child::div/div")
    public List<WebElement> listpopularArticle;
    @FindBy(css = ".bg-container>div>div>h1")
    public WebElement eleArticleText;
    @FindBy(css = "input[name='make']")
    public WebElement eleMake;
    @FindBy(xpath = "//*[@id='uhf-make-search']/child::ul/child::li")
    public List<WebElement> eleMakeList;
    @FindBy(xpath = "//*[@class='uhf-model-results uhf-opaque']/child::ul/child::li")
    public List<WebElement> eleModelList;
    @FindBy(xpath = "//*[@class='home-block home-block-pr']/ul/li")
    List<WebElement> select;
}
