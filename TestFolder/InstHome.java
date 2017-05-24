package testings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InstHome {
	// https://www.instagram.com/

	WebDriver driver;

	By title = By.className("title");
	WebElement mainPageSignup = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/div/div[1]/div/form/div[6]/span/button"));
	WebElement mainPageLogin = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/div/div[2]/p/a"));
	WebElement searchBox = driver.findElement(By.xpath("//*[@id='react-root']/section/nav/div/div/div/div[3]/div/div[3]/a"));
	

	public InstHome(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}
	public WebElement getLogin() {
		return mainPageLogin;
	}
	
	public WebElement getSignUp() {
		return mainPageSignup;
		}

	

}
