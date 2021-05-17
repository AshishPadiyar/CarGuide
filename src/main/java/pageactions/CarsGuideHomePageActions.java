package pageactions;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objectrepository.ObjectRepository;
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

public class CarsGuideHomePageActions implements ObjectRepository {

	CarsGuideHomePageLocators carsGuideHomePageLocators = null;//creating a instance class variable

	public CarsGuideHomePageActions() {
		//this.carsGuideHomePageLocators reference var will assign value to carsGuideHomePageLocators

		this.carsGuideHomePageLocators = new CarsGuideHomePageLocators();
		PageFactory.initElements(DriverUtils.driver, carsGuideHomePageLocators);
		//we need to initialise all page factory element, we cannot use this here because we want to initialise ele for locator class


	}

	public void gotoTopMenu() {
		Actions action = new Actions(DriverUtils.driver);
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
		List<WebElement> tabs = DriverUtils.driver.findElements(By.xpath("//*[@class='uhf-menu-wrapper']/div/ul/li"));
		for (int i = 1; i <= tabs.size(); i++) {
			tabName.add(DriverUtils.driver.findElement(By.xpath("//*[@class='uhf-menu-wrapper']/div/ul/li[" + i + "]/a")).getText());
		}
		return tabName;
	}

	public void Scroll() {
		DriverUtils.ScrollToElement(carsGuideHomePageLocators.scroll);
	}

	public void GetCarName(String carName) {
		//List<WebElement> list=carsGuideHomePageLocators.elecarName;
		//for(int i =0;i<carName.length();i++) {
		DriverUtils.driver.findElement(By.xpath("//*[@class='home-block home-block-pr']/ul/li/a/span/following-sibling::span[contains(text(),'" + carName + "')]")).click();
		//}
	}

	public String GetCarTitle() {

		return carsGuideHomePageLocators.carTitle.getText();
	}

	public void CarSearchTextBox(String car) {
		carsGuideHomePageLocators.elesearchTextBox.sendKeys("bmw");
		DriverUtils.DynamicWaitXpathCss("#cgsearch-suggestions>li>a[data-suggested='" + car + "']");
		DriverUtils.driver.findElement(By.cssSelector("#cgsearch-suggestions>li>a[data-suggested='" + car + "']")).click();
	}

	public void HomePageFooters() {
		List<WebElement> varFooter = carsGuideHomePageLocators.eleFooters;
		for (int i = 1; i <= varFooter.size(); i++) {
			if (!(i == 7)) {
				String strFooter = DriverUtils.driver.findElement(By.cssSelector(".uhf-footer-nav>ul>li:nth-child(" + i + ")>a>span:nth-child(2)")).getText();
				System.out.println("links at the button of the page : " + strFooter);
			} else {
				for (int j = 1; j <= 2; j++) {
					String strFooter = DriverUtils.driver.findElement(By.xpath("//*[@class='uhf-footer-upper']//div[@class='uhf-footer-nav']/ul/li[" + i + "]/a[" + j + "]/span")).getText();
					System.out.println("links at the button of the page : " + strFooter);
				}
			}
		}
	}

	public void ScrollToPopularArticle() {
		DriverUtils.ScrollToElement(carsGuideHomePageLocators.popularArticle);
	}

	public void clickArticleLink() {
		List<WebElement> varArticle = carsGuideHomePageLocators.listpopularArticle;
		for (int i = 1; i <= varArticle.size(); i++) {
			DriverUtils.driver.findElement(By.xpath("//*[contains(@class,'popular-articles hidden')]/following-sibling::div/child::div/div[" + i + "]/a[3]")).click();
			String parentwin = DriverUtils.SwitchToWindow();
			String text = carsGuideHomePageLocators.eleArticleText.getText();
			System.out.println("Text of page is " + text);
			DriverUtils.driver.close();
			DriverUtils.driver.switchTo().window(parentwin);
		}
	}

	public void ClickOnMake() {
		carsGuideHomePageLocators.eleMake.click();
		DriverUtils.writeWordDocument("User clicks on Make", true);

	}

	public void ClickOnModel() {
		List<WebElement> makeList = carsGuideHomePageLocators.eleMakeList;
		for (int i = 1; i <= 5; i++) {
			WebElement eleMakeList = DriverUtils.driver.findElement(By.xpath("//*[@id='uhf-make-search']/child::ul/child::li[" + i + "]/a"));
			System.out.println("Name of car Make is : " + eleMakeList.getText());
			eleMakeList.click();

			DriverUtils.DynamicWaitXpath(eleHomePageTopPanel);

			List<WebElement> modelList = carsGuideHomePageLocators.eleModelList;
			for (int j = 1; j <= modelList.size(); j++) {
				WebElement eleModelList = DriverUtils.driver.findElement(By.xpath("//*[@class='uhf-model-results uhf-opaque']/child::ul/child::li[" + j + "]/a"));
				System.out.println("Name of car Model is : " + eleModelList.getText());
			}
			carsGuideHomePageLocators.eleMake.clear();
			DriverUtils.driver.findElement(By.xpath("//*[@class='uhf-lower-fixed on']")).click();

			ClickOnMake();
		}
	}



	public void retrieveMakeAndModelFromMap() {
		List<WebElement> makeList = carsGuideHomePageLocators.eleMakeList;
		Map<String, List<String>> hMap = new HashMap<String, List<String>>();
		List<String> listModel = new ArrayList<String>();

		for (int i = 1; i <= 5; i++) {
			WebElement eleMakeList = DriverUtils.driver.findElement(By.xpath("//*[@id='uhf-make-search']/child::ul/child::li[" + i + "]/a"));
			String strMakeList = eleMakeList.getText();
			eleMakeList.click();

			DriverUtils.DynamicWaitXpath(eleHomePageTopPanel);

			List<WebElement> modelList = carsGuideHomePageLocators.eleModelList;
			for (int j = 1; j <= modelList.size(); j++) {
				WebElement eleModelList = DriverUtils.driver.findElement(By.xpath("//*[@class='uhf-model-results uhf-opaque']/child::ul/child::li[" + j + "]/a"));
				//System.out.println("Name of car Model is : " + eleModelList.getText());
				listModel.add(eleModelList.getText());
			}


			hMap.put(strMakeList, listModel);

			for (Map.Entry<String, List<String>> entry : hMap.entrySet()) {
				String key = entry.getKey();
				List<String> values = entry.getValue();
				System.out.println("Key = " + key);
				System.out.println("Values = " + values + "n");
			}
			hMap.clear();
			listModel.clear();
			carsGuideHomePageLocators.eleMake.clear();
			DriverUtils.driver.findElement(By.xpath("//*[@class='uhf-lower-fixed on']")).click();
			ClickOnMake();
		}

	}

}


