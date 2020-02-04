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

	public static void SwipeHorizontal(AndroidDriver  touchDriver, String Direction, double y, double x1, double x2 ) throws InterruptedException {
		//y1 is the anchor point for horizontal movement, y>1
		//x1 is the position of the point from the LEFT of the screen, x1>0.5 (Right half of device)
		//x2 is the position of the point from the LEFT of the screen, x2<0.5 (Left half of device)
		Dimension screenSize = touchDriver.manage().window().getSize();

		Double yAnchor = screenSize.getHeight()/y;
		int Anchor = yAnchor.intValue();
		System.out.println(Anchor);
		
		Double ScreenWidthRight = screenSize.getWidth() * x1;
		int screenRight = ScreenWidthRight.intValue();
		System.out.println(screenRight);
		
		Double ScreenWidthLeft = screenSize.getWidth() * x2;
		int screenLeft = ScreenWidthLeft.intValue();
		System.out.println(screenLeft);

		switch(Direction.toUpperCase()){
		case("LEFT"):
			new TouchAction(touchDriver).press(PointOption.point(screenRight, Anchor))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
			.moveTo(PointOption.point(screenLeft, Anchor))
			.release().perform();
			break;
		
		case("RIGHT"):
			new TouchAction(touchDriver).press(PointOption.point(screenLeft, Anchor))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
			.moveTo(PointOption.point(screenRight, Anchor))
			.release().perform();
			break;
		}
		Thread.sleep(3000);
	}
	
	public static void SwipeVertical(AndroidDriver  touchDriver, String Direction, double x, double y1, double y2 ) throws InterruptedException {
		//x1 is the anchor point for horizontal movement, x1>1
		//y1 is the position of the point from the TOP of the screen(Top half of device) y1>0.5
		//y2 is the position of the point from the TOP of the screen(Bottom half of device) y2<0.5
		Dimension screenSize = touchDriver.manage().window().getSize();

		Double xAnchor = screenSize.getWidth()/x; 
		int Anchor = xAnchor.intValue();
		System.out.println(Anchor);

		Double ScreenWidthBottom = screenSize.getHeight() * y1;
		int screenBottom = ScreenWidthBottom.intValue();
		System.out.println(screenBottom);
		

		Double ScreenWidthTop = screenSize.getHeight() * y2;
		int screenTop = ScreenWidthTop.intValue();
		System.out.println(screenTop);


		switch(Direction.toUpperCase()){
		case("UP"):
			new TouchAction(touchDriver).press(PointOption.point(Anchor, screenBottom))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
			.moveTo(PointOption.point(Anchor, screenTop))
			.release().perform();
			break;
		
		case("DOWN"):
			new TouchAction(touchDriver).press(PointOption.point(Anchor, screenTop))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
			.moveTo(PointOption.point(Anchor,screenBottom))
			.release().perform();
			break;
		}
		Thread.sleep(3000);
	}



}
