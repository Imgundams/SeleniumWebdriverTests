package testings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InstHomeUser {
	// https://www.instagram.com/
	// After logging in
	public WebElement element = null;

	public WebElement getMyProfileButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div/div[3]/div/div[3]/a"));
		return element;
	}

}
