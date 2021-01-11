package extentlisteners;

import java.util.Arrays;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class ExtentListeners extends ExtentManager implements ITestListener {


//	static Date d = new Date();
//	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
//
//	private static ExtentReports extent = ExtentManager
//			.createInstance(System.getProperty("user.dir") + "\\target\\reports\\" + fileName);

	public static ExtentTest test;

	public void onTestStart(ITestResult result) {

		String param = (String) result.getParameters()[0];
//		test = extent.createTest(result.getTestClass().getName() + "     @TestCase : "
//				+ result.getMethod().getMethodName() + " -- " + param);
		
		test = extent.createTest(result.getName());

	}
	


	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);

	}
	

	public void onTestFailure(ITestResult result) {

		// ReportNG
		ExtentManager.captureScreenshot();

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=" + ExtentManager.srcfileName + " target=\"_blank\">Screenshot link</a>");
		Reporter.log("<br>");
		Reporter.log(
				"<a href=" + ExtentManager.srcfileName + " target=\"_blank\"><img src=" + ExtentManager.srcfileName + " height=200 width=200></a>");

//////////////////////////////////

		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.fail(excepionMessage);

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " FAILED" + "</b>";

		try {

			String screenshots = ExtentManager.srcfileName;
			test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshots).build());
		} catch (Throwable e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}

}
