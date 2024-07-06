package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleBooksSearch {
    
    // Declare WebDriver instance
    WebDriver driver;
    
    // Constructor to initialize WebDriver and PageFactory elements
    public GoogleBooksSearch(WebDriver driver) {
        this.driver = driver; // Assign the passed WebDriver instance to the class instance
        PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
    }
    
    // Locate the search input box element using the @FindBy annotation
    private @FindBy(id = "oc-search-input")
    WebElement searchInbox;
    
    // Locate the submit button using the @FindBy annotation and its XPath
    private @FindBy(xpath = "//input[@type='submit']")
    WebElement submitBtn;
    
    // Method to search for items and return a new instance of the SearchResults page
    public SearchResults searchItems(String s) {
        searchInbox.sendKeys(s); // Enter the search term in the search input box
        submitBtn.click(); // Click the submit button to initiate the search
        return new SearchResults(driver); // Return a new instance of the SearchResults page
    }
}

