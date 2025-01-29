package inventory.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import pageObjects.LoginPageObjects;
import utils.TestDataReader;

public class LoginTest extends BaseTest {
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	TestDataReader testData = new TestDataReader("LoginPageData.properties");

	@Test(priority = 1, enabled = true)
	public void loginWithCorrectCredetials() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterCredentials();
		loginPage.clickOnSignInButton();
		Assert.assertTrue(driver.findElement(By.xpath(LoginPageObjects.welcomeMessage)).getText()
				.contains(testData.getData("validUsername")));

	}

	@Test(priority = 2, enabled = true)
	public void loginWithInvalidUsername() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterInvalidUsername();
		loginPage.clickOnSignInButton();
		Assert.assertTrue(driver.findElement(By.xpath(LoginPageObjects.errorMessage)).getText()
				.contains(testData.getData("errorMessageText")));
	}

	@Test(priority = 3, enabled = true)
	public void loginWithInvalidPassword() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterInvalidPassword();
		loginPage.clickOnSignInButton();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath(LoginPageObjects.errorMessage)).getText()
				.contains(testData.getData("errorMessageText")));
	}

	@Test(priority = 4, enabled = true)
	public void loginWithInvalidUsernameAndPassword() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterInvalidUsernameAndPassword();
		loginPage.clickOnSignInButton();
		Assert.assertTrue(driver.findElement(By.xpath(LoginPageObjects.errorMessage)).getText()
				.contains(testData.getData("errorMessageText")));
	}

	@Test(priority = 5, enabled = true)
	public void loginWithoutUsernameAndPassword() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.loginWithoutUsernameAndPassword();
		loginPage.clickOnSignInButton();
		Assert.assertTrue(driver.findElement(By.xpath(LoginPageObjects.warningMessage)).getText()
				.contains(testData.getData("warningMessageText")));
	}

}
