package seleniumcodesnippet.test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Test
public class ScreenShotTest
{
	public WebDriver driver;

	@Test
	public void loginGithub()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://github.com/");
	}


	@Test
	public void snapShot(WebDriver driver, String filewithpath) throws IOException{
		try {
			//convert WebDriver instance to TakesScreenshot for allowing us to take screenshot
			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			//capture the screenshot and store the file it in file object
			File srcfile = scrShot.getScreenshotAs(OutputType.FILE);

			//specify the destination filepath 
			File destfile = new File("C:\\Users\\Lenovo\\eclipse-workspace\\SeleniumCodePractice\\screenshot.png");

			//copy the screenshot file to specified destination
			FileUtils.copyFile(srcfile, destfile);

			System.out.println("screenshot saved succesfully to: " +destfile.getAbsolutePath());

		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			// Close the WebDriver
			if (driver != null) {
				driver.quit();
			}
		}
		//driver.quit();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}

