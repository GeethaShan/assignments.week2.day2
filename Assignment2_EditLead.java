package assignments.week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//2	Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		//3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();

		//5	Click crm/sfa link
		driver.findElement(By.partialLinkText("CRM")).click();

		//6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(5000);
		
		//8 Enter first name
		driver.findElement(By.xpath("//input[@name='id']/following::input")).sendKeys("testd");
		Thread.sleep(5000);
		
		//9	Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(6000);
		
		//10 Click on first resulting lead
		driver.findElement(By.xpath("//tr//a[@class='linktext']")).click();
				
		//11 Verify title of the page
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("View Lead | opentaps CRM")) {
			System.out.println("PASS - Page title is correct : "+pageTitle);
		}
		else
			System.out.println("FAIL - Page title is wrong : "+pageTitle);
		
		//12 Click Edit
		driver.findElement(By.linkText("Edit")).click();
		
		//13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("LTTS");
		
		//14 Click Update
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//15 Confirm the changed name appears
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String updatedCompName = companyName.replaceAll("[^a-zA-Z]", "");
		if (updatedCompName.equals("LTTS")) {
			System.out.println("PASS - Company name got updated succesfully.Actual : "+updatedCompName);
		}
		else
			System.out.println("FAIL - Company name is not updated succesfully.Actual : "+updatedCompName);
		
		//16 Close the browser (Do not log out)
		driver.close();

	}

}
