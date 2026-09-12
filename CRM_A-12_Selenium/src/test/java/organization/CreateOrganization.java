package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

// Field names (accountname, industry, accounttype, rating, annualrevenue,
// etc.) follow vtiger's standard Accounts/Organizations module schema and
// the same locator conventions as contact.CreateContactText and
// oppourtunities.AddNewoppourtunities. Test data taken directly from
// "Organization test case.xlsx". Unverified against a running instance —
// see CLAUDE.md: don't treat this as working until it's been run.
public class CreateOrganization
{
	public static void main(String[] args) throws InterruptedException
	{
		//open browser
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		//Login
			driver.get("http://localhost:8888/");

			WebElement username = driver.findElement(By.name("user_name"));
			username.sendKeys("admin");
			WebElement password = driver.findElement(By.name("user_password"));
			password.sendKeys("manager");

			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(3000);

		//Create_Organization
			driver.findElement(By.linkText("Organizations")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("img[alt='Create Organization....']")).click();
			Thread.sleep(2000);

		//filling data to the form
			WebElement organizationNameField = driver.findElement(By.name("accountname"));
			String organizationName = "Automation In";
			organizationNameField.sendKeys(organizationName);

			driver.findElement(By.name("website")).sendKeys("www.samplesite.com");
			driver.findElement(By.name("employees")).sendKeys("23");

			new Select(driver.findElement(By.name("industry"))).selectByVisibleText("Engineering");
			new Select(driver.findElement(By.name("accounttype"))).selectByVisibleText("Partner");

			driver.findElement(By.name("phone")).sendKeys("9027898989");
			driver.findElement(By.name("email1")).sendKeys("shivansh@gmail.com");

			new Select(driver.findElement(By.name("rating"))).selectByVisibleText("Active");

			driver.findElement(By.name("annualrevenue")).sendKeys("9999999");
			Thread.sleep(1000);

		//save button
			driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
			Thread.sleep(3000);

		//Verification
			String savedOrganizationName = driver.findElement(By.id("dtlview_Organization Name")).getText();

			if (savedOrganizationName.equals(organizationName))
			{
				System.out.println("Created Organization " + organizationName + " successfully!!!!");
			}
			else
			{
				System.out.println("Failed");
			}

		//sign out
			WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

			Actions act = new Actions(driver);
			act.moveToElement(profilePic).build().perform();

			Thread.sleep(2000);
			driver.findElement(By.linkText("Sign Out")).click();

			Thread.sleep(3000);
			driver.quit();
	}
}
