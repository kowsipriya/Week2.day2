package Week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxs {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String[] Knownlanguages = { "Java", "SQL", "C++", "kowsalya" };
		for (int i = 0; i < Knownlanguages.length; i++) {
			if (Knownlanguages[i] == "Java") {
				driver.findElement(By.xpath("(//input)[1]")).click();
				System.out.println(Knownlanguages[i] + " is selected as known Language");
			} else if (Knownlanguages[i] == "VB") {
				driver.findElement(By.xpath("(//input)[2]")).click();
				System.out.println(Knownlanguages[i] + " is selected as known Language");
			} else if (Knownlanguages[i] == "SQL") {
				driver.findElement(By.xpath("(//input)[3]")).click();
				System.out.println(Knownlanguages[i] + " is selected as known Language");
			} else if (Knownlanguages[i] == "C++") {
				driver.findElement(By.xpath("(//input)[4]")).click();
				System.out.println(Knownlanguages[i] + " is selected as known Language");
			} else if (Knownlanguages[i] == "C") {
				driver.findElement(By.xpath("(//input)[5]")).click();
				System.out.println(Knownlanguages[i] + " is selected as known Language");
			} else {
				System.out.println("The  Given values are not listed in the language List");
			}
		}
		boolean seleniumSelect = driver
				.findElement(By.xpath("//label[text()='Confirm Selenium is checked']//following::input")).isSelected();
		if (seleniumSelect = true) {
			System.out.println("Selenium is checked");
		} else {
			System.out.println("Selenium is not checked");
		}
		WebElement checkval1 = driver
				.findElement(By.xpath("//label[text()='DeSelect only checked']//following::input[1]"));
		WebElement checkval2 = driver
				.findElement(By.xpath("//label[text()='DeSelect only checked']//following::input[2]"));
		if (checkval1.isSelected() == true) {
			checkval1.click();
			System.out.println("The selected value is unchecked");
		} else if (checkval2.isSelected() == true) {
			checkval2.click();
			System.out.println("The selected value is unchecked");
		}
		List<WebElement> SelectAllCheckboxes = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::input"));
		int size = SelectAllCheckboxes.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			SelectAllCheckboxes.get(i).click();
		}
	}

}
