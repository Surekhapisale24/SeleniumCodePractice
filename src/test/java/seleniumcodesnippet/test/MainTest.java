package seleniumcodesnippet.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class MainTest {
	
	@Test
	public static void main(String[] args) throws IOException, InterruptedException {
		LaunchBrowserTest Browse = new LaunchBrowserTest();
		Browse.launchDiffDriver();
		
		InteractWithWebElementTest Ele = new InteractWithWebElementTest();
		Ele.logInFb();
		Ele.logInCredentials();
		
		WindowHandleTest WH = new WindowHandleTest();
		WH.openNewWindow();

		ScreenShotTest screenShotTest = new ScreenShotTest();
		screenShotTest.loginGithub();
		screenShotTest.snapShot(screenShotTest.driver, "C:\\Users\\Lenovo\\eclipse-workspace\\SeleniumCodePractice\\screenshot.png");
		
		BrokenImgAndLinksTest imgandlink = new BrokenImgAndLinksTest();
		imgandlink.manageBrokenLinksandImg();
    }
}

