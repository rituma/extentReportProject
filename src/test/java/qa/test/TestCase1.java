package qa.test;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Base.BaseTest;
import CommonMethods.ObjectRepository;
import CommonMethods.driverClass;
import pages.HomePage;

public class TestCase1 extends BaseTest {
	HomePage hp=new HomePage();
@Test
	public void sampleMethodToOpenAmazon() {
		hp.validateifamazonisopen();
	}
@Test
   public void sampleMethodToClickFresh() {
	hp.validateifamazonisopen();
	Actions a=new Actions(driverClass.getDriver());
	driverClass.getDriver().findElement(ObjectRepository.clickFresh).click();
}
}
