package assignments.week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_EditPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//chrome driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch url
		driver.get("http://leafground.com/pages/Edit.html");
		
		//timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Enter email address
		driver.findElement(By.id("email")).sendKeys("testtest@gmail.com");
		
		//Append a text and press keyboard tab
		WebElement elementAppendTextBox = driver.findElement(By.xpath("//label[contains(text(),'keyboard')]/following::input"));
		elementAppendTextBox.sendKeys("Geetha");
		elementAppendTextBox.sendKeys(Keys.TAB);
						
		//Get Default text entered
		String defaultTextValue = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println("Default text entered is :"+defaultTextValue);
		
		//Clear the text
		driver.findElement(By.xpath("//input[@name='username'][1]/following::input")).clear();
		
		//Confirm that edit field is disabled
		boolean isEnabledTextBox = driver.findElement(By.xpath("//label[contains(text(),'Confirm')]/following::input")).isEnabled();
        if (isEnabledTextBox) {
        	System.out.println("Edit field is enabled");
        }
        else
        	System.out.println("Edit field is disabled");
        
        driver.close();
	}

}
