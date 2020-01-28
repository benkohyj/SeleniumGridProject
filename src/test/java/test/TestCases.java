
package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import hooks.BeforeAfterHooks;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TestCases extends BeforeAfterHooks{
		
	@Test
	public void agreeLiscensePage() {
		
		WebDriverWait androidWait = new WebDriverWait(androiddriver, 20);
		androidWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btn_tnc_ok")));
		AndroidElement accept = androiddriver.findElementById("btn_tnc_ok");
		accept.click();
	
	}
	
//	@Test
//	public static void disagreeLiscensePage() {
	//	androiddriver.findElementById("btn_tnc_cancel").click();
		
//	}


@Test
	public void goSTweb() {
		chromedriver.get("https://straitstimes.com");
		System.out.println(chromedriver.getTitle());
	}


}
