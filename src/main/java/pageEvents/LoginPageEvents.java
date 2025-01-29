package pageEvents;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.LoginPageObjects;
import utils.TestDataReader;

public class LoginPageEvents {

	TestDataReader testData = new TestDataReader("LoginPageData.properties");

	// Verify login page is loaded or not after login
	public void verifyLoginPageIsLoaded() {
		Assert.assertEquals(BaseTest.driver.findElement(By.xpath(LoginPageObjects.loginFormText)).getText(),
				"LOGIN FORM", "Element not found");
	}

	// Verify login functionality with valid credentials
	public void enterCredentials() {
		BaseTest.driver.findElement(By.id(LoginPageObjects.usernameField))
				.sendKeys(testData.getData("validUsername"));
		BaseTest.driver.findElement(By.id(LoginPageObjects.passwordField))
				.sendKeys(testData.getData("validPassword"));
	}

	// Verify login functionality with invalid username
	public void enterInvalidUsername() {
		BaseTest.driver.findElement(By.id(LoginPageObjects.usernameField))
				.sendKeys(testData.getData("invalidUseranme"));
		BaseTest.driver.findElement(By.id(LoginPageObjects.passwordField))
				.sendKeys(testData.getData("validPassword"));
	}

	// Verify login functionality with invalid password
	public void enterInvalidPassword() {
		BaseTest.driver.findElement(By.id(LoginPageObjects.usernameField))
				.sendKeys(testData.getData("validUsername"));
		BaseTest.driver.findElement(By.id(LoginPageObjects.passwordField))
				.sendKeys(testData.getData("invalidPassword"));
	}

	// Verify login functionality with invalid username and password
	public void enterInvalidUsernameAndPassword() {
		BaseTest.driver.findElement(By.id(LoginPageObjects.usernameField))
				.sendKeys(testData.getData("invalidUseranme"));
		BaseTest.driver.findElement(By.id(LoginPageObjects.passwordField))
				.sendKeys(testData.getData("invalidPassword"));
	}

	// Try to login without username and password
	public void loginWithoutUsernameAndPassword() {
		BaseTest.driver.findElement(By.id(LoginPageObjects.usernameField)).sendKeys("");
		BaseTest.driver.findElement(By.id(LoginPageObjects.passwordField)).sendKeys("");
	}

	public void clickOnSignInButton() {
		BaseTest.driver.findElement(By.xpath(LoginPageObjects.signInButton)).click();
	}

}
