package pageEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.GridPageObjects;
import utils.TestDataReader;

public class GridPageEvents {
	TestDataReader testData = new TestDataReader("GridPageData.properties");

	public void sevenItemOfGrid() {
		BaseTest.driver.findElement(By.xpath(GridPageObjects.gridOption)).click();

		// Find the item at 7th position (index 6 in 0-based index)
		WebElement itemAtPosition7 = BaseTest.driver.findElements(By.xpath(GridPageObjects.gridItemsList)).get(6);
		System.out.println(itemAtPosition7.getText());

		// Assert the item name at 7th position
		WebElement itemNamePositionAt7 = itemAtPosition7.findElement(By.xpath(GridPageObjects.gridItemNameAtPosition7));
		String actualItemName = itemNamePositionAt7.getText();
		Assert.assertEquals(testData.getData("itemName"), actualItemName);

		// Assert the item price at 7th position
		WebElement itemPricePositionAt7 = itemAtPosition7
				.findElement(By.xpath(GridPageObjects.gridItemPriceAtPosition7));
		String actualItemPrice = itemPricePositionAt7.getText();
		Assert.assertEquals(testData.getData("itemPrice"), actualItemPrice);

	}

	@SuppressWarnings("deprecation")
	public void allItemsOnGrid() {
		BaseTest.driver.findElement(By.xpath(GridPageObjects.gridOption)).click();

		List<WebElement> items = BaseTest.driver.findElements(By.xpath(GridPageObjects.gridItems));

		for (WebElement item : items) {
			// Checking if title is empty or not
			WebElement title = item.findElement(By.xpath(GridPageObjects.gridItemName));
			Assert.assertFalse(title.getText().isEmpty(), "Title should not be empty");

			// Checking if price is empty or not
			WebElement price = item.findElement(By.id(GridPageObjects.gridItemPrice));
			Assert.assertFalse(price.getText().isEmpty(), "Price should not be empty");

			// Checking if image is coming or not
			WebElement image = item.findElement(By.xpath(GridPageObjects.gridItemImage));
			Assert.assertNotNull(image.getAttribute("src"), "Image should have a src attribute");

			// Checking if button is present or not
			WebElement button = item.findElement(By.xpath(GridPageObjects.addItemButton));
			Assert.assertNotNull(button, "Button should be present");
		}
	}
}
