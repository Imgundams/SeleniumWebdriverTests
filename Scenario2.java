package testings;

	import java.util.concurrent.TimeUnit;

	import org.junit.*;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	
public class Scenario2 {
	


		static WebDriver driver;
		WebDriverWait wait;
		WebElement element;
		final String userName = "SuperRobot.6";
		final String password = "CamelCase";

		@BeforeClass
		public static void loadBrowser() {

			System.out.println("Before Class...");

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.navigate().to("https://www.instagram.com/");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}

		@Test
		public void loggingIn() {

			try {
				System.out.println("Starting test...");
				// Assert main page login and verify main page signup
				WebElement mainPageLogin = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/div/div[2]/p/a"));
				WebElement mainPageSignup = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/div/div[1]/div/form/div[6]/span/button"));
				
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
				driver.navigate().to("https://www.instagram.com/accounts/login/");
				System.out.print("Looking for Login page...");
				WebElement loginPageLoginButton = driver.findElement(By.xpath("//*[@id='react-root']/section/main/div/article/div/div[1]/div/form/span/button"));
				boolean loginPageCheck = loginPageLoginButton.isDisplayed();
				if (loginPageCheck == true) {
					System.out.println("Page Load Passed");
				} else {
					System.out.println("Page Load Failed");
					throw new Exception();
				}
				// login code
				WebElement usernameBox = driver.findElement(By.name("username"));
				WebElement passwordBox = driver.findElement(By.name("password"));
				usernameBox.sendKeys(userName);
				passwordBox.sendKeys(password);
				loginPageLoginButton.click();
				TimeUnit.SECONDS.sleep(2);

				// Follow first result on Discover on instagram
				
				driver.navigate().to("https://www.instagram.com/explore/");
				WebElement discoverFollow = driver.findElement(By.xpath("//*[@id='react-root']/section/main/div/ul/li[2]/div/div[1]/div[2]/span/button"));
				if (discoverFollow.isDisplayed()){
					discoverFollow.click();
					TimeUnit.SECONDS.sleep(2);
					}
				else{
					WebElement discoverFollow2 = driver.findElement(By.xpath("//*[@id='react-root']/section/main/section/ul/li[2]/div/div[1]/div[2]/span/button"));
					if(discoverFollow2.isDisplayed()){
					discoverFollow2.click();
					TimeUnit.SECONDS.sleep(2);
					}else
						System.out.println("Failed to find somebody to follow.");
						
					}
				
				// Change Bio To some quote
				driver.get("https://www.instagram.com/superrobot.6/");
				TimeUnit.SECONDS.sleep(2);
				
				numtowords word = new numtowords();
				
				WebElement editProfileButton = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/a/span/button"));
				editProfileButton.click();
				WebElement tweetButtonBox = driver.findElement(By.id("pepBio"));
				tweetButtonBox.clear();
				tweetButtonBox.sendKeys(word.numToWords((int)Math.floor(Math.random()*13)));
				
				WebElement submitProfileButton = driver.findElement(By.xpath("//*[@id='react-root']/section/main/div/article/form/div[10]/div/div/span/button"));
				submitProfileButton.click();
				TimeUnit.SECONDS.sleep(2);
				
				// Logout
				driver.navigate().to("https://www.instagram.com/superrobot.6/");
				
				WebElement cogButton = driver.findElement(By.xpath("//*[@id='react-root']/section/main/article/header/div[2]/div[1]/div/button"));
				if(cogButton.isDisplayed()){			
					
					cogButton.click();
					WebElement logoutButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/ul/li[4]/button"));
					logoutButton.click();
				}
				else{
					WebElement cogButton2 = driver.findElement(By.xpath("//*[@id='react-root']/section/nav[1]/div/header/div[2]/button/div"));
					cogButton2.click();
					WebElement logoutButton2 = driver.findElement(By.xpath("//*[@id='react-root']/section/nav[1]/div/section/div[3]/div/div[4]/div/div/a/div[1]"));
					logoutButton2.click();
				}
				TimeUnit.SECONDS.sleep(2);
				
				
				
				driver.navigate().to("https://www.instagram.com/");

				System.out.print("Looking for Main page Login button...");
				mainPageLoginCheck = mainPageLogin.isDisplayed();
				if (mainPageLoginCheck == true) {
					System.out.println("Button Load Passed");
				} else {
					System.out.println("Button Load Failed");
					throw new Exception();
				}
				
				

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
