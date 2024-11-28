package BrokenLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinksDemo {

    /**
     * This method verifies whether a given URL is valid or broken.
     * It establishes an HTTP connection to the URL and checks the response code.
     *
     * @param url The URL to verify
     */
    public static void verifyLink(String url) {
        try {
            // Create a URL object from the provided string
            URL link = new URL(url);

            // Open an HTTP connection to the URL
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();

            // Set the connection timeout to 3 seconds
            httpURLConnection.setConnectTimeout(3000);

            // Attempt to connect to the URL
            httpURLConnection.connect();

            // Check the HTTP response code
            if (httpURLConnection.getResponseCode() == 200) {
                // If the response code is 200, the link is valid
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            } else {
                // If the response code is not 200, the link is broken
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
            }
        } catch (Exception e) {
            // Catch any exceptions (e.g., malformed URL or connection failure) and mark the link as broken
            System.out.println(url + " - " + "is a broken link");
        }
    }

    public static void main(String[] args) {
        // Initialize the WebDriver for Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait time of 10 seconds for the WebDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the target webpage
        driver.get("https://bstackdemo.com/");

        // Find all anchor tags ("a") on the webpage to get the available links
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Iterate through each link and verify its status
        for (WebElement link : links) {
            // Retrieve the href attribute of the anchor tag
            String url = link.getAttribute("href");

            // Verify if the link is valid or broken
            verifyLink(url);
        }

        // Close the browser after processing all links
        driver.quit();
    }
}
