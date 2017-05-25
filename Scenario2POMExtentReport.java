package testings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Scenario2POMExtentReport {

	InstHome homePage;

	ExtentReports report;
	ExtentTest test;
	static WebDriver driver;
	WebDriverWait wait;
	WebElement element;
	final String userName = "SuperRobot.6";
	final String password = "CamelCase";
	
	@BeforeTest
	public void Initial(){
		System.out.println("Starting Script..");
		report = new ExtentReports("C:\\Users\\ewomack\\PicsHere\\automationreport.html", true);
		test = report.startTest("Verifying Instagram Page Title and Copyright");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		
	}

	@Test(priority = 1, enabled = true)
	public void CheckTitle() {
		test.log(LogStatus.INFO, "Browser Opened");
		driver.navigate().to("https://www.instagram.com/");
	//	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		InstHome hom = new InstHome();
		test.log(LogStatus.INFO, "Getting Texts");
		String title = hom.getTitle(driver);
		String cpInfo = hom.getCopyright(driver);
		
		if ((title.equals(
				"Instagram" )&& (cpInfo.equals("© 2017 Instagram")))) {
			// report the test as a pass
			test.log(LogStatus.PASS, "verify Title and Copyright of the page");
		} else {
			test.log(LogStatus.FAIL, "verify Title and Copyright of the page");
		}
		
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority = 2, enabled = true)
	public void CheckCPInfo() {
		System.out.println("Starting Script..");
		test = report.startTest("Testing Logging In");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		test.log(LogStatus.INFO, "Browser Opened");
		driver.navigate().to("https://www.instagram.com/accounts/login/");
		InstLogin log = new InstLogin();
		// login code
		WebElement usernameBox = log.getUsernameBox(driver);
		WebElement passwordBox = log.getPasswordBox(driver);
		WebElement loginButton = log.getLoginButton(driver);
		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		loginButton.click();
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e3) {e3.printStackTrace();}
		test.log(LogStatus.INFO, "Logged In");
		driver.navigate().to("https://www.instagram.com/");
		InstHomeUser usrHom = new InstHomeUser();
		if (usrHom.getMyProfileButton(driver).isDisplayed()) {
			// report the test as a pass
			test.log(LogStatus.PASS, "Logged In");
		} else {
			test.log(LogStatus.FAIL, "Logged In");
		}
		System.out.println("Logged in.");
		report.endTest(test);
		report.flush();
		driver.quit();
		System.exit(0);
	}
	/*@Test
	public void assertMainPage() {
		driver.navigate().to("https://www.instagram.com/accounts/logout");
		System.out.println("Starting test, asserting Main Page...");
		// Assert main page login and verify main page signup
		InstHome hom = new InstHome();
		System.out.print("Looking for Main page Login button...");
		WebElement mainPageLogin = hom.getLogin(driver);
		Assert.assertTrue("Asserted Login", mainPageLogin.isDisplayed());

		System.out.print("Looking for Main page Signup button...");
		WebElement mainPageSignup = hom.getSignUp(driver);
		Assert.assertTrue("Asserted Signup Link", mainPageSignup.isDisplayed());

	}

	@Test
	public void assertLoginPage() {
		driver.navigate().to("https://www.instagram.com/accounts/logout");
		System.out.println("Starting test, asserting Login Page...");
		// Assert login page
		driver.navigate().to("https://www.instagram.com/accounts/login/");
		InstLogin log = new InstLogin();
		System.out.print("Looking for Login page...");
		WebElement loginPageLoginButton = log.getLoginButton(driver);
		Assert.assertTrue("Asserted Login Button ", loginPageLoginButton.isDisplayed());

	}

	@Test
	public void loginAndCheck() {
		driver.navigate().to("https://www.instagram.com/accounts/logout");
		System.out.println("Starting test, asserting Login Page...");
		driver.navigate().to("https://www.instagram.com/accounts/login/");
		InstLogin log2 = new InstLogin();
		// login code
		WebElement usernameBox = log2.getUsernameBox(driver);
		WebElement passwordBox = log2.getPasswordBox(driver);
		WebElement loginButton = log2.getLoginButton(driver);
		Assert.assertTrue("Asserted Login Button ", loginButton.isDisplayed());
		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		loginButton.click();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e3) {
			e3.printStackTrace();
		}

		driver.navigate().to("https://www.instagram.com/accounts/login/");
		System.out.println("Asserting if Logged in.");
		InstHomeUser home = new InstHomeUser();
		WebElement userButton = home.getMyProfileButton(driver);
		Assert.assertTrue("Asserted User Button ", userButton.isDisplayed());
		System.out.println("Login Check Test Complete.");

	}

	// Follow first result on Discover on instagram
	@Test
	public void followFirstResult() {

		System.out.println("Starting test, following first result and asserting increase in following count...");
		driver.navigate().to("https://www.instagram.com/superrobot.6/");
		InstUser userPage = new InstUser();
		double followCount = (double) userPage.getFollowCount(driver);
		System.out.print(followCount);
		driver.navigate().to("https://www.instagram.com/explore/");

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		InstExplo explore = new InstExplo();
		WebElement discoverFollow = explore.getFollow(driver);
		Assert.assertTrue("Asserted follow Button ", discoverFollow.isDisplayed());
		discoverFollow.click();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.navigate().to("https://www.instagram.com/superrobot.6/");
		InstUser userPage2 = new InstUser();
		double followCount2 = (double) userPage2.getFollowCount(driver);
		System.out.println(" new follow count is " + followCount2);
		Assert.assertNotEquals("Follow Count is ", followCount, followCount2);
		System.out.println("Successfully Followed First Result...");

		// Delete after
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Ending test ");
	}

	@Test
	public void changeBio() {
		// Change Bio To some quote
		driver.navigate().to("https://www.instagram.com/superrobot.6/");

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}

		numtowords word = new numtowords();
		InstUser userPage = new InstUser();

		WebElement editProfileButton = userPage.getEditProfileButton(driver);
		editProfileButton.click();

		InstEditProf editP = new InstEditProf();

		WebElement tweetButtonBox = editP.getBioBox(driver);
		tweetButtonBox.clear();
		String wrds = (word.numToWords((int) Math.floor(Math.random() * 13)));
		tweetButtonBox.sendKeys(wrds);

		WebElement submitProfileButton = editP.getSubmitButton(driver);
		submitProfileButton.click();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		driver.navigate().to("https://www.instagram.com/superrobot.6/");
		String wrds2 = userPage.getBioData(driver);
		System.out.println("Checking if Bio is changed \n" + wrds + "\n" + wrds2);
		Assert.assertEquals("BioData Changed is ", wrds, wrds2);
		// Logout

		WebElement cogButton = userPage.getCogButton(driver);
		cogButton.click();
		WebElement logoutButton = userPage.getLogoutButton(driver);
		logoutButton.click();

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Ending test ");
	}

	@After
	public void logouter() {
		driver.navigate().to("https://www.instagram.com/accounts/logout");

	}
*/
	@AfterClass
	public static void closeBrowser() {
		System.out.println("Closing in 10 Seconds.");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
		System.exit(0);
	}

}
