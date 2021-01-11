package extentlisteners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import utilities.DriverUtils;


public class ExtentManager {

	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	

	    public static ExtentReports createInstance() {
	    	 Date d = new Date();
	    	 String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	    	 String filename2=System.getProperty("user.dir") + "\\target\\reports\\" + fileName;
	    	
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(filename2);
	       
	        
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(filename2);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(filename2);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);

			extent.setSystemInfo("HostName", "MyHost");
			extent.setSystemInfo("ProjectName", "CarGuide");
			extent.setSystemInfo("Tester", "Ashish");
			extent.setSystemInfo("OS", "Win10");
			extent.setSystemInfo("Browser", "Chrome");
	        
	        
	        return extent;
	    }

	    
		
	    public static String srcfileName;
	    	
	    	
	    	public static void captureScreenshot() {

	    		Date d = new Date();
	    		
	    		srcfileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

	    		File screenshot = ((TakesScreenshot) DriverUtils.driver).getScreenshotAs(OutputType.FILE);
	    		try {
	    			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\target\\reports\\" + srcfileName));
	    			FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + srcfileName));
	    			
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}

	    	}
	    	
	    	
	 

	}
