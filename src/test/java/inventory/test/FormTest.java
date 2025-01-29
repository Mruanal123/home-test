package inventory.test;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.FormPageEvents;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;

public class FormTest extends BaseTest {
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	FormPageEvents form = new FormPageEvents();

	@Test(priority = 6, enabled = true)
	public void verifyCreatedOrder() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterCredentials();
		loginPage.clickOnSignInButton();
		form.createOrder();
	}

	@Test(priority = 7, enabled = true)
	public void verifyCreatedOrderWithoutCheckingCheckbox() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterCredentials();
		loginPage.clickOnSignInButton();
		form.createOrderWithoutCheckboxMark();
	}

	@Test(priority = 8, enabled = true)
	public void verifytotalOrderValueOfCart() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterCredentials();
		loginPage.clickOnSignInButton();
		form.cartTotal();
	}
}
