package ScenarioTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InstLogin {
	// https://www.instagram.com/accounts/login/

	public WebElement element = null;
	

	public WebElement getUsernameBox(WebDriver driver) {
		element = driver.findElement(By.name("username"));
		return element;
	}

	public WebElement getPasswordBox(WebDriver driver) {
		element = driver.findElement(By.name("password"));
		return element;
	}

	public WebElement getLoginButton(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/span/button"));
		return element;
	}

}
