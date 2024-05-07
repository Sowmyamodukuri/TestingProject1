package mytest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program1 {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
	    driver=new ChromeDriver();
		driver.get("https://chatgpt.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test
	public void verifyTitle() {
		String actual=driver.getTitle();
		String expected="ChatGPT";
		Assert.assertEquals(actual, expected);
	}
	@Test 
	public void logo() {
		boolean logopresent=driver.findElement(By.xpath("//div[@class='h-7 w-7 flex-shrink-0']//div[@class='gizmo-shadow-stroke relative flex h-full items-center justify-center rounded-full bg-token-main-surface-primary text-token-text-primary']")).isDisplayed();
	    Assert.assertTrue(logopresent);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
