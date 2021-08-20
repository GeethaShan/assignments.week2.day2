package assignments.week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_DuplicateLead {

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
		
		//8	Click on Email
		driver.findElement(By.linkText("Email")).click();
		
		//9	Enter Email
		driver.findElement(By.name("emailAddress")).sendKeys("nafa");
		
		//10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(10000);
		
		//11	Capture name of First Resulting lead
		WebElement firstleadname = driver.findElement(By.xpath("//tr/td[3]//a[@class='linktext']"));
		String firstLeadNameText = firstleadname.getText();
		System.out.println("First lead id is : "+firstLeadNameText);
		
		//12	Click First Resulting lead
		firstleadname.click();
		
		//13	Click Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//14	Verify the title as 'Duplicate Lead'
		if (driver.getTitle().contains("Duplicate Lead | opentaps CRM")) {
			System.out.println("PASS - Title is : "+driver.getTitle());
		}
		else
			System.out.println("FAIL - Title is : "+driver.getTitle());
		
		//15	Click Create Lead
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		
		//16	Confirm the duplicated lead name is same as captured name
		String duplicateName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if (duplicateName.equals(firstLeadNameText)) {
			System.out.println("PASS - Duplicate lead name is same as captured name");
		}
		else
			System.out.println("FAIL - Duplicate lead name is not same as captured name");
		
		//17	Close the browser (Do not log out)
		driver.close();
		

	}

}
