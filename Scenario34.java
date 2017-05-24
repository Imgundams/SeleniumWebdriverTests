package testings;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario34 {

	static WebDriver driver;
	WebDriverWait wait;
	WebElement element;
	final String userName = "SuperRobot6";
	final String password = "pascalCase";

	@BeforeClass
	public static void loadBrowser() {

		System.out.println("Before Class...");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://twitter.com/");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Test
	public void loggingIn() {

		try {
			System.out.println("Starting test...");
			// Assert main page login and verify main page signup
			WebElement mainPageLogin = driver.findElement(By.xpath("//*[@id='doc']/div[1]/div/div[1]/div[2]/a[3]"));
			WebElement mainPageSignup = driver.findElement(By.xpath("//*[@id='doc']/div[1]/div/div[1]/div[2]/a[2]"));

			System.out.print("Looking for Main page Login button...");
			boolean mainPageLoginCheck = mainPageLogin.isDisplayed();
			if (mainPageLoginCheck == true) {
				System.out.println("Button Load Passed");
			} else {
				System.out.println("Button Load Failed");
				throw new Exception();
			}

			System.out.print("Looking for Main page Signup button...");
			boolean mainPageSignupCheck = mainPageSignup.isDisplayed();
			if (mainPageSignupCheck == true) {
				System.out.println("Button Load Passed");
			} else {
				System.out.println("Button Load Failed");
			}

			// Assert login page
			driver.get("https://twitter.com/login");
			System.out.print("Looking for Login page...");
			WebElement wholeLoginPage = driver.findElement(By.xpath("//*[@id='page-container']/div/div[1]/form/div[2]/button"));
			boolean loginPageCheck = wholeLoginPage.isDisplayed();
			if (loginPageCheck == true) {
				System.out.println("Page Load Passed");
			} else {
				System.out.println("Page Load Failed");
				throw new Exception();
			}
			// login code
			WebElement usernameBox = driver.findElement(By.xpath("//*[@id='page-container']/div/div[1]/form/fieldset/div[1]/input"));
			WebElement passwordBox = driver.findElement(By.xpath("//*[@id='page-container']/div/div[1]/form/fieldset/div[2]/input"));
			usernameBox.sendKeys(userName);
			passwordBox.sendKeys(password);
			wholeLoginPage.click();

			// Tweet a Random word
			numtowords word = new numtowords();
			WebElement preTweetButton = driver.findElement(By.xpath("//*[@id='global-new-tweet-button']/span[1]"));
			preTweetButton.click();
			WebElement tweetButtonBox = driver.findElement(By.id("tweet-box-global"));
			tweetButtonBox.sendKeys(word.numToWords((int) Math.floor(Math.random() * 13)));
			WebElement tweetButton = driver.findElement(By.xpath("//*[@id='global-tweet-dialog-dialog']/div[2]/div[4]/form/div[3]/div[2]/button/span[1]"));
			tweetButton.click();

			TimeUnit.SECONDS.sleep(2);

			// Logout
			driver.get("https://twitter.com/logout");
			WebElement logoutButton = driver.findElement(By.xpath("//*[@id='page-container']/div/div/form/div[2]/button"));
			logoutButton.click();
		
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Ending test ");
	}

	@AfterClass
	public static void closeBrowser() {
		System.out.println("Closing in 10 Seconds.");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
		System.exit(0);
	}

}
