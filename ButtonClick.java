package Week2.day2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonClick {

	public static void main(String[] args) {
		// Invoke a WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Local browser Setup
		ChromeDriver driver = new ChromeDriver();
		// Maximizing the browser
		driver.manage().window().maximize();
		// URL
		driver.get("http://leafground.com/pages/Button.html");
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Click on Homepage Button
		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
		// Get the home page title
		String Homepage_Title = "TestLeaf - Selenium Playground";
		String homeTitle = driver.getTitle();
		// Verify the page navigation
		if (Homepage_Title.equals(homeTitle)) {
			System.out.println("Successfully Navigate into Homepage on click of Go to Home Page Button");
		} else {
			System.out.println("Sorry not Navigate into Homepage on click of Go to Home Page Button");
		}
		// ReDirecting to previous page
		driver.navigate().back();
		Point location = driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation();
		System.out.println("The position of button (x,y) is : " + location);

		String backgroundColor = driver.findElement(By.xpath("//button[text()='What color am I?']"))
				.getCssValue("background-color");
		System.out.println("The button color is : " + backgroundColor);

		Dimension buttonDimension = driver.findElement(By.xpath("//button[@id='size']")).getSize();
		System.out.println("The height and width : " + buttonDimension);
	}

}
