package pageObjects;

public interface SearchPageObjects {
	String searchOption = "//a[text()='Search']";
	String searchtextboxField = "//input[@name='searchWord']";
	String serachMessage = "//p[text()='Found one result for Pizza']";
	String emptySearchResult = "//p[contains(text(),'Please provide a search word')]";
	String submitButton = "//button[@type='submit']";
}
