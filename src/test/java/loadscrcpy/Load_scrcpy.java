package loadscrcpy;

import java.io.IOException;

public class Load_scrcpy {
	
	public static void loadscrcpy(String udid)throws IOException{
		    Runtime r=Runtime.getRuntime();
		    Process p=null;
		    try
		    {
		      
		 	 Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"scrcpy -s " + udid);
	    	 //Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"scrcpy -s " + udid);
	    	 //String s="C:\\Android\\sdk-tools-windows-4333796\\platform-tools\\scrcpy.exe";
		     //p=r.exec(s);
		    }
		    catch(Exception e){
		      System.out.println("error==="+e.getMessage());
		      e.printStackTrace();
		    }
		  }
		}
	
	
	

