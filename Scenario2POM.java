package testings;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testings.InstHome;

public class Scenario2POM {

	InstHome homePage;

	static WebDriver driver;
	WebDriverWait wait;
	WebElement element;
	final String userName = "SuperRobot.6";
	final String password = "CamelCase";

	@BeforeClass
	public static void loadBrowser() {

		System.out.println("Before Class...");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		
		driver.navigate().to("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void assertMainPage() {
		System.out.println("Starting test, asserting Main Page...");
		// Assert main page login and verify main page signup
		InstHome hom = new InstHome(driver);
		System.out.print("Looking for Main page Login button...");
		WebElement mainPageLogin = hom.getLogin();
		Assert.assertTrue("Asserted Login", mainPageLogin.isDisplayed());   

		System.out.print("Looking for Main page Signup button...");
		WebElement mainPageSignup = hom.getSignUp();
		Assert.assertTrue("Asserted Signup Link", mainPageSignup.isDisplayed());
	}
	
	
	@Test
	public void assertLoginPage() {	
		System.out.println("Starting test, asserting Login Page...");
		// Assert login page
		driver.navigate().to("https://www.instagram.com/accounts/login/");
		InstLogin log = new InstLogin(driver);
		System.out.print("Looking for Login page...");
		WebElement loginPageLoginButton = log.getLoginButton();
		Assert.assertTrue("Asserted Login Button ", loginPageLoginButton.isDisplayed());
	}
	
	@Test
	public void loginAndCheck(){
		System.out.println("Starting test, asserting Login Page...");
		driver.navigate().to("https://www.instagram.com/accounts/login/");
		InstLogin log = new InstLogin(driver);
		// login code
		WebElement usernameBox = log.getUsernameBox();
		WebElement passwordBox = log.getPasswordBox();
		WebElement loginButton = log.getLoginButton();
		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		loginButton.click();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e3) {
			e3.printStackTrace();
		}

		// Follow first result on Discover on instagram

		driver.navigate().to("https://www.instagram.com/explore/");
		WebElement discoverFollow = driver
				.findElement(By.xpath("//*[@id='react-root']/section/main/div/ul/li[2]/div/div[1]/div[2]/span/button"));
		if (discoverFollow.isDisplayed()) {
			discoverFollow.click();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			WebElement discoverFollow2 = driver.findElement(
					By.xpath("//*[@id='react-root']/section/main/section/ul/li[2]/div/div[1]/div[2]/span/button"));
			if (discoverFollow2.isDisplayed()) {
				discoverFollow2.click();
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else
				System.out.println("Failed to find somebody to follow.");

		}

		// Change Bio To some quote
		driver.get("https://www.instagram.com/superrobot.6/");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}

		numtowords word = new numtowords();

		WebElement editProfileButton = driver
				.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/a/span/button"));
		editProfileButton.click();
		WebElement tweetButtonBox = driver.findElement(By.id("pepBio"));
		tweetButtonBox.clear();
		tweetButtonBox.sendKeys(word.numToWords((int) Math.floor(Math.random() * 13)));

		WebElement submitProfileButton = driver.findElement(
				By.xpath("//*[@id='react-root']/section/main/div/article/form/div[10]/div/div/span/button"));
		submitProfileButton.click();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		// Logout
		driver.navigate().to("https://www.instagram.com/superrobot.6/");

		WebElement cogButton = driver
				.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/div/button"));
		if (cogButton.isDisplayed()) {

			cogButton.click();
			WebElement logoutButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/ul/li[4]/button"));
			logoutButton.click();
		} else {
			WebElement cogButton2 = driver
					.findElement(By.xpath("//*[@id='react-root']/section/nav[1]/div/header/div[2]/button/div"));
			cogButton2.click();
			WebElement logoutButton2 = driver.findElement(
					By.xpath("//*[@id='react-root']/section/nav[1]/div/section/div[3]/div/div[4]/div/div/a/div[1]"));
			logoutButton2.click();
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
