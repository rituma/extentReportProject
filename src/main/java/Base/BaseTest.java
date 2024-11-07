package Base;

import java.lang.reflect.Method;
import java.time.Duration;


import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import CommonMethods.constant;
import CommonMethods.driverClass;

public class BaseTest {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	@BeforeTest
	public void beforeTestMethod() {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("AutomationMiniProject");
		sparkReporter.config().setReportName("MiniProjectReport");
		extent.setSystemInfo("HostName", "ItsMe");
		extent.setSystemInfo("Username", "Ritu");

	}

	@BeforeMethod
	public void beforeMethodMethod(Method testMethod) {
		logger = extent.createTest(testMethod.getName());
		CommonMethods.driverClass.setdriverMethod();
		Reporter.log("Setting driver");
		driverClass.getDriver().navigate().to(constant.browser);
		driverClass.getDriver().manage().window().maximize();
		driverClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterMethod
	public void AfterMethodMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test Case Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "- Test Case Pass", ExtentColor.GREEN));
			logger.log(Status.INFO, "this test case is passed");
			driverClass.getDriver().quit();
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"-Test case Skipped", ExtentColor.ORANGE));
		}
	}

	@AfterTest
	public void afterTest() {
		extent.createTest("Test case 1", "test case passed");
		extent.flush();
	}
}
