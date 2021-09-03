package Week2.day2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_DropDowns {
	public static void main(String[] args) {
		// Invoke of WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Local browser Setup
		ChromeDriver driver = new ChromeDriver();
		// Maximizing the browser
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement dropdownIndex = driver.findElement(By.id("dropdown1"));
		Select FindIndex = new Select(dropdownIndex);
		FindIndex.selectByIndex(1);
		String firstSelectedOption = FindIndex.getFirstSelectedOption().getText();
		String selectIndex = "Selenium";
		if (selectIndex.equals(firstSelectedOption)) {
			System.out.println("Index Selected");
		} else {
			System.out.println("Index Not Selected");
		}
		WebElement dropdownText = driver.findElement(By.name("dropdown2"));
		Select FindText = new Select(dropdownText);
		FindText.selectByVisibleText("UFT/QTP");
		String selectText = FindText.getFirstSelectedOption().getText();
		String selectTextval = "UFT/QTP";
		if (selectText.equals(selectTextval)) {
			System.out.println("!Text is Selected!");
		} else {
			System.out.println("oops!Text is Not Selected!");
		}
		WebElement dropdownValue = driver.findElement(By.id("dropdown3"));
		Select FindValue = new Select(dropdownValue);
		FindValue.selectByValue("2");
		String textValue = FindValue.getFirstSelectedOption().getText();
		String selectedValue = "Appium";
		if (selectedValue.equals(textValue)) {
			System.out.println("Value is Selected");
		} else {
			System.out.println("oops Value is Not Selected");
		}
		WebElement dropdownCount = driver.findElement(By.className("dropdown"));
		Select drpdownCount = new Select(dropdownCount);
		int lastIndexOf = drpdownCount.getOptions().size();
		int listCount = 5;
		if (lastIndexOf == listCount) {
			System.out.println("Option Size is Equal to Index");
		} else {
			System.out.println("option size is Not Comes");
		}
		WebElement value = driver.findElement(By.xpath("(//div[@class='example'])[5]//select"));
		value.sendKeys("Loadrunner");
		WebElement findElement = driver.findElement(By.xpath("(//div[@class='example'])[6]//select"));
		Select multipleSelect = new Select(findElement);
		multipleSelect.selectByIndex(2);

	}

}
