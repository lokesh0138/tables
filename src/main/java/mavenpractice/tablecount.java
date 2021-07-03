package mavenpractice;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class tablecount extends base {
	public WebDriver driver;	
	@BeforeTest
	public void initial() throws IOException{
		driver=initilize();
	
	}
	@Test()
	public void login() throws InterruptedException{
		driver.get(prop.getProperty("url"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		int sum=0;
		tables tb=new tables(driver);
		
		List<WebElement> count=tb.tab();
		for(int i=0;i<count.size();i++)
		{
			sum= sum+Integer.parseInt(count.get(i).getText());
			System.out.print(sum);
		}
		
		Assert.assertEquals(sum, 235);
		js.executeScript("window.scrollBy(0,100)");
		tb.popup().sendKeys("abc");
		Thread.sleep(2000);
		tb.button().click();
		System.out.print(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
	
		}

	@AfterTest
	public void end(){
		driver.close();
	}

}
