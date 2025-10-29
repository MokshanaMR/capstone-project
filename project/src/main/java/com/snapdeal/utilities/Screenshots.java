package com.snapdeal.utilities;

import java.io.File;
import java.io.IOException;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class Screenshots {
 
	static String projectpath=System.getProperty("user.dir");
	
	public static String Capture(WebDriver driver, String TestName) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String dest=projectpath+"\\src\\test\\resources\\Screenshots\\sc1.png";
		
		File destfile=new File(dest);
		FileUtils.copyFile(src, destfile);
		
		return dest;
	}
	
}
 