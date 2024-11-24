package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XPathAxesDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
        driver.manage().window().maximize();

        // Self: Refers to the current node itself.
        // The XPath selects the current 'a' element (SKF India) itself.
        String someText = driver.findElement(By.xpath("//a[normalize-space()='SKF India']/self::a")).getText();
        System.out.println(someText); // SKF India

        // Parent: Refers to the immediate parent node of the current node.
        // The XPath selects the 'td' parent of the 'a' element (SKF India).
        someText = driver.findElement(By.xpath("//a[normalize-space()='SKF India']/parent::td")).getText();
        System.out.println(someText); // SKF India

        // Child: Refers to the children (direct or indirect) of the current node.
        // The XPath selects all child elements under the ancestor 'tr' that contains 'EID Parry'.
        List<WebElement> children = driver.findElements(By.xpath("//a[normalize-space()='EID Parry']/ancestor::tr/child::td"));

        // Print out all child elements of the 'tr' ancestor.
        for (WebElement child : children) {
            System.out.println("Children links : " + child + "\n");
        }
        System.out.println("Number of children are " + children.size());

        // Ancestor: Selects the ancestor (any node above the current node).
        // The XPath selects the 'tr' ancestor of the 'a' element (SKF India).
        String data = driver.findElement(By.xpath("//a[normalize-space()='SKF India']/ancestor::tr")).getText();
        System.out.println(data);

        // Descendants: Selects all child and grandchild elements of the current node.
        // The XPath selects all descendants (td) of the 'tr' ancestor of 'SKF India'.
        List<WebElement> descendants = driver.findElements(By.xpath("//a[normalize-space()='SKF India']/ancestor::tr/descendant::td"));
        System.out.println("Descendants of TR: " + descendants.size());

        // Following: Selects nodes that appear after the current node in the document.
        // The XPath selects all 'tr' elements that follow the 'tr' ancestor of 'SKF India'.
        int size = driver.findElements(By.xpath("//a[normalize-space()='SKF India']/ancestor::tr/following::tr")).size();
        System.out.println("Following nodes of TR size is " + size);

        // Following-Sibling: Selects nodes that are at the same level as the current node and appear after it.
        // The XPath selects all 'tr' elements that are siblings and follow the 'tr' ancestor of 'SKF India'.
        size = driver.findElements(By.xpath("//a[normalize-space()='SKF India']/ancestor::tr/following-sibling::tr")).size();
        System.out.println("Following-Sibling nodes of TR size is " + size);

        // Preceding: Selects nodes that appear before the current node in the document.
        // The XPath selects all 'tr' elements that precede the 'tr' ancestor of 'SKF India'.
        size = driver.findElements(By.xpath("//a[normalize-space()='SKF India']/ancestor::tr/preceding::tr")).size();
        System.out.println("Preceding nodes of TR size is " + size);

        // Preceding-Sibling: Selects nodes that are at the same level as the current node and appear before it.
        // The XPath selects all 'tr' elements that are siblings and precede the 'tr' ancestor of 'SKF India'.
        List<WebElement> precedingSibling = driver.findElements(By.xpath("//a[normalize-space()='SKF India']/ancestor::tr/preceding-sibling::tr"));
        System.out.println("Preceding Siblings " + precedingSibling.size());

        // Interact with form elements on the Facebook sign-up page.
        // Click the submit button.
        driver.findElement(By.xpath("//div[@id='reg_form_box']//child::div//button[@type='submit']")).click();

        // Find the 'firstname' input field and enter "Pratham".
        driver.findElement(By.xpath("//button[@name='websubmit']/ancestor::div[@id='reg_form_box']/child::div[@id='fullname_field']/descendant::*/input[@name='firstname']")).sendKeys("Pratham");
    }
}
