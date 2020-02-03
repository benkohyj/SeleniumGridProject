
package test;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Actions.deviceActions;
import baseclass.BeforeAfterHooks;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestCases extends BeforeAfterHooks{
		
	@Test
	public void agreeLiscensePage() {
		
		//WebElement Panel = driver.findElement(By.id("lists_pager"));
		WebDriverWait androidWait = new WebDriverWait(androidDriver, 20);
		androidWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btn_tnc_ok")));
		AndroidElement accept = androidDriver.findElementById("btn_tnc_ok");
		accept.click();
		new TouchAction(androidDriver).press(PointOption.point(1160, 1803)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(787))).moveTo(PointOption.point(107, 1839)).release().perform();
        new WebDriverWait(androidDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='skip']")));
        androidDriver.findElement(By.xpath("//*[@id='skip']")).click();
    }
//.press(point(point.x + 120, point.y + 130))
		
	@Test(priority = 1)
	public void LoginSTweb() {

		browserDriver.get("https://straitstimes.com");
		System.out.println(browserDriver.getTitle());
		
		//Login
		browserDriver.findElement(By.cssSelector("#sph_login")).click();
		browserDriver.findElement(By.cssSelector("#IDToken1")).sendKeys("Premium_access3");
		browserDriver.findElement(By.cssSelector("#IDToken2")).sendKeys("Password123");
		browserDriver.findElement(By.cssSelector("#btnLogin")).click();
	}
	
	
	

	@Test(priority = 2)
	public void SearchSTweb() {
	
		WebDriverWait wait = new WebDriverWait(browserDriver, 40);
		browserDriver.get("https://straitstimes.com");
		System.out.println(browserDriver.getTitle());
			
		//Search bar
		browserDriver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div[2]/nav/div[6]/button")).click();
		browserDriver.findElement(By.className("queryly")).sendKeys("wuhan virus");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#queryly_resultcontainer > div:nth-child(2)")));
		browserDriver.findElement(By.cssSelector("#queryly_resultcontainer > div:nth-child(2) > a > div.queryly_title")).click();

		
	}






}
