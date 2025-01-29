package pageObjects;

public interface GridPageObjects {
	String gridOption = "//a[text()='Grid']";
	String gridItemsList = "//label[@data-test-id='card-number']";
	String gridItemName = "//h4[@data-test-id='item-name']";
	String gridItemPrice = "item-price";
	String gridItemImage = "//div[@class='item']//img";
	String addItemButton = "//button[contains(text(),'Add to Order')]";
	String gridItemNameAtPosition7 = "//label[text()='7']/following-sibling::h4";
	String gridItemPriceAtPosition7 = "//label[text()='7']/following-sibling::p";
	String gridItems = "//div[@class='item']";
}
