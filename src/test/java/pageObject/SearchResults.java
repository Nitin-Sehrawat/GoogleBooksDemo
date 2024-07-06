package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults {

    // WebDriver instance for interacting with the browser
    WebDriver driver;

    // Constructor to initialize WebDriver and PageFactory elements
    public SearchResults(WebDriver driver) {
        this.driver = driver; // Assign the passed WebDriver instance to the class instance
        PageFactory.initElements(driver, this); // Initialize WebElements using PageFactory
    }

    // WebElement for the filter popup element
    @FindBy(xpath = "//div[@class='KTBKoe' and text()='Any document']")
    WebElement filterPopup;

    // WebElement for the filter item to select 'Books' option
    @FindBy(xpath = "//g-menu[@jsname='xl07Ob']//a[text()='Books']")
    WebElement filterItemBooks;
    
    // WebElement for the third result in the search list
    @FindBy(xpath = "//div[@class='MjjYud'][3]")
    WebElement thirdResult;

    // Method to apply the filter by selecting 'Books' option
    public void applyFilter() {
        filterPopup.click(); // Click the filter popup to open the filter options
        filterItemBooks.click(); // Click the filter item for 'Books' option
    }
    
    // Method to select the third search result
    public void selectThirdItem() {
        thirdResult.click(); // Click the third result in the search list
    }
}
