package testings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PHPBBPOM {
	// https://www.blankmediagames.com/phpbb/ucp.php?mode=login
	
	public WebElement element = null;

	public WebElement getPasswordBox(WebDriver driver) {
		element = driver.findElement(By.id("password"));
		return element;
	}
	
	public WebElement getLoginButton(WebDriver driver) {
		element = driver.findElement(By.name("login"));
		return element;
	}
	
	public WebElement getUserNameBox(WebDriver driver) {
		element = driver.findElement(By.id("username"));
		return element;
	}
	
	public WebElement getUserControlPanel(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='page-header']/div[2]/div/ul[2]/li/a[1]"));
		return element;
	}
	
	public WebElement getLogoutLink(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='page-header']/div[2]/div/ul[3]/li[3]/a"));
		return element;
	}
	

}
