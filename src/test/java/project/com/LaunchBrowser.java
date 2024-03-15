package project.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import project.com.*;
//import InterviewQnsCodes.WebDriver;

public class LaunchBrowser
{
	public WebDriver driver;
	public static  void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		
	}
}
