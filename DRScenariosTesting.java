package testings;

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

public class DRScenariosTesting {

	InstHome homePage;

		ExtentReports report;
		ExtentTest test;
		static WebDriver driver;
		WebDriverWait wait;
		WebElement element;
		final String userName = "SuperRobot6";
		final String userName2 = "SuperRobot.6";
		final String password = "CamelCase";

	@BeforeClass
	public void Initial() {
		System.out.println("Starting Script..");
		report = new ExtentReports("C:\\Users\\ewomack\\PicsHere\\automationreport.html", true);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
	}

	@Test(priority = 1, enabled = true)
	public void PHPBBTest() {
		//POM in one Class
		System.out.println("Starting Scenario 1 Test");
		test = report.startTest("Scenario 1: PHPBB (Online Forums) Testing Logging in and Logging Out");
		driver.navigate().to("https://www.blankmediagames.com/phpbb/ucp.php?mode=login");
		PHPBBPOM ppom = new PHPBBPOM();
		WebElement loginButton = ppom.getLoginButton(driver);
		
		if (loginButton.isDisplayed()) {
			test.log(LogStatus.PASS, "Log in Button Displayed");
		} else {
			test.log(LogStatus.FAIL, "Log in Button Not Displayed");
		}
		test.log(LogStatus.INFO,"Starting Page Assert test...");
		WebElement usernameBox = ppom.getUserNameBox(driver);
		WebElement passwordBox = ppom.getPasswordBox(driver);
		
		if (usernameBox.isDisplayed() && passwordBox.isDisplayed()) {
			test.log(LogStatus.PASS, "Username and Password Boxes Displayed");
		} else {
			test.log(LogStatus.FAIL, "Username and Password Boxes Not Displayed");
		}
		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		loginButton.click();
		test.log(LogStatus.INFO, "Logging in");

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement userControlPanel = ppom.getUserControlPanel(driver);
		if (userControlPanel.isDisplayed()) {
			test.log(LogStatus.PASS, "Successfully Logged in");
		} else {
			test.log(LogStatus.FAIL, "Unsuccessful in Logging in");
		}
		driver.navigate().to("https://www.blankmediagames.com/phpbb/ucp.php?mode=login");

		WebElement logoutLink = ppom.getLogoutLink(driver);
		if (logoutLink.isDisplayed()) {
			test.log(LogStatus.PASS, "Logout Link found");
		} else {
			test.log(LogStatus.FAIL, "Logout Link found ");
		}
		logoutLink.click();
		test.log(LogStatus.INFO, "Logging Out");

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().to("https://www.blankmediagames.com/phpbb/ucp.php?mode=login");
		usernameBox = ppom.getLoginButton(driver);
		if (usernameBox.isDisplayed()) {
			test.log(LogStatus.PASS, "Successfully Logged Out");
		} else {
			test.log(LogStatus.FAIL, "Unsucessful in  Logging Out");
		}
		report.endTest(test);
		System.out.println("Ending Scenario 1 Test");
	}

	@Test(priority = 2, enabled = true)
	public void InstagramTest1() {
		//POM in Multiple Classes
		System.out.println("Starting Scenario2 Test");
		test = report.startTest("Scenario 2: Instagram Logging in and Discovering and Following somebody and logging out");
		driver.navigate().to("https://www.instagram.com/");
		test.log(LogStatus.INFO, "Page Opened");
		InstHome hom = new InstHome();
		test.log(LogStatus.INFO, "Getting Texts");
		String title = hom.getTitle(driver);

		if (title.equals("Instagram")) {
			// report the test as a pass
			test.log(LogStatus.PASS, "Verifed title of the page");
		} else {
			test.log(LogStatus.FAIL, "Did not verify title of the page");
		}
	
		System.out.println("Starting Script..");

		driver.navigate().to("https://www.instagram.com/accounts/login/");
		test.log(LogStatus.INFO, "Browser Opened");
		InstLogin log = new InstLogin();
		// login code

		WebElement usernameBox = log.getUsernameBox(driver);
		WebElement passwordBox = log.getPasswordBox(driver);
		WebElement loginButton = log.getLoginButton(driver);
		test.log(LogStatus.INFO, "Checked Elements");
		usernameBox.sendKeys(userName2);
		passwordBox.sendKeys(password);
		loginButton.click();
		test.log(LogStatus.INFO, "Logging In");

		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

		driver.navigate().to("https://www.instagram.com/");
		InstHomeUser usrHom = new InstHomeUser();
		if (usrHom.getMyProfileButton(driver).isDisplayed()) {
			// report the test as a pass
			test.log(LogStatus.PASS, "Successfully Logged In");
		} else {
			test.log(LogStatus.FAIL, "Unsuccessful in Logging In");
		}

		test.log(LogStatus.INFO, "Testing Following The first Person on Discover");
		driver.navigate().to("https://www.instagram.com/superrobot.6/");
		test.log(LogStatus.INFO, "User Page Loaded");
		InstUser userPage = new InstUser();
		double followCount = (double) userPage.getFollowCount(driver);
		System.out.print(followCount);
		driver.navigate().to("https://www.instagram.com/explore/");
		test.log(LogStatus.INFO, "Explore Page Loaded");

		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

		InstExplo explore = new InstExplo();
		WebElement discoverFollow = explore.getFollow(driver);
		discoverFollow.click();
		test.log(LogStatus.INFO, "Followed Random Person");

		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

		driver.navigate().to("https://www.instagram.com/superrobot.6/");

		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

		InstUser userPage2 = new InstUser();
		double followCount2 = (double) userPage2.getFollowCount(driver);
		System.out.println(" new follow count is " + followCount2);
		if (followCount != followCount2) {
			test.log(LogStatus.PASS, "Successfully Followed Somebody");
		} else {
			test.log(LogStatus.FAIL, "Unsuccessful in Following Somebody");
		}
	
		driver.navigate().to("https://www.instagram.com/superrobot.6/");
		test.log(LogStatus.INFO, "User Page Loaded");

		InstUser userPage3 = new InstUser();
		WebElement cogButton = userPage3.getCogButton(driver);
		cogButton.click();
		WebElement logoutButton = userPage3.getLogoutButton(driver);
		logoutButton.click();
		test.log(LogStatus.INFO, "Logging Out");

		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

		InstHome ho = new InstHome();
		// Gets redirected to main page where log in button is verified
		if (ho.getLogin(driver).isDisplayed()) {
			test.log(LogStatus.PASS, "Successfully Logged Out");
		} else {
			test.log(LogStatus.FAIL, "Unsuccessful in Logging Out");
		}
		report.endTest(test);
		System.out.println("Ending Scenario 2 Test");
	}

	@Test(priority = 3, enabled = true)
	public void InstagramTest2(){
		//POM in Multiple Classes
		System.out.println("Starting Scenario 3 Test");
		test = report.startTest("Scenario 3: Instagram Logging In and Editing the Bio and Logging Out");
		driver.navigate().to("https://www.instagram.com/accounts/login/");
		test.log(LogStatus.INFO, "Page Opened");
		InstLogin iLog = new InstLogin();
		test.log(LogStatus.INFO, "Logging In");

		WebElement usernameBox = log.getUsernameBox(driver);
		WebElement passwordBox = log.getPasswordBox(driver);
		WebElement loginButton = log.getLoginButton(driver);
		test.log(LogStatus.INFO, "Checked Elements");
		usernameBox.sendKeys(userName2);
		passwordBox.sendKeys(password);
		loginButton.click();

		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

		driver.navigate().to("https://www.instagram.com/");
		InstHomeUser usrHom = new InstHomeUser();
		if (usrHom.getMyProfileButton(driver).isDisplayed()) {
			test.log(LogStatus.PASS, "Successfully Logged In");
		} else {
			test.log(LogStatus.FAIL, "Unsuccessful in Logging In");
		}

		driver.get("https://www.instagram.com/superrobot.6/");
		
		numtowords word = new numtowords();
		InstUser userP = new InstUser();

		
		WebElement editProfileButton = userP.getEditProfileButton(driver);
		editProfileButton.click();
		String bioWords = word.numToWords2((int)Math.floor(Math.random()*7));
		test.log(LogStatus.INFO, "Random Bio Generated");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		InstEditProf eProf = new InstEditProf();
		WebElement tweetButtonBox = eprof.getBioBox(driver);
		if (tweetButtonBox.isDisplayed()) {
			test.log(LogStatus.PASS, "Successfully Found Edit Box");
		} else {
			test.log(LogStatus.FAIL, "Unsuccessful Finding Edit Box");
		}
		tweetButtonBox.clear();
		tweetButtonBox.sendKeys(bioWords);
		WebElement submitProfileButton = eProf.getSubmitButton(driver);
		submitProfileButton.click();
		test.log(LogStatus.INFO, "Random Bio Submitted");

		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		
		driver.navigate().to("https://www.instagram.com/superrobot.6/");
		String bioWordsPosted = userP.getBioData(driver);

		if (bioWords == bioWordsPosted) {
			test.log(LogStatus.PASS, "Successfully Change Bio");
		} else {
			test.log(LogStatus.FAIL, "Unsuccessful in Changing Bio");
		}

		// Logout
		WebElement cogButton = userP.getCogButton(driver);
		cogButton.click();
		WebElement logoutButton = userP.getLogoutButton(driver);
		logoutButton.click();
		test.log(LogStatus.INFO, "Logged Out");

		TimeUnit.SECONDS.sleep(2);
		
		driver.navigate().to("https://www.instagram.com/");

		System.out.print("Looking for Main page Login button...");
		mainPageLoginCheck = 
		if (mainPageLogin.isDisplayed()) {
			test.log(LogStatus.PASS, "Successfully Logged Out");
		} else {
			test.log(LogStatus.FAIL, "Unsuccessful in Logging Out");
		}

		report.endTest(test);
		System.out.println("Ending Scenario 3 Test");
	}

	@Test(priority = 4, enabled = true)
	public void TwitterTest(){
		//POM in one class
		System.out.println("Starting Scenario 4 Test");
		test = report.startTest("Scenario 4: Twitter Logging In and Tweeting a Random Message and Logging Out");
		//						Opening Twitter
		driver.navigate().to("https://twitter.com/");
		test.log(LogStatus.INFO, "Page Opened");
		twitterPOM tpom = new twitterPOM();

		// 			Assert main page login and verify main page signup
		WebElement mainPageLogin = tpom.getMainPageLogin(driver);
		WebElement mainPageSignup = tpom.getMainPageSignup(driver);
		System.out.print("Looking for Main page Login button...");
		if (mainPageLogin.isDisplayed() && mainPageSignup.isDisplayed()) {
			test.log(LogStatus.PASS, "Main Page Loaded Successfully");
		} else {
			test.log(LogStatus.FAIL, "Unsuccessful in Loading Main Page");
		}
		// 						Login page Check
		driver.navigate().to("https://twitter.com/login");
		WebElement wholeLoginPage = tpom.getWholeLoginPage(driver);
		if (wholeLoginPage.isDisplayed()) {
			test.log(LogStatus.PASS, "Login Page Loaded Successfully");
		} else {
			test.log(LogStatus.FAIL, "Unsuccessful in Loading Login Page");
		}
		// 						Logging In
		WebElement usernameBox = tpom.getUsernameBox(driver);
		WebElement passwordBox = tpom.getPasswordBox(driver);
		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		wholeLoginPage.click();
		test.log(LogStatus.INFO, "Logging In");
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		//	 					Confirming Log In
		WebElement dropDown = new tpom.getDropdownButton(driver);
		if (dropDown.isDisplayed()) {
			test.log(LogStatus.PASS, "Login Successful");
		} else {
			test.log(LogStatus.FAIL, "Login Unsuccessful");
		}
		// 						Counting Tweets
		int tweeted = tpom.getTweetCount(driver);
		// 						Tweet a Random word
		numtowords word = new numtowords();
		WebElement preTweetButton = tpom.getPreTweetButton(driver);
		preTweetButton.click();
		WebElement tweetButtonBox = driver.findElement(By.id("tweet-box-global"));
		tweetButtonBox.sendKeys(word.numToWords((int) Math.floor(Math.random() * 13)));
		WebElement tweetButton = driver.findElement(By.xpath("//*[@id='global-tweet-dialog-dialog']/div[2]/div[4]/form/div[3]/div[2]/button/span[1]"));
		tweetButton.click();
		test.log(LogStatus.INFO, "Tweeted");
		try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		driver.navigate().to("https://twitter.com/");
		//						Checking if tweeted
		int tweeted2 = tpom.getTweetCount(driver);
		if (tweeted != tweeted2) {
			test.log(LogStatus.PASS, "Tweet Successful");
		} else {
			test.log(LogStatus.FAIL, "Tweet Unsuccessful");
		}

		//						Logout Normal
		WebElement dropDownMenu = tpom.getDropdownButton(driver);
		dropDownMenu.click();
		WebElement logoutDropdown = tpom.getLogoutDropdownButton(driver);
		logoutDropdown.click();
		//						Logout Easy
		//	driver.get("https://twitter.com/logout");
		//	WebElement logoutButton = tpom.getLogoutButton(driver);
		//	logoutButton.click();

		//						Logout Check
		driver.navigate().to("https://twitter.com/login");
		mainPageLogin = tpom.getMainPageLogin(driver);
		if (mainPageLogin.isDisplayed()) {
			test.log(LogStatus.PASS, "Logged Out Successfully");
		} else {
			test.log(LogStatus.FAIL, "Log Out Unsuccessful");
		}
		report.endTest(test);
		System.out.println("Ending Scenario 4 Test");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("Closing in 2 Seconds.");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
		report.flush();
		driver.quit();
		System.exit(0);
	}

}
