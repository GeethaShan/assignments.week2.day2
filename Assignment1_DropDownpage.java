package assignments.week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_DropDownpage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Chromedriver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Select training program using Index
		WebElement elementDropDown1 = driver.findElement(By.id("dropdown1"));
		Select drpDown1 = new Select(elementDropDown1);
		drpDown1.selectByIndex(1);

		//Select training program using text
		WebElement elementDropDown2 = driver.findElement(By.name("dropdown2"));
		Select drpDown2 = new Select(elementDropDown2);
		drpDown2.selectByVisibleText("Appium");
		
		//Select training program using value
		WebElement elementDropDown3 = driver.findElement(By.id("dropdown3"));
		Select drpDown3 = new Select(elementDropDown3);
		drpDown3.selectByValue("3");
		
		//get the number of dropdown options
		WebElement elementDrpDown4 = driver.findElement(By.className("dropdown"));
		Select drpDown4 = new Select(elementDrpDown4);
		System.out.println("Number of drop down options is : "+drpDown4.getOptions().size());
		
		//use sendkeys to select
		driver.findElement(By.xpath("//option[contains(text(),'sendKeys')]/parent::select")).sendKeys("Appium");
		
		//Select your programs
		WebElement elementSelectprogram = driver.findElement(By.xpath("//option[contains(text(),'your programs')]/parent::select"));
	    Select elementSelProg = new Select(elementSelectprogram);
	    elementSelProg.selectByValue("4");
	    elementSelProg.selectByValue("3");
	    
	    driver.close();
	}

}
