package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.SearchPageObjects;
import utils.TestDataReader;

public class SearchPageEvents {

	TestDataReader testData = new TestDataReader("SearchPageData.properties");

	public void searchFunction() {
		// Verify search functionality
		BaseTest.driver.findElement(By.xpath(SearchPageObjects.searchOption)).click();
		BaseTest.driver.findElement(By.xpath(SearchPageObjects.searchtextboxField))
				.sendKeys(testData.getData("searchItemName"));
		BaseTest.driver.findElement(By.xpath(SearchPageObjects.submitButton)).click();

		WebElement resultMessage = BaseTest.driver.findElement(By.xpath(SearchPageObjects.serachMessage));

		Assert.assertTrue(resultMessage.getText().contains(testData.getData("expectedSearchResultMessage")),
				"Search is invalid");
		Assert.assertTrue(resultMessage.getText().contains(testData.getData("searchItemName")),
				"Search name is not coming in the result");
	}

	// Verify search functionality without any giving any input
	public void emptySearch() {

		// trying to submit search without any keyword
		BaseTest.driver.findElement(By.xpath(SearchPageObjects.searchOption)).click();
		BaseTest.driver.findElement(By.xpath(SearchPageObjects.submitButton)).click();

		WebElement searchResult = BaseTest.driver.findElement(By.xpath(SearchPageObjects.emptySearchResult));

		Assert.assertTrue(searchResult.getText().contains(testData.getData("expectedEmptySearchMessage")),
				"Search message is not coming");
	}
}
