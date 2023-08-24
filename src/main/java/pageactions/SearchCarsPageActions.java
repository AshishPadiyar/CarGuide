package pageactions;

import objectrepository.ObjectRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pagelocators.SearchCarsPageLocators;
import utilities.DriverUtils;


public class SearchCarsPageActions implements ObjectRepository {

	SearchCarsPageLocators searchCarsPageLocators = null;

	// Constructor
	public SearchCarsPageActions() {

		this.searchCarsPageLocators = new SearchCarsPageLocators();
		PageFactory.initElements(DriverUtils.driver, searchCarsPageLocators);
	}

	// Methods

	public void selectCarBrand(String carMake) {
		Select selectmake = new Select(searchCarsPageLocators.selectMake);
		selectmake.selectByVisibleText(carMake);
	}

	public void selectCarModel(String carModel) {
		DriverUtils.DynamicWaitXpath(eleHomePageModelDrpDown);
		Select selectModel = new Select(searchCarsPageLocators.selectModel);
		selectModel.selectByVisibleText(carModel);
	}

	public void selectLocation(String loc) {

		Select selectLoc = new Select(searchCarsPageLocators.selectLocation);
		selectLoc.selectByVisibleText(loc);
	}

	public void selectPrice(String maxPrice) {

		Select selectPrice = new Select(searchCarsPageLocators.selectPrice);
		selectPrice.selectByVisibleText(maxPrice);
	}

	public void clickonFind_My_Next_Car() {
		searchCarsPageLocators.findMyCarBtn.click();
		DriverUtils.writeWordDocument("Searched cars are", true);
	}

}
