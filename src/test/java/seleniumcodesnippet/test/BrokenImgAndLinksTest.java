package seleniumcodesnippet.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class BrokenImgAndLinksTest {
	
	@Test
    public void manageBrokenLinksandImg() 
    {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://google.com");
        
        //driver.get("https://en.wikipedia.org/wiki/List_of_HTTP_status_codes");

        // Find all links on the page
        List<WebElement> linksList = driver.findElements(By.tagName("a"));

        // Debugging: Print total number of links found
        System.out.println("Total Links Found: " + linksList.size());

        // Debugging: Print URLs of all links found
        for (WebElement linkElement : linksList) {
            System.out.println("Link URL: " + linkElement.getAttribute("href"));
        }

        // Iterate through each link and check if it's broken
        for (WebElement linkElement : linksList) {
            String linkURL = linkElement.getAttribute("href");

            // Check if the linkURL is not null or empty
            if (linkURL != null && !linkURL.isEmpty()) {
                try {
                    // Send HTTP request
                    HttpURLConnection connection = (HttpURLConnection) new URL(linkURL).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();

                    // Check HTTP response code
                    int responseCode = connection.getResponseCode();
                    if (responseCode != HttpURLConnection.HTTP_OK) {
                        System.out.println("Broken Link URL: " + linkURL);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // Close the WebDriver session
        driver.quit();
    }
}


