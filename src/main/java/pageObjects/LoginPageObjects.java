package pageObjects;

public interface LoginPageObjects {
	String loginFormText = "//h2[text()='LOGIN FORM']";
	String usernameField = "username";
	String passwordField = "password";
	String signInButton = "//button[contains(text(),'Sign In')]";
	String welcomeMessage = "//div[@id='welcome-message']";
	String errorMessage = "//h2[text()='Wrong credentials']";
	String warningMessage = "//h2[text()='Fields can not be empty']";
}
