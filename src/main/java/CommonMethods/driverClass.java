package CommonMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverClass{
	public static final ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

	public static void setdriverMethod() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rmaurya\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver.set(new ChromeDriver());
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
}