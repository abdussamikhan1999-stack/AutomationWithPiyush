package oppourtunities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// Locators below (field names, popup alt text, dtlview ids) follow the same
// naming convention as contact.CreateContactText and the popup URL captured
// in "Oppourtunites Test case.xlsx" (forfield=related_to&srcmodule=Potentials).
// Verify against the running instance and adjust if the theme/layout differs.
public class AddNewoppourtunities
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

		//Create_Opportunity
			driver.findElement(By.linkText("Opportunities")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("img[alt='Create Opportunity....']")).click();
			Thread.sleep(2000);

		//filling data to the form
			WebElement opportunityNameField = driver.findElement(By.name("potentialname"));
			String opportunityName = "OrgName";
			opportunityNameField.sendKeys(opportunityName);

		//Related To -> Contact
			WebElement relatedToModule = driver.findElement(By.id("related_to_module"));
			relatedToModule.sendKeys("Contact");
			Thread.sleep(1000);

			driver.findElement(By.cssSelector("img[alt='Select']")).click();
			Thread.sleep(2000);

		//select "Mary Smith" in the popup picker window
			String parentWindow = driver.getWindowHandle();
			for (String windowHandle : driver.getWindowHandles())
			{
				if (!windowHandle.equals(parentWindow))
				{
					driver.switchTo().window(windowHandle);
				}
			}
			driver.findElement(By.linkText("Mary Smith")).click();
			driver.switchTo().window(parentWindow);
			Thread.sleep(2000);

		//save button
			driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
			Thread.sleep(3000);

		//Verification
			String savedOpportunityName = driver.findElement(By.id("dtlview_Opportunity Name")).getText();
			String savedRelatedTo = driver.findElement(By.id("dtlview_Related To")).getText();

			if (savedOpportunityName.equals(opportunityName) && savedRelatedTo.contains("Mary Smith"))
			{
				System.out.println("Created Opportunity " + opportunityName + " successfully!!!!");
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
