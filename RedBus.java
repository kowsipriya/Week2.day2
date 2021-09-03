package Week2.day2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 1.Go to https://www.redbus.in/ in chrome
		driver.get("https://www.redbus.in/");
		// 2.Type Chennai in From textBox and ENTER
		WebElement source = driver.findElement(By.id("src"));
		source.sendKeys("Chennai", Keys.ENTER);
		// 3.Type Bengaluru in Destination textBox and ENTER
		// Thread.sleep(8000);
		WebElement destination_textBox = driver.findElement(By.id("dest"));
		destination_textBox.sendKeys("Bengaluru", Keys.ENTER);
		// Thread.sleep(8000);
		// 4.Choose any date in JULY
		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//tr[@class='rb-monthHeader']"));
		// Thread.sleep(8000);
		driver.findElement(By.xpath("//td[text()='5']")).click();
		Thread.sleep(8000);
		// 5.Click Search Buses
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		Thread.sleep(4000);
		// 6.Close the pop-up using the X button at the right corner
		driver.findElement(By.xpath("//div[@class='close']")).click();
		Thread.sleep(4000);
		// 7.Print the number of search results
		WebElement buses_Count = driver.findElement(By.xpath("//span[@class='f-bold busFound']"));
		System.out.println("The Total number of buses found is : " + buses_Count.getText());
		// 8.Choose only Sleeper Bus
		Thread.sleep(4000);
		WebElement busType = driver
				.findElement(By.xpath("//label[contains(text(),'SLEEPER')]//preceding-sibling::label"));
		busType.click();
		// 9.Print the number of search results
		Thread.sleep(4000);
		System.out.println("Total number of Sleeper buses available are : " + buses_Count.getText());
		// 10.Deselect the sleeper Bus and select the AC bus alone
		Thread.sleep(4000);
		busType.click();
		driver.findElement(By.xpath("//label[contains(text(),'AC')]//preceding-sibling::label")).click();
		// 11.Print the number of search results
		Thread.sleep(4000);
		System.out.println("Total number of AC buses available are : " + buses_Count.getText());
		// 12.Choose also Non AC buses
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[contains(text(),'NONAC')]//preceding-sibling::label")).click();
		// 13.Print the number of search results
		Thread.sleep(4000);
		System.out.println("Total number of AC and Non-AC buses available are : " + buses_Count.getText());

	}
}
