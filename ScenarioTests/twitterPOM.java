package ScenarioTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class twitterPOM {
	// Nullifies the element variable
	public WebElement element = null;

	// @ https://www.twitter.com/
	// Before Logging In

	public WebElement getMainPageLogin(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='doc']/div[1]/div/div[1]/div[2]/a[3]"));
		return element;
	}

	public WebElement getMainPageSignup(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='doc']/div[1]/div/div[1]/div[2]/a[2]"));
		return element;
	}
	
	public WebElement getMainPageLoginButton(WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id='login-dialog-dialog']/div[2]/div[2]/div[2]/form/input[1]"));
		return element;
	}


	// @ https://twitter.com/login
	// Before Logging In

	public WebElement getWholeLoginPage(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='page-container']/div/div[1]/form/div[2]/button"));
		return element;
	}

	public WebElement getUsernameBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='page-container']/div/div[1]/form/fieldset/div[1]/input"));
		return element;
	}

	public WebElement getPasswordBox(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='page-container']/div/div[1]/form/fieldset/div[2]/input"));
		return element;
	}


	// @ https://www.twitter.com/
	// After Logging In
	// User page

	public WebElement getPreTweetButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='global-new-tweet-button']/span[1]"));
		return element;
	}

	public WebElement getTweetBox(WebDriver driver) {
		element = driver.findElement(By.id("tweet-box-global"));
		return element;
	}

	public WebElement getTweetSubmit(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='global-tweet-dialog-dialog']/div[2]/div[4]/form/div[3]/div[2]/button/span[1]"));
		return element;
	}
	
	public int getTweetCount(WebDriver driver) {
		By tweetCount= By.xpath("//*[@id='page-container']/div[1]/div[1]/div/div[2]/ul/li[1]/a/span[2]");
		int followers = Integer.parseInt(driver.findElement(tweetCount).getText());
		return followers;
	}

	public WebElement getDropdownButton(WebDriver driver) {
		element = driver.findElement(By.id("user-dropdown"));
		return element;
	}

	public WebElement getLogoutDropdownButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='signout-button']/button"));
		return element;
	}

	// @ https://twitter.com/logout
	// After Logging In
	// Aternative to dropdown logout


	public WebElement getLogoutButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='page-container']/div/div/form/div[2]/button"));
		return element;
	}

}
