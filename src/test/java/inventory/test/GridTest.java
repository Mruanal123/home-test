package inventory.test;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.GridPageEvents;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;

public class GridTest extends BaseTest {
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	GridPageEvents grid = new GridPageEvents();

	@Test(priority = 9, enabled = true)
	public void verifyGridItemAtPosition7() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterCredentials();
		loginPage.clickOnSignInButton();
		grid.sevenItemOfGrid();
	}

	@Test(priority = 10, enabled = true)
	public void verifyAllGridItemsDetails() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterCredentials();
		loginPage.clickOnSignInButton();
		grid.allItemsOnGrid();
	}
}
