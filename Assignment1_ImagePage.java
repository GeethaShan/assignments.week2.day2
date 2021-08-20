package assignments.week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_ImagePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Chromedriver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on this image to go home page
		driver.findElement(By.xpath("//label[@for='home']/following-sibling::img")).click();
		
		//Go to Home Page
		if (driver.getTitle().contains("Selenium Playground")) {
			System.out.println("Navigated to home page properly ");
		}
		else 
			System.out.println("Unable to navigate to home page");

		//again navigate back to Image page
		driver.findElement(By.xpath("//h5[text()='Image']/following::img")).click();
		
		if (driver.getTitle().contains("Interact with Images")) {
			System.out.println("Navigated back again to Images page");
		}
		else
			System.out.println("Unable to navigate back again to Images page");
		
		//Am I Broken Image?
		driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following::img")).click();
				
		if (driver.getTitle().contains("Interact with Images")) {
			System.out.println("Image is broken");
		}
		else 
			System.out.println("Image is not broken");
		
		driver.close();

	}

}
