package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.checkerframework.common.reflection.qual.GetClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;




public class ConfigUtils {
	
	
	public static WebDriver driver;
	public static String Browser;
	public static String url;
	public static Logger log = Logger.getLogger(GetClass.class);
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	//public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static String logFilePath;
	static WebElement dropdown;
	public static String logStartTime="";
	public static String logfile;
	
	
	public static void beforeTest() throws IOException {
		
		ConfigUtils.readConfig();
		ConfigUtils.loggerStart();
		
	}

	
	
	
	public static  void readConfig() throws IOException {
		
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties");
			try {
				fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
				Config.load(fis);
				log.info("config properties loaded");
				
				ConfigUtils.Browser=Config.getProperty("browser");
				ConfigUtils.url=Config.getProperty("testsiteurl");
				logFilePath=new File("LogFolder").getAbsolutePath();
				
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	public static void loggerStart() {
		try {
			logStartTime=DriverUtils.dateTime();
			logfile=ConfigUtils.logFilePath+"\\"+"logfile"+logStartTime+".log";
			BasicConfigurator.configure();
			FileAppender fp=new FileAppender();
			fp.setFile(logfile);
			fp.setLayout(new SimpleLayout());
			log.addAppender(fp);
			fp.activateOptions();
			log.setLevel(Level.INFO);
			log.info("Execution Starting Time is "+logStartTime);
			log.info("logger started");
		}catch(Exception e) {
			e.printStackTrace();
			log.error(e);

		}
	}

		public static void pageLoad(WebDriver driver) {
			ExpectedCondition<Boolean> pageload=new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
				
					return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
				}
				
			};
			DriverUtils.wait.until(pageload);
		}
	

}
