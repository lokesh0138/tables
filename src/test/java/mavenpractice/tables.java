package mavenpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tables {
	
	public WebDriver driver;

	By price=By.cssSelector(".table-display td:nth-child(3)");
	By pop=By.xpath("//input[@id='name']");
	By confirm=By.xpath("//input[@id='confirmbtn']");
	public tables(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public List<WebElement> tab()
	{
		return driver.findElements(price);
	}
	
	public WebElement popup()
	{
		return driver.findElement(pop);
	}
	
	public WebElement button()
	{
		return driver.findElement(confirm);
	}


}
