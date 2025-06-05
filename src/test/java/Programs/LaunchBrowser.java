package Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LaunchBrowser {
	public static void main(String[] args) {
		
	//	WebDriverManager.chromedriver().setup(); // This is to open Chrome driver
		WebDriver driver = new EdgeDriver();  // here only we need to change the browser name 

		driver.get("https://devv.digitalcaampus.com/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait object we have created to wait
																				// until the page is load.
		driver.manage().window().maximize();

		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		usernameField.sendKeys("nacharam");

		WebElement passwordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		passwordField.sendKeys("1234567");

		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		driver.close();
	}
	
}
