package pages;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import CommonMethods.ObjectRepository;
import CommonMethods.driverClass;

public class HomePage {

	public void validateifamazonisopen() {
	Assert.assertTrue((ObjectRepository.searchTextBoxMethod()), "Element not found");
	Actions a =new Actions(driverClass.getDriver());
	driverClass.getDriver().findElement(ObjectRepository.searchTextMethod).click();
	}
}
