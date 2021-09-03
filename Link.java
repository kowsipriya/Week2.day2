package Week2.day2;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;
	public class Link {
		public static void main(String[] args) {
			// Invoke of WebDriverManager
			WebDriverManager.chromedriver().setup();
			// Local browser Setup
			ChromeDriver driver = new ChromeDriver();
			// Maximizing the browser
			driver.manage().window().maximize();
			driver.get("http://leafground.com/pages/Link.html");
			// Implicit Wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Click on Homepage
			driver.findElement(By.xpath("// div[@class='example']//a[1]")).click();
			// Get the home page title
			String Homepage = "TestLeaf - Selenium Playground";
			String homeTitle = driver.getTitle();
			// Verifying the page navigation
			if (Homepage.equals(homeTitle)) {
				System.out.println("Successfully Homepage is opened");
			} else {
				System.out.println("Homepage is Not opened Successfully");
			}
			driver.navigate().back();
			driver.findElement(By.xpath("(//div[@class='example'])[2]//a[1]")).click();
			String buttonPage = "TestLeaf - Interact with Buttons";
			String buttonTitle = driver.getTitle();
			if (buttonPage.equals(buttonTitle)) {
				System.out.println("Successfully Button Page is opened");
			} else {
				System.out.println("Button Page is not Opened Successfully");
			}
			driver.navigate().back();
			driver.findElement(By.xpath("(//div[@class='example'])[3]//a[1]")).click();
			String brokenLink = "HTTP Status 404 – Not Found";
			String brokenPage = driver.getTitle();
			if (brokenLink.equals(brokenPage)) {
				System.out.println("Successfully broken page is opened");
			} else {
				System.out.println("Broken page is Not opened successfully");
			}
			driver.navigate().back();
			driver.findElement(By.xpath("(//div[@class='row'])[4]//a")).click();
			// Verifying the page navigation
			if (Homepage.equals(homeTitle)) {
				System.out.println("Successfully Homepage is opened");
			} else {
				System.out.println("Homepage is Not opened Successfully");
			}
			driver.navigate().back();
			driver.findElement(By.xpath("//a[text()='How many links are available in this page?']")).click();
			int size = driver.findElements(By.tagName("a")).size();
			
			System.out.println("The available links in the page are : "+ size);

		}

	}
