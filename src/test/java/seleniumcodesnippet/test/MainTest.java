package seleniumcodesnippet.test;

import java.io.IOException;

public class MainTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		//LaunchBrowserTest Browse = new LaunchBrowserTest();
		//Browse.launchDiffDriver();
		
//		InteractWithWebElementTest Ele = new InteractWithWebElementTest();
//		Ele.logInFb();
//		Ele.logInCredentials();
		
		WindowHandleTest WH = new WindowHandleTest();
		WH.openNewWindow();
		
		
	}
}
