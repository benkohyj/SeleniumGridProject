package hooks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import loadscrcpy.Load_scrcpy;

public class BeforeAfterHooks{
	
	//define public variable
	public AndroidDriver<AndroidElement> androiddriver;
	public WebDriver chromedriver;
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"port","systemPort", "deviceName", "udid", "app", "appPackage", "appActivity"})
	public void setCaps(String port, String systemPort, String deviceName, String udid, String app, String appPackage, String appActivity){
		
		try {
			Load_scrcpy.loadscrcpy(udid);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String rPath= System.getProperty("user.dir"); //resource path
		
		//define Chrome Capabilities
		DesiredCapabilities chromeCaps = new DesiredCapabilities();
		chromeCaps.setBrowserName("chrome");
		chromeCaps.setPlatform(Platform.ANY);	
		
		
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", rPath + "/driverResources/chromedriver.exe");
		chromeoptions.merge(chromeCaps);
	
		//define Android Capabilities
		DesiredCapabilities androidCaps = new DesiredCapabilities();
		androidCaps.setCapability("automationName", "UiAutomator2");
		androidCaps.setCapability("platformName", "Android");
		androidCaps.setCapability("deviceName", deviceName);
		androidCaps.setCapability("udid", udid);
		androidCaps.setCapability("systemPort", systemPort);
		androidCaps.setCapability("app", rPath + app );
		androidCaps.setCapability("appPackage", appPackage);
		androidCaps.setCapability("appActivity", appActivity);
		androidCaps.setCapability("noReset", "true");
		androidCaps.setCapability("fullReset", "false");
		
		//Url to hub
		URL androidURL = null;
		URL chromeURL = null; 
		try {
			androidURL = new URL ("http://localhost:"+port+"/wd/hub");
			chromeURL = new URL ("http://localhost:5566/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//creating automation driver
		androiddriver= new AndroidDriver<AndroidElement> (androidURL,androidCaps);
		System.out.println ("Android Driver Started");
		chromedriver= new RemoteWebDriver(chromeURL,chromeoptions);
	
		//androiddriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
	@AfterTest(alwaysRun=true)
	public void endTest() {
		System.out.println("Should exit App");
		androiddriver.closeApp();
		System.out.println("Test Ended");
		chromedriver.quit();
	}

}
