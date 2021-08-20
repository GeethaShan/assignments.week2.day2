package assignments.week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_RadioPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Chromedriver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//1. Are you enjoying the classes?
		driver.findElement(By.id("yes")).click();
		
		//2. Find default selected radio button
		if (driver.findElement(By.xpath("//label[@for='Unchecked']/input")).isSelected()) {
			System.out.println("Radio button *Unchecked* is selected by default");
		}
		else if (driver.findElement(By.xpath("//label[@for='Checked']/input")).isSelected()) {
			System.out.println("Radio button *Checked* is selected by default");
		}
		else
			System.out.println("Nothing is selected by default");
		
		//3. Select your age group (Only if choice wasn't selected)
		List<WebElement> elementsAgeOptions = driver.findElements(By.name("age"));
		boolean isSel = false;
		for (int i=0; i<elementsAgeOptions.size(); i++) {
			if (elementsAgeOptions.get(i).isSelected()) {
				isSel = true;
				}
		}
		if (isSel) {
			System.out.println("Choice is already selected");
		}
		else 
			elementsAgeOptions.get(1).click();
		
		driver.close();
		
	}

}
