package assignments.week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_ButtonPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click button to travel home page
		driver.findElement(By.id("home")).click();
		if (driver.getTitle().contains("Selenium Playground")) {
			System.out.println("Travelled to home page properly ");
		}
		else 
			System.out.println("Unable to travel to home page");
		
		//Click on buttons icon in home page to again open Buttons.html
		driver.findElement(By.xpath("//img[@alt='Buttons']")).click();
		if (driver.getTitle().contains("Interact with Buttons")) {
			System.out.println("Travelled to Bond with Buttons page properly");
		}
		else
			System.out.println("Unable to reach Bond with Buttons page");
		
		//Find position of button (x,y)
		Point elementButtonLocation = driver.findElement(By.id("position")).getLocation();
		System.out.println("Position of button is : "+elementButtonLocation);
		
		//Find button color
		String elementCssValue = driver.findElement(By.id("color")).getCssValue("color");
		System.out.println("Button color is "+elementCssValue);
		
		//Find the height and width
		Dimension elementButtonSize = driver.findElement(By.id("size")).getSize();
		System.out.println("Button size is : "+elementButtonSize);
		
		driver.close();
	}

}
