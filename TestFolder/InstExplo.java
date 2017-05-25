package testings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InstExplo {
	// https://www.instagram.com/explore/

	public WebElement element = null;
	
	public WebElement getFollow(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//*[@id='react-root']/section/main/div/ul/li[2]/div/div[1]/div[2]/span/button"));
		return element;
	}

}
