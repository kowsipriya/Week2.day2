package Week2.day2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("yes")).click();
		boolean radio_unchecked = driver
				.findElement(By.xpath("//label[text()='Find default selected radio button']//following::input[1]"))
				.isSelected();
		boolean radio_checked = driver
				.findElement(By.xpath("//label[text()='Find default selected radio button']//following::input[2]"))
				.isSelected();
		if (radio_checked = true) {
			System.out.println("Radio Button is Checked with the default selected value");
		} else if (radio_unchecked = true) {
			System.out.println("Radio Button is UnChecked with the default selected value");
		} else {
			System.out.println("The radio button not checked with Any value");
		}
		boolean selected1 = driver.findElement(By.xpath("(//div[@class='row'])[3]//input[1]")).isSelected();
		boolean selected2 = driver.findElement(By.xpath("(//div[@class='row'])[3]//input[2]")).isSelected();
		boolean selected3 = driver.findElement(By.xpath("(//div[@class='row'])[3]//input[3]")).isSelected();
		//Check the Buttons are Selected
		if (selected1 || selected2 || selected3 == true) {
			System.out.println("Already Those values is selected");
		} else {
			driver.findElement(By.xpath("(//div[@class='row'])[3]//input[1]")).click();
		}

	}

}
