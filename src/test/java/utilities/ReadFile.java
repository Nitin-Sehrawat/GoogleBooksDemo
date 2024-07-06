package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFile {

	// Properties and FileInputStream objects
	Properties prop;
	FileInputStream fis;

	// File path for the configuration file
	String fileName = System.getProperty("user.dir") + "\\ConfigrationFile\\Config.properties";

	// Constructor to initialize properties and load the configuration file
	public ReadFile() {
		try {
			fis = new FileInputStream(fileName); // Create a FileInputStream for the configuration file
			prop = new Properties(); // Initialize Properties object
			prop.load(fis); // Load properties from the configuration file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to get URL from the configuration file
	public String getURL() {
		String url = prop.getProperty("url"); // get the 'url' property from the configuration file
		return url; // Return the URL
	}
}
