package testings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InstLogin {
	//https://www.instagram.com/accounts/login/

		WebDriver driver;

		By title = By.className("title");
		WebElement usernameBox = driver.findElement(By.name("session[username_or_email]"));
		WebElement passwordBox = driver.findElement(By.name("session[password]"));
		WebElement loginButton = driver.findElement(By.name("//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/span/button"));

		public InstLogin(WebDriver driver) {
			this.driver = driver;
		}

		public String getTitle() {
			return driver.getTitle();
		}
		public WebElement getUsernameBox() {
			return usernameBox;
		}
		
		public WebElement getPasswordBox() {
			return passwordBox;
			}
		
		public WebElement getLoginButton() {
			return loginButton;
			}

	}

