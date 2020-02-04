package deviceActions;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class DeviceActions  {

	public static void Swipe(AndroidDriver  touchDriver, String Direction ) throws InterruptedException {

		Dimension screenSize = touchDriver.manage().window().getSize();

		int Anchor = screenSize.getHeight()/2; 

		Double ScreenWidthRight = screenSize.getWidth() * 0.8;
		int screenRight = ScreenWidthRight.intValue();

		Double ScreenWidthLeft = screenSize.getWidth() * 0.2;
		int screenLeft = ScreenWidthLeft.intValue();


		switch(Direction.toUpperCase()){
		case("LEFT"):
			new TouchAction(touchDriver).press(PointOption.point(screenRight, Anchor))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
			.moveTo(PointOption.point(screenLeft, Anchor))
			.release().perform();
		
		case("RIGHT"):
			new TouchAction(touchDriver).press(PointOption.point(screenLeft, Anchor))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
			.moveTo(PointOption.point(screenRight, Anchor))
			.release().perform();
			
		}
		Thread.sleep(3000);
	}


}
