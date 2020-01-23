
package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import hooks.BeforeAfterHooks;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class testcases extends BeforeAfterHooks{
		
	   
	
	
	@Test
	public static void agreeLiscensePage() {
		
		//androiddriver.findElementById("btn_tnc_ok").click();
		androiddriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//AndroidDriverWait wait = new WebDriverWait(driver, 10);
		AndroidElement accept = androiddriver.findElementById("btn_tnc_ok");
		accept.click();
		
		
	}
	
//	@Test
//	public static void disagreeLiscensePage() {
	//	androiddriver.findElementById("btn_tnc_cancel").click();
		
//	}

/*
@Test
	public static void goSTweb() {
		//chromedriver.get("https://straitstimes.com");
		System.out.println("Hello World");
	
	}

*/
}
