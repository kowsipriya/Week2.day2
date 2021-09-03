package Week2.day2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
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
		// 8. Click on Phone
		driver.findElement(By.xpath("(//span[@class=\"x-tab-strip-text \"])[2]")).click();
		// 9. Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("7");
		// 10. Click find leads button
		driver.findElement(By.xpath("(//button[@class=\"x-btn-text\"])[7]")).click();
		// Wait till the page get loaded
		Thread.sleep(2000);
		// 11. Capture lead ID of First Resulting lead
		String firstLead = driver.findElement(By.xpath("//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a"))
				.getText();
		// System.out.println(firstLead);
		// 12. Click First Resulting lead
		driver.findElement(By.xpath("(//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a)")).click();
		// 13. Click Delete
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		// 14. Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		// 15. Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(firstLead);
		// 16. Click find leads button
		driver.findElement(By.xpath("(//button[@class=\"x-btn-text\"])[7]")).click();
		// Wait till the page get loaded
		Thread.sleep(2000);
		// 17. Verify message "No records to display" in the Lead List. This message
		// confirms the successful deletion
		String pagingInfo = driver.findElement(By.xpath("//div[@class=\"x-paging-info\"]")).getText();
		// System.out.println(pagingInfo);
		if (pagingInfo.equals("No records to display"))
			System.out.println("The ID " + firstLead + " is successfully deleted");
		else
			System.out.println("The ID " + firstLead + " is still not deleted");
		// 18. Close the browser (Do not log out)
		driver.close();

	}

}
