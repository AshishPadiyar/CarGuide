package pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchCarsPageLocators {
	
	@FindBy(xpath = "//*[@id='makes']")
	// OR    @FindBy(css="#makes")
	//css="select[id='makes']"
	public WebElement selectMake;
	
	@FindBy(xpath = "//*[@id='models']")
	public WebElement selectModel;
	
	@FindBy(id="locations")
	public WebElement selectLocation;
	
	@FindBy(id="priceTo")
	public WebElement selectPrice;
	
	@FindBy(id="search-submit")
	public WebElement findMyCarBtn;
	

}
