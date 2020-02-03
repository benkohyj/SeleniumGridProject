package loadscrcpy;

import java.io.IOException;

public class Load_scrcpy {
	
	public static void loadscrcpy(String udid)throws IOException{
		    Runtime r=Runtime.getRuntime();
		    try
		    {
		      
		 	 r.exec("cmd /c start cmd.exe /K \"scrcpy -s " + udid);
	    	 
		    }
		    catch(Exception e){
		      System.out.println("error==="+e.getMessage());
		      e.printStackTrace();
		    }
		  }
		}
	
	
	//Further improvement: Implement scrcpy for MAC/IOS

