package pageEvents;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.FormPageObjects;
import utils.TestDataReader;

public class FormPageEvents {
	TestDataReader testData = new TestDataReader("FormPageData.properties");

	public void createOrder() throws InterruptedException {

		// Create a new order
		BaseTest.driver.findElement(By.xpath(FormPageObjects.formOption)).click();
		BaseTest.driver.findElement(By.xpath(FormPageObjects.fullNameFields)).sendKeys(testData.getData("fullName"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.emailField)).sendKeys(testData.getData("email"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.addressField)).sendKeys(testData.getData("address"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.cityField)).sendKeys(testData.getData("city"));

		BaseTest.driver.findElement(By.xpath(FormPageObjects.cardNameField)).sendKeys(testData.getData("cardName"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.cardNumberField)).sendKeys(testData.getData("cardNumber"));

		Select dropdown = new Select(BaseTest.driver.findElement(By.xpath(FormPageObjects.expInMonthField)));
		dropdown.selectByVisibleText("March");
		BaseTest.driver.findElement(By.xpath(FormPageObjects.expYearField)).sendKeys(testData.getData("expiryYear"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.cvvField)).sendKeys(testData.getData("cvv"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.stateField)).sendKeys(testData.getData("state"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.zipField)).sendKeys(testData.getData("zipcode"));

		// checked if checkbox is selected or not
		if (BaseTest.driver.findElement(By.xpath(FormPageObjects.checkboxField)).isSelected()) {
			System.out.println("Checkbox is selected");
		} else {
			System.out.println("Checkbox is not selected");
			BaseTest.driver.findElement(By.xpath(FormPageObjects.checkboxField)).click();
		}

		BaseTest.driver.findElement(By.xpath(FormPageObjects.continueToCheckoutButton)).click();
		System.out.println(BaseTest.driver.findElement(By.xpath(FormPageObjects.orderNumberText)).getText());
		Assert.assertFalse(BaseTest.driver.findElement(By.xpath(FormPageObjects.orderNumberText)).getText().isEmpty(),
				testData.getData("confirmationMessage"));

	}

	public void createOrderWithoutCheckboxMark() throws InterruptedException {
		// try to create a new order without checking checkbox
		BaseTest.driver.findElement(By.xpath(FormPageObjects.formOption)).click();
		BaseTest.driver.findElement(By.xpath(FormPageObjects.fullNameFields)).sendKeys(testData.getData("fullName"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.emailField)).sendKeys(testData.getData("email"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.addressField)).sendKeys(testData.getData("address"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.cityField)).sendKeys(testData.getData("city"));

		BaseTest.driver.findElement(By.xpath(FormPageObjects.cardNameField)).sendKeys(testData.getData("cardName"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.cardNumberField)).sendKeys(testData.getData("cardNumber"));

		Select dropdown = new Select(BaseTest.driver.findElement(By.xpath(FormPageObjects.expInMonthField)));
		dropdown.selectByVisibleText("March");
		BaseTest.driver.findElement(By.xpath(FormPageObjects.expYearField)).sendKeys(testData.getData("expiryYear"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.cvvField)).sendKeys(testData.getData("cvv"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.stateField)).sendKeys(testData.getData("state"));
		BaseTest.driver.findElement(By.xpath(FormPageObjects.zipField)).sendKeys(testData.getData("zipcode"));

		// checked if checkbox is selected or not and mark it as selected
		if (BaseTest.driver.findElement(By.xpath(FormPageObjects.checkboxField)).isSelected()) {
			System.out.println("Checkbox is selected");
		} else {
			System.out.println("Checkbox is not selected");
			BaseTest.driver.findElement(By.xpath(FormPageObjects.checkboxField)).click();
		}

		if (BaseTest.driver.findElement(By.xpath(FormPageObjects.checkboxField)).isSelected()) {
			System.out.println("Checkbox is selected");
			BaseTest.driver.findElement(By.xpath(FormPageObjects.checkboxField)).click();
		} else {
			System.out.println("Checkbox is not selected");
		}

		BaseTest.driver.findElement(By.xpath(FormPageObjects.continueToCheckoutButton)).click();
		Alert alert = BaseTest.driver.switchTo().alert();
		alert.accept();

	}

	public void cartTotal() {
		// Verify total element cost is equal to total
		BaseTest.driver.findElement(By.xpath(FormPageObjects.formOption)).click();
		double totalCalculated = 0;
		for (WebElement priceElement : BaseTest.driver.findElements(By.xpath(FormPageObjects.cartPrice))) {
			String priceText = priceElement.getText().trim().replace("$", ""); // Remove '$' sign
			double price = Double.parseDouble(priceText); // Convert to double
			totalCalculated += price;
		}

		String totalText = BaseTest.driver.findElement(By.xpath(FormPageObjects.totalCartPrice)).getText().trim()
				.replace("$", "");
		double totalDisplayed = Double.parseDouble(totalText);

		if (Math.abs(totalCalculated - totalDisplayed) < 0.01) {
			System.out.println("Total is correct!");
		} else {
			System.out.println("Calculated total (" + totalCalculated + ") does not match displayed total ("
					+ totalDisplayed + ")");
		}

	}
}
