package pageactions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import freemarker.core.Configurable;
import pagelocators.CarsGuideHomePageLocators;
import utilities.ConfigUtils;
import utilities.DriverUtils;


public class CarsGuideHomePageActions {
	
	CarsGuideHomePageLocators carsGuideHomePageLocators =null;
	
	public CarsGuideHomePageActions(){
		
		this.carsGuideHomePageLocators=new CarsGuideHomePageLocators();
		PageFactory.initElements(DriverUtils.driver, carsGuideHomePageLocators);
		
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

}
