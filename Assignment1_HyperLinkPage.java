package assignments.week2.day2;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_HyperLinkPage {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Go to Home Page
		String homePageUrl = driver.findElement(By.linkText("Go to Home Page")).getAttribute("href");
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		if (driver.getTitle().contains("Selenium Playground")) {
			System.out.println("Navigated to home page properly ");
		}
		else 
			System.out.println("Unable to navigate to home page");
		
		
		//again navigate back to Hyperlink page
		driver.findElement(By.xpath("//h5[text()='HyperLink']/following::img")).click();
		
		if (driver.getTitle().contains("Interact with HyperLinks")) {
			System.out.println("Navigated back again to Hyperlinks page");
		}
		else
			System.out.println("Unable to navigate back again to Hyperlinks page");
		
		//Find where am supposed to go without clicking me?
		String attributeValue = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println("Clicking on this link will take you to : "+attributeValue);
		
		//Verify am I broken?
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String elementBrokenPageTitle = driver.getTitle();
		if (elementBrokenPageTitle.contains("HTTP Status 404")) {
			System.out.println("Link is broken.Link -> "+elementBrokenPageTitle);
		}
		else
			System.out.println("Link is not broken.Link -> "+elementBrokenPageTitle);
				
		//Go to Home Page (Interact with same link name)
		driver.get(homePageUrl);
		//again navigate back to Hyperlink page
		driver.findElement(By.xpath("//h5[text()='HyperLink']/following::img")).click();
		
		//How many links are available in this page?
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links available in this page is :"+linkElements.size());
		
		driver.close();
	}		
}

