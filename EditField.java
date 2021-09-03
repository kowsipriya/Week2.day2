package Week2.day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditField {

	public static void main(String[] args) {
		//Invoke of WebDriverManager
		WebDriverManager.chromedriver().setup();
		//Local browser Setup
		ChromeDriver driver=new ChromeDriver();
		//Maximizing the browser
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Edit.html");
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("kowsalya");
		WebElement Field = driver.findElement(By.xpath("(//div[@class='row'])[2]//input"));
		Field.sendKeys("Kowsalya");
		Field.sendKeys(Keys.TAB);
		String attribute = driver.findElement(By.xpath("(//div[@class='row'])[3]//input")).getAttribute("value");
		System.out.println("The attribute value is : "+attribute);
		driver.findElement(By.xpath("(//div[@class='row'])[4]//input")).clear();
		boolean enabled = driver.findElement(By.xpath("(//div[@class='row'])[5]//input")).isEnabled();
		if(enabled!=true) {
			System.out.println("The Edit Field is disabled");
		}
		else {
			System.out.println("The Edit Field is not disabled");
		}		
	}
}