package CommonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface ObjectRepository {

	public static By signInMethod() {
		return By.xpath("//span[contains(text(),'Hello, sign in')]");		
	}
	public static By searchTextMethod= By.xpath("//input[@id='twotabsearchtextbox']");
	public static By clickFresh=By.xpath("//a/span[contains(text(),'Fresh')]");

	public static boolean searchTextBoxMethod() {
		WebElement e=driverClass.getDriver().findElement(searchTextMethod);
		if(e.isDisplayed()) 
			return true;
		else return false;
		}
	
}
