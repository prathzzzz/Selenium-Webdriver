import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {
    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the website
        driver.get("https://demo.opencart.com/");

        // Locate the "MacBook" link using XPath
        WebElement macBookLink = driver.findElement(By.xpath("//a[text()='MacBook']"));

        // Check if the "MacBook" text is displayed
        boolean isMacBookTextDisplayed = macBookLink.isDisplayed();
        System.out.println("Is 'MacBook' text displayed: " + isMacBookTextDisplayed);

        // Click on the "MacBook" link
        macBookLink.click();

        // Retrieve the actual text of the "MacBook" link
        String actualText = macBookLink.getText();
        System.out.println("Actual Text: " + actualText);

        // Validate the retrieved text
        String validationResult = checkValues(actualText);
        System.out.println("Validation Result: " + validationResult);

        // XPath with contains, so any attribute with a partial match will work
        driver.findElement(By.xpath("//input[contains(@placeholder,'Sear')]")).sendKeys("Products");

        // XPath with starts-with
        driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sear')]")).sendKeys("Products");

        // Chained XPath (use when child elements do not have attributes, so use parent)
        driver.findElement(By.xpath("//div[@class='col-md-5']/div[@id='search']/input")).sendKeys("Products");

        // Quit the WebDriver
        driver.quit();
    }

    /**
     * Method to validate the text.
     *
     * @param actualText The text retrieved from the element
     * @return "true" if the text matches "MacBook", otherwise "false"
     */
    public static String checkValues(String actualText) {
        if ("MacBook".equals(actualText)) {
            return "true";
        }
        return "false";
    }
}
