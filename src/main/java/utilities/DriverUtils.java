package utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils 
{
	public static String browser=ConfigUtils.Browser;
	public static WebDriver driver;
	public static WebElement element;
	public static JavascriptExecutor js;
	public static int implicitTimeWait=60;
	public static int setScriptTimeOut=60;
	public static WebDriverWait wait;
	public static Wait<WebDriver> fluentWait;
	public static XWPFDocument document=null;
	public static XWPFParagraph par=null;
	
	public static XWPFRun run= null;
	public static String wordFilePath=null;
	public static Actions action;
	
	
public static void setUp() throws IOException {
			
			
			if(browser.equalsIgnoreCase("chrome"))  {
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
				//log.info("Chrome Browser Launched !!!");
			}else if(browser.equalsIgnoreCase("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				//log.info("Firefox Browser Launched !!!");
			}
			
			driver.get(ConfigUtils.url);
			//log.info("url launched");
			//DbManager.setMysqlDbConnection();
			//log.info("Database connection established");
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigUtils.Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		//	wait = new WebDriverWait(driver,Integer.parseInt(ConfigUtils.Config.getProperty("explicit.wait")));
		}


		public static boolean IsElementPresent(By by) {
			try {

			driver.findElement(by);
			return true;
				}
			catch(Exception e)
			{
				//e.printStackTrace();
				return false;

			}

		}
		
		public static void createWordDoc(String TestCaseName){
			try {
			File word=new File("TestEvidences");
			wordFilePath=word+"\\"+TestCaseName+".docx";
			File file =new File(wordFilePath);
			if(file.exists()) {
				System.out.println("file already exists");
				wordFilePath=word+"\\"+TestCaseName+".docx";
			}
			document = new XWPFDocument();
			par= document.createParagraph();
			run=par.createRun();
			
				FileOutputStream fos=new FileOutputStream(new File(wordFilePath));
				
					document.write(fos);
					fos.close();
					System.out.println(TestCaseName + "document created");
					ConfigUtils.log.info(TestCaseName + "document created");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void writeWordDocument(String stepName,Boolean screenShot) {
			try {
				run.setText("Step "+ stepName);
				run.addBreak();
				run.addCarriageReturn();
				if(screenShot) {
					InputStream pic= new FileInputStream(Screenshot());
					run.addPicture(pic, Document.PICTURE_TYPE_JPEG, "", Units.toEMU(440), Units.toEMU(440));
					run.addBreak();
					run.addBreak();
					run.addBreak(BreakType.PAGE);
				}
				FileOutputStream fos=new FileOutputStream(wordFilePath);
				document.write(fos);
				fos.close();
						
			}catch(Exception e)
			{
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
			
		}
		
		public  static String dateTime() {
			
			Date d= new Date();
			 String date= d.toString().replace(":", "_").replace(" ", "_").concat(".jpg");
			 return date;
			
		}
		
		public  static File Screenshot() {
			String newdate= dateTime();
			File screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFileToDirectory(screenshot, new File(System.getProperty("user.dir")+"\\screenshot\\"+newdate));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return screenshot;
		}
		
		public static void ScrollToElement(WebElement element) {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		}
		
		
		public static void DynamicWaitXpath(String locator)
		{
			wait=new WebDriverWait(DriverUtils.driver,10);
			DriverUtils.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		}
	public static void DynamicWaitXpathCss(String locator)
	{
		wait=new WebDriverWait(DriverUtils.driver,10);
		DriverUtils.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
	}

	public static void ScrollToButtom() {
		DriverUtils.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
	}

	public static String SwitchToWindow()
	{
		Set<String> windows=DriverUtils.driver.getWindowHandles();
		String homePage= DriverUtils.driver.getWindowHandle();
		Iterator<String> itr=windows.iterator();
		while(itr.hasNext()) {

			String child_window=itr.next();


			if(!homePage.equals(child_window))
			{
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());


			}
		}
		return homePage;

	}


}
