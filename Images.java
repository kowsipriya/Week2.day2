package Week2.day2;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Images {

	public static void main(String[] args) {
		// Invoke of WebDriverManager
		WebDriverManager.chromedriver().setup();
		// Local browser Setup
		ChromeDriver driver = new ChromeDriver();
		// Maximizing the browser
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Image.html");
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='row']//img")).click();
		// Get the home page title
		String Homepage_Title = "TestLeaf - Selenium Playground";
		String HomeTitle = driver.getTitle();
		// Verifying the page navigation
		if (Homepage_Title.equals(HomeTitle)) {
			System.out.println("Homepage opened Successfully");
		} else {
			System.out.println("oops! Homepage Not opened");
		}
		driver.navigate().back();
		driver.findElement(By.xpath("(//div[@class='row'])[2]//img")).click();
	}

}