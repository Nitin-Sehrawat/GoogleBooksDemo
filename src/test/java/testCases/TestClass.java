package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObject.GoogleBooksSearch;

public class TestClass extends BaseClass {

	// Test method to execute the test scenario
	@Test
	public void searchBooks() {
		launchBrowser(); // Initialize and launch the browser
		getURL(); // Method calling to open URL
		googleBooksSearch = new GoogleBooksSearch(driver); // Initialize GoogleBooksSearch page object
		searchResult = googleBooksSearch.searchItems("Software Testing"); // Perform search and get search results
		searchResult.applyFilter(); // Apply filter to show only books
		searchResult.selectThirdItem(); // Select the third item in the search results
		try {
			Thread.sleep(5000); // Pause for 5 seconds so that page will open properly
			takeScreenShot(); // Take a screenshot of the book details
		} catch (IOException | InterruptedException e) {
			e.printStackTrace(); 
		}

	}
}
