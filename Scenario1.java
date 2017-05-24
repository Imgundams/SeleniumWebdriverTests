package testings;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario1 {

	static WebDriver driver;
	WebDriverWait wait;
	WebElement element;
	final String userName = "SuperRobot6";
	final String password = "CamelCase";

	
	// JUnit Testing
	
	
	@BeforeClass
	public static void loadBrowser() {

		System.out.println("Before Class...");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Before
	public void initalPageToTest() {
		System.out.println("Before test...");
		driver.navigate().to("https://www.blankmediagames.com/phpbb/ucp.php?mode=login");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// Assert main page login and verify main page signup
	@Test
	public void PageCheck() {
		System.out.println("Starting Page Assert test...");
		WebElement loginButton = driver.findElement(By.name("login"));
		WebElement signupButton = driver.findElement(By.xpath("//*[@id='page-header']/div[2]/div/ul[2]/li[3]/a"));
		WebElement signupButton2 = driver.findElement(By.xpath("//*[@id='login']/div[2]/div/div/p[3]/a"));
		WebElement usernameBox = driver.findElement(By.id("username"));
		WebElement passwordBox = driver.findElement(By.id("password"));
		Assert.assertTrue("Login Button is True ", loginButton.isDisplayed());
		Assert.assertTrue("Headder Reg link is True ", signupButton.isDisplayed());
		Assert.assertTrue("Register Button is True ", signupButton2.isDisplayed());
		Assert.assertTrue("Username Box is True ", usernameBox.isDisplayed());
		Assert.assertTrue("Password Box is True ", passwordBox.isDisplayed());
	}

	// Asserts Login page, logs in and asserts user control panel
	@Test
	public void loggingIn() {
		System.out.println("Starting Logging in test...");
		WebElement loginButton = driver.findElement(By.name("login"));
		WebElement usernameBox = driver.findElement(By.id("username"));
		WebElement passwordBox = driver.findElement(By.id("password"));
		Assert.assertTrue("Username Box is True ", usernameBox.isDisplayed());
		Assert.assertTrue("Password Box is True ", passwordBox.isDisplayed());
		Assert.assertTrue("Login Button is True ", loginButton.isDisplayed());
		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		loginButton.click();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		WebElement userControlPanel = driver.findElement(By.xpath("//*[@id='page-header']/div[2]/div/ul[2]/li/a[1]"));
		Assert.assertTrue("Logged in and User Control Panel is True ", userControlPanel.isDisplayed());
	}
	
	// Asserts Log out link and logs out and asserts login boxes
	@Test
	public void LoggingOut(){
		System.out.println("Starting Logging out test...");
		WebElement logoutLink = driver.findElement(By.xpath("//*[@id='page-header']/div[2]/div/ul[3]/li[3]/a"));
		Assert.assertTrue("Logout Link is True", logoutLink.isDisplayed());
		logoutLink.click();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().to("https://www.blankmediagames.com/phpbb/ucp.php?mode=login");
		WebElement usernameBox = driver.findElement(By.name("username"));
		WebElement passwordBox = driver.findElement(By.name("password"));
		Assert.assertTrue("Username Box is True ", usernameBox.isDisplayed());
		Assert.assertTrue("Password Box is True ", passwordBox.isDisplayed());
		System.out.println("Logged out.");
		
		}

	//Closes the system
	@AfterClass
	public static void closeBrowser() {
		System.out.println("Closing in 10 Seconds.");
		driver.quit();
		System.exit(0);
	}

}
