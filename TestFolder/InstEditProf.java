package testings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InstEditProf {
	// https://www.instagram.com/accounts/edit/

	public WebElement element = null;
	

	public WebElement getBioBox(WebDriver driver) {
		element = driver.findElement(By.id("pepBio"));
		return element;
	}

	public WebElement getSubmitButton(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//*[@id='react-root']/section/main/div/article/form/div[10]/div/div/span/button"));
		return element;
	}

}
