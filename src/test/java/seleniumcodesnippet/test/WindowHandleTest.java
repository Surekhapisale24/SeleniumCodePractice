package seleniumcodesnippet.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleTest {
	WebDriver driver;
	public void openNewWindow() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		String Mainwindow = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://localhost:8080/");
		String window1 = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://github.com/");
		String window2 = driver.getWindowHandle();
		
		driver.switchTo().window(window1);
		Thread.sleep(5000);
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		System.out.println(windows);
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			Thread.sleep(5000);
		}
		
		

//        newWindow1.getWindowHandle();
//        System.out.println(newWindow1);
//        
//        newWindow1.getWindowHandle();
//        System.out.println(newWindow1);
        
       
        
      

// Close the new windows
//        newWindow1.quit();
//        newWindow2.quit();

        // Close the main browser window
       // driver.quit();
	}
	
}
		
		
		
		
	
		
		
		
//		  WebElement searchInput = driver.findElement(By.name("q"));
//	        searchInput.sendKeys("Selenium WebDriver");
//
//	        // Press Enter to perform the search
//	        searchInput.sendKeys(Keys.ENTER);
//
//	        // Wait for search results to load
//	        // (You might need to use explicit waits or other waiting mechanisms here)
//
//	        // Locate the list of search result links
//	        List<WebElement> searchResults = driver.findElements(By.cssSelector(".tF2Cxc"));
//
//	        // Create an Actions object
//	        Actions actions = new Actions(driver);
//
//	        Thread.sleep(2000);
//	        // Click the second search result link while holding down the Ctrl key
//	        actions.keyDown(Keys.CONTROL)
//	               .click(searchResults.get(1)) // Click the second search result link (index 1)
//	               .keyUp(Keys.CONTROL);
//
//	        // Perform the actions
//	        actions.build().perform();
//	        
//			Set<String> windows = driver.getWindowHandles();
//			System.out.println(windows);
//
//	        // Close the browser
//	       // driver.quit();
//		
//		
//		
//		
//		
		
//		driver.get("http://naukri.com");
//		driver.get("https://www.facebook.com/");
		
//		String parentId = driver.getWindowHandle();
//		System.out.println(parentId);
		

			
		//driver.quit();
	

