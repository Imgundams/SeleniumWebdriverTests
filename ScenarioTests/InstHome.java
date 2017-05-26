package ScenarioTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InstHome {
	// https://www.instagram.com/
	
	public String getTitle(WebDriver driver){
		By title = By.xpath("//*[@id='react-root']/section/main/article/div[2]/div[1]/h1");
		String titleName = driver.findElement(title).getText();
		return titleName;
	}

	public WebElement getLogin(WebDriver driver) {
		WebElement mainPageLogin = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/div[2]/div[2]/p/a"));
		return mainPageLogin;
	}

	public WebElement getSignUp(WebDriver driver) {
		WebElement mainPageSignup = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/div[2]/div[1]/div/form/div[6]/span/button"));
		return mainPageSignup;
	}
	
	public String getCopyright(WebDriver driver){
		By copyrightStuff = By.xpath("//*[@id='react-root']/section/footer/div/span");
		String copyStuff = driver.findElement(copyrightStuff).getText();
		return copyStuff;
	}


}
