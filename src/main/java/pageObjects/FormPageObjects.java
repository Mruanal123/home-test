package pageObjects;

public interface FormPageObjects {
	String formOption = "//a[text()='Form']";
	String fullNameFields = "//input[@name='firstname']";
	String emailField = "//input[@name='email']";
	String addressField = "//input[@name='address']";
	String cityField = "//input[@name='city']";

	String cardNameField = "//input[@name='cardname']";
	String cardNumberField = "//input[@name='cardnumber']";
	String expInMonthField = "//select[@name='expmonth']";
	String expYearField = "//input[@name='expyear']";
	String cvvField = "//input[@name='cvv']";

	String stateField = "//input[@name='state']";
	String zipField = "//input[@name='zip']";
	String checkboxField = "//input[@type='checkbox']";
	String continueToCheckoutButton = "//button[contains(text(),'Continue to checkout')]";
	String orderNumberText = "//p[contains(text(),'Order Number')]";

	String cartPrice = "//p//a//following-sibling::span[@class='price']";
	String totalCartPrice = "//p[text()='Total ']//span";

}
