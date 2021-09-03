package Week2.day2;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import io.github.bonigarcia.wdm.WebDriverManager;
	public class CreateContact {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
			driver.get("http://leaftaps.com/opentaps/control/login");
			// 2. Enter UserName and Password Using Id Locator
			driver.findElement(By.id("username")).sendKeys("demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			// 3. Click on Login Button using Class Locator
			driver.findElement(By.className("decorativeSubmit")).click();
			// 4. Click on CRM/SFA Link
			driver.findElement(By.partialLinkText("/SFA")).click();
			// 5. Click on contacts Button
			driver.findElement(By.linkText("Contacts")).click();
			// 6. Click on Create Contact
			driver.findElement(By.linkText("Create Contact")).click();
			// 7. Enter FirstName Field Using id Locator
			driver.findElement(By.id("firstNameField")).sendKeys("PriyaShankar");
			// 8. Enter LastName Field Using id Locator
			driver.findElement(By.id("lastNameField")).sendKeys("Raj");
			// 9. Enter FirstName(Local) Field Using id Locator
			driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("ToM");
			// 10. Enter LastName(Local) Field Using id Locator
			driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Roaster");
			// 11. Enter Department Field Using any Locator of Your Choice
			driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Information and Technology");
			// 12. Enter Description Field Using any Locator of your choice
			driver.findElement(By.id("createContactForm_description")).sendKeys("HEllo....,Whats up! this is for sample");
			// 13. Enter your email in the E-mail address Field using the locator of your choice
			driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("Tom123@gmail.com");
			// 14. Select State/Province as NewYork Using Visible Text
			WebElement statename = driver.findElement(By.name("generalStateProvinceGeoId"));
			Select province=new Select(statename);
			province.selectByVisibleText("New York");
			// 15. Click on Create Contact
			driver.findElement(By.name("submitButton")).click();
			// 16. Click on edit button
			driver.findElement(By.linkText("Edit")).click();
			// 17. Clear the Description Field using .clear
			driver.findElement(By.id("updateContactForm_description")).clear();
			// 18. Fill ImportantNote Field with Any text
			driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Hai, Your are having a Red Alert For this contact");
			// 19. Click on update button using Xpath locator
			driver.findElement(By.xpath("//textarea[@name='importantNote']//following::input")).click();
			// 20. Get the Title of Resulting Page.
			System.out.println("The Title of the Resulting page is : "+driver.getTitle());
		}

	}

