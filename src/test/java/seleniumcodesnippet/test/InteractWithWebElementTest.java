package seleniumcodesnippet.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class InteractWithWebElementTest {
	WebDriver driver;
	
//	public InteractWithWebElementTest(WebDriver driver)
//	{
//		//super(driver);
//		//initialization
//		this.driver = driver;
//		PageFactory.initElements(driver , this);
//	}
	
	@Test
	public void logInFb()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://facebook.com");
	}
	
	@Test
	public void logInCredentials()
	{
		WebElement email = driver.findElement(By.xpath("//div/input[@id='email']"));
		email.sendKeys("surekhapisale24@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//div/input[@id='pass']"));
		password.sendKeys("Surekha@24");
		
		WebElement button = driver.findElement(By.xpath("//div/button"));
		button.click();
		
		System.out.println("Browser Closed");
		
		//driver.quit();
		
//		WebElement confirmbutton = driver.findElement(By.xpath("(//div/button)[2]"));
//		confirmbutton.click();
			
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
