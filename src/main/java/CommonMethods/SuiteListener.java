package CommonMethods;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import Base.BaseTest;

//on test failure we want to take a screenshot and attach it in report.
public class SuiteListener implements ITestListener,IAnnotationTransformer{

	public void onTestFailure(ITestResult result) {
		String filename=System.getProperty("user.dir")+File.separator+"screenshot"+File.separator+result.getMethod().getMethodName();
		File file1=((TakesScreenshot)driverClass.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file1, new File(filename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void transform(ITestAnnotation annotation,Class testClass,Constructor testConstructor,Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
