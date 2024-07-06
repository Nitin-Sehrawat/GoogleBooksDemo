package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObject.GoogleBooksSearch;
import pageObject.SearchResults;
import utilities.ReadFile;

public class BaseClass {
    
    // Declare WebDriver instance
    public WebDriver driver;
    
    // Create an instance of ReadFile class to read configuration data
    ReadFile rf = new ReadFile();
    
    // Declare instances for GoogleBooksSearch and SearchResults pages
    GoogleBooksSearch googleBooksSearch;
    SearchResults searchResult;
    
    // Method to initialize and launch the Chrome browser
    public void launchBrowser() {
        driver = new ChromeDriver(); // Initialize ChromeDriver
    }
    
    // Method to open URL
    public void getURL() {
        driver.get(rf.getURL()); // Get the URL from ReadFile class and navigate to it
        driver.manage().window().maximize(); // Maximize the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait for 10 seconds
    }
    
    // Method to take a screenshot and save it to the specified path
    public void takeScreenShot() throws IOException {
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver; // Cast driver to TakesScreenshot
        File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE); // Capture the screenshot and store it in a file
        String path = System.getProperty("user.dir") + "\\ScreenShots\\book_screenshot.png"; // Define the destination path
        File destinationFile = new File(path); // Create a new file at the destination path
        FileUtils.copyFile(sourceFile, destinationFile); // Copy the screenshot to the destination file
    }
}
