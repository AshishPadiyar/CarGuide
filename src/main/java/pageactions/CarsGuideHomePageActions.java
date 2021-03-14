package pageactions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pagelocators.CarsGuideHomePageLocators;
import utilities.ConfigUtils;
import utilities.DriverUtils;


/*So in order to access variables, methods of locator class,we need to create obj of that locator class
 * now using that obj refrence and dot operator we can access variables, methods of locator class
 * 
 * 
 */

public class CarsGuideHomePageActions {
	
	CarsGuideHomePageLocators carsGuideHomePageLocators =null;//creating a instance class variable
	
	public CarsGuideHomePageActions(){
		//this.carsGuideHomePageLocators reference var will assign value to carsGuideHomePageLocators
		
		this.carsGuideHomePageLocators=new CarsGuideHomePageLocators();
		PageFactory.initElements(DriverUtils.driver, carsGuideHomePageLocators);
		//we need to initialise all page factory element, we cannot use this here because we want to initialise ele for locator class
		
		
	}
	
	public void gotoTopMenu() {
		Actions action=new Actions(DriverUtils.driver);
		action.moveToElement(carsGuideHomePageLocators.BuyandSell).perform();
	}
	
	public void clickonSearchCars() {
		carsGuideHomePageLocators.SearchCarsSubMenu.click();
		DriverUtils.writeWordDocument("User at New & Used Car Search - carsguide", true);
	}
	
	public void clickonUsedCars() {
		carsGuideHomePageLocators.SearchUsedCarsSubMenu.click();
	}
	
	public void clickOnShowMeCars() {
		carsGuideHomePageLocators.ShowMeCars.click();	
		ConfigUtils.log.info("User clicks on show me cars");
	}
	
	public String SignIntitle() {
		ConfigUtils.log.info("User is at homepage");
		DriverUtils.writeWordDocument("User at homepage", true);
		return carsGuideHomePageLocators.SignIn.getText();
		
	}
	public ArrayList HomePageTabs() {
		ArrayList tabName = new ArrayList();
		List<WebElement> tabs=DriverUtils.driver.findElements(By.xpath("//*[@class='uhf-menu-wrapper']/div/ul/li"));
		for(int i=1;i<=tabs.size();i++)
		{
		 tabName.add(DriverUtils.driver.findElement(By.xpath("//*[@class='uhf-menu-wrapper']/div/ul/li["+i+"]/a")).getText());
		}
		return tabName;
	}
	public void Scroll()
	{
		DriverUtils.ScrollToElement(carsGuideHomePageLocators.scroll);
	}

	public void GetCarName(String carName)
	{
		//List<WebElement> list=carsGuideHomePageLocators.elecarName;
		//for(int i =0;i<carName.length();i++) {
			DriverUtils.driver.findElement(By.xpath("//*[@class='home-block home-block-pr']/ul/li/a/span/following-sibling::span[contains(text(),'"+carName+"')]")).click();
		//}
	}

	public String GetCarTitle()
	{

		return carsGuideHomePageLocators.carTitle.getText();
	}

	public void CarSearchTextBox(String car)
	{
		carsGuideHomePageLocators.elesearchTextBox.sendKeys("bmw");
		DriverUtils.DynamicWaitXpathCss("#cgsearch-suggestions>li>a[data-suggested='"+car+"']");
		DriverUtils.driver.findElement(By.cssSelector("#cgsearch-suggestions>li>a[data-suggested='"+car+"']")).click();
	}

	public void HomePageFooters()
	{
		List<WebElement> varFooter=carsGuideHomePageLocators.eleFooters;
		for(int i =1;i<=varFooter.size();i++)
		{
			if(!(i==7)) {
				String strFooter = DriverUtils.driver.findElement(By.cssSelector(".uhf-footer-nav>ul>li:nth-child(" + i + ")>a>span:nth-child(2)")).getText();
				System.out.println("links at the button of the page : " + strFooter);
			}else{
				for(int j=1;j<=2;j++)
				{
					String strFooter = DriverUtils.driver.findElement(By.xpath("//*[@class='uhf-footer-upper']//div[@class='uhf-footer-nav']/ul/li["+i+"]/a["+j+"]/span")).getText();
					System.out.println("links at the button of the page : " + strFooter);
				}
			}
		}
	}
	
	

}
