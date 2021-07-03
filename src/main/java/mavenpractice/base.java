package mavenpractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initilize() throws IOException{
		prop=new Properties();
		System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream (System.getProperty("user.dir")+"\\Resources\\data.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		//String browsername=System.getProperty("browser");
		System.out.println(browsername);
	
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\krishna\\Downloads\\geckodriver-v0.28.0-win32\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\krishna\\Downloads\\IEDriverServer_Win32_3.150.1 (2)\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	return driver;
		
		
	}
	public String getscreenshot(String testcasename,WebDriver driver ) throws IOException{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(source,new File(destination));
		return destination;
		
	}

}
