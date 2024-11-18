import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {
    public static void main(String[] args) {
        // 1)  Launch Browser ( Chrome )
        WebDriver driver = new ChromeDriver();
        // 2) Open URL
        driver.get("https://demo.opencart.com");
        // 3) Validate title
        String actTitle = driver.getTitle();
        if(actTitle.equals("Your Store")){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        // 4) Close browser
        driver.close();

    }
}
