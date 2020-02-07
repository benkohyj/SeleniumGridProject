package setup;

import java.io.File;
import java.io.IOException;

public class CMD {

	private static String userPath= System.getProperty("user.dir"); //User Directory
	private static File setupFiles= new File(userPath + "/setupFiles"); //directory to setup batch files
	private static Runtime r=Runtime.getRuntime();
	private static String startCMD="cmd /c start /min cmd.exe /K ";

	public static void loadscrcpy(String udid)throws IOException{
		r.exec(startCMD +"scrcpy -s " + udid);
	}


	public static void startHUB() throws IOException, InterruptedException {
		r.exec(startCMD + "RegisterHub.bat", null, setupFiles);
		Thread.sleep(5000);
	}


	public static void registerBROWSER(String browser) throws IOException, InterruptedException {

		switch(browser.toUpperCase()) {

		case("CHROME"):
			r.exec(startCMD + "RegisterChrome.bat", null, setupFiles);
		break;

		case("FIREFOX"):
			r.exec(startCMD + "RegisterFirefox.bat", null, setupFiles);
		break;		
		
		}
		Thread.sleep(5000);
	}


	public static void registerMOBILE(String device) throws IOException, InterruptedException {

		switch(device) {

		case("Samsung Galaxy S9"):
			r.exec(startCMD + "RegisterS9.bat", null, setupFiles);
		break;

		case("Samsung Galaxy Note 8"):
			r.exec(startCMD + "RegisterNote8.bat", null, setupFiles);
		break;	

		case("Samsung Galaxy Note 4"):
			r.exec(startCMD + "RegisterNote4.bat", null, setupFiles);
		break;	
		}
		
		Thread.sleep(10000);
	}

//	public static void quitCMD() throws IOException {
//		r.exec("exit");
//	}

} 

//Further improvement: Implement scrcpy for MAC/IOS

