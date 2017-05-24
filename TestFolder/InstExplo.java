package testings;

	import java.util.concurrent.TimeUnit;

	import org.junit.*;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	//https://www.instagram.com/explore/
	public class InstExplo {



		static WebDriver driver;
		WebDriverWait wait;
		WebElement element;


		@BeforeClass
		public static void loadBrowser() {

			System.out.println("Before Class...");

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}

	
	
	
	
	
}
