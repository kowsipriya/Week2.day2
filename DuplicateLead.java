package Week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/main");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 2. Enter UserName "demosalesmanager"
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		// 3. Enter Password "crmsfa" Using Id Locator
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// 4. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		// 5. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		// 6. Click Leads Link
		driver.findElement(By.linkText("Leads")).click();
		// 7. Click Find Leads
		driver.findElement(By.linkText("Find Leads")).click();
		// 8. Click on Email
		driver.findElement(By.xpath("(//span[@class=\"x-tab-strip-text \"])[3]")).click();
		// 9. Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys("@g");
		// 10. Click find leads button
		driver.findElement(By.xpath("(//button[@class=\"x-btn-text\"])[7]")).click();

		// Wait till the page get loaded
		Thread.sleep(2000);
		// 11. Capture name of First Resulting lead
		String firstLeadName = driver
				.findElement(By.xpath("//div[@class=\"x-grid3-cell-inner x-grid3-col-firstName\"]/a")).getText();
		// 12. Click First Resulting lead
		driver.findElement(By.xpath("//div[@class=\"x-grid3-cell-inner x-grid3-col-firstName\"]/a")).click();
		// 13. Click Duplicate Lead
		driver.findElement(By.xpath("(//a[@class=\"subMenuButton\"])[1]")).click();
		// 14. Verify the title as 'Duplicate Lead'
		String dupLeadTitle = driver.getTitle();
		if (dupLeadTitle.contains("Duplicate Lead"))
			System.out.println("The page contains Duplicate Lead");
		else
			System.out.println("The page is not Duplicate Lead");
		// 15. Click Create Lead
		driver.findElement(By.className("smallSubmit")).click();
		// 16. Confirm the duplicated lead name is same as captured name
		String dupFirstLeadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if (firstLeadName.equals(dupFirstLeadName))
			System.out.println("Original Lead Name is same as duplicated name");
		else
			System.out.println("Original Lead Name is same as duplicated name");
		driver.close();

	}
}
