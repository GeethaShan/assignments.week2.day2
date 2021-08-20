package assignments.week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_CheckBoxPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//1.Select the languages that you know?
		driver.findElement(By.xpath("//div[@class='example']//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'SQL')]/input")).click();
				
		//2. Confirm Selenium is checked
		boolean elementIsSelected = driver.findElement(By.xpath("//div[contains(text(),'Selenium')]/input")).isSelected();
		if (elementIsSelected) {
			System.out.println("Selenium is checked");
		}
		else 
			System.out.println("Selenium is not checked");
		
		//3. DeSelect only checked
		for (int i=1; i<=2; i++) {
			WebElement checkElement = driver.findElement(By.xpath("//label[contains(text(),'DeSelect only')]/following::input["+i+"]"));
			if (checkElement.isSelected()) {
				checkElement.click();
				}
		}
		
		//4. Select all below check boxes
		for (int x=1; x<=5; x++) {
			driver.findElement(By.xpath("//label[contains(text(),'checkboxes')]/following::input["+x+"]")).click();
		}
		
		driver.close();
		
	}

}
