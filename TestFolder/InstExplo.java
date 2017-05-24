package testings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InstExplo {
	// https://www.instagram.com/explore/

	WebDriver driver;

	By title = By.className("title");
	WebElement firstButton = driver.findElement(By.xpath("//*[@id='react-root']/section/main/div/ul/li[2]/div/div[1]/div[2]/span/button")));

	public InstHome(WebDriver driver) {
		this.driver = driver;
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public WebElement getFollow() {
		return firstButton;
	}

	

}
