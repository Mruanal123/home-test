package inventory.test;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import pageEvents.SearchPageEvents;

public class SearchTest extends BaseTest {
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	SearchPageEvents search = new SearchPageEvents();

	@Test(priority = 11, enabled = true)
	public void verifySearchFunctionality() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterCredentials();
		loginPage.clickOnSignInButton();
		search.searchFunction();
	}

	@Test(priority = 12, enabled = true)
	public void verifyEmptySearchFunctionality() throws InterruptedException {
		homePage.loginLink();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterCredentials();
		loginPage.clickOnSignInButton();
		search.emptySearch();
	}
}
