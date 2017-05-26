package ScenarioTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InstUser {
	// https://www.instagram.com/superrobot.6/
	public WebElement element = null;
	
	public int getFollowCount(WebDriver driver) {
		By followCount = By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/ul/li[3]/a/span");
		int followers = Integer.parseInt(driver.findElement(followCount).getText());
		return followers;
		}

	public WebElement getCogButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/div/button"));
		return element;
	}
	
	public WebElement getEditProfileButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/a/span/button"));
		return element;
		}
	
	
	public String getBioData(WebDriver driver) {
		try{
		By bioPath = By.cssSelector("html.js.logged-in body span#react-root section._8f735 main._6ltyr._rnpza article._42elc._qfkcw header._5axto div._de9bg div._bugdy span span");
		String bio = driver.findElement(bioPath).getText();
		return bio;
		}catch(Exception e){
			By bioPath = By.xpath("/html/body/span/section/main/article/header/div[2]/div[2]/span/span");
			String bio = driver.findElement(bioPath).getText();
			return bio;		
		}
	}
	
	

	public WebElement getLogoutButton(WebDriver driver){
		element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/ul/li[4]/button"));
		return element;
	}

	

}
