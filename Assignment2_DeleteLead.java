package assignments.week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_DeleteLead {

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
		
		//8	Click on Phone
		driver.findElement(By.linkText("Phone")).click();
		
		//9	Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("99");
		
		//10 Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(10000);
		
		//11 Capture lead ID of First Resulting lead
		WebElement firstleadID = driver.findElement(By.xpath("//tr//a[@class='linktext']"));
		String firstLeadIDText = firstleadID.getText();
		System.out.println("First lead id is : "+firstLeadIDText);
		
		
		//12	Click First Resulting lead
		firstleadID.click();
		
		//13	Click Delete
		driver.findElement(By.linkText("Delete")).click();
		
		//14	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//15	Enter captured lead ID
		driver.findElement(By.name("id")).sendKeys(firstLeadIDText);
		
		//16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		boolean isDisplayed = driver.findElement(By.xpath("//div[contains(text(),'No records')]")).isDisplayed();
		if (isDisplayed) {
			System.out.println("Pass : No records to display message is present");
		}
		else
			System.out.println("Fail : No records to display message is not present");
		
		//18	Close the browser (Do not log out)
		driver.close();

	}

}
