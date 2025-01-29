package pageEvents;

import org.openqa.selenium.By;

import base.BaseTest;
import pageObjects.HomePageObjects;

public class HomePageEvents {

	public void loginLink() throws InterruptedException {
		BaseTest.driver.findElement(By.xpath(HomePageObjects.loginPageLink)).click();

	}
}
