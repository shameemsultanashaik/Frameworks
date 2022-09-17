package KDF;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {
	
	WebDriver driver;
	
	public void openBrowser() {
		driver = new ChromeDriver();
	}
	
	public void maximizedBrowserWindow() {
		driver.manage().window().maximize();
	}
	
	public void implementImlicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void navigateToApplication(String url) {
		driver.get(url);
	}
	public void enterInTextBox(String locvalue,String textData) {
		driver.findElement(By.id(locvalue)).sendKeys(textData);
	}
	
	public void clickButton(String loc,String locvalue) {
		if(loc.equals("name")) {
			driver.findElement(By.name(locvalue)).click();
		}
		else if(loc.equals("xpath")) {
			driver.findElement(By.xpath(locvalue)).click();
		}
	}
	public String getMessage(String loc,String locvalue) {
		String errMsg = null;
		if(loc.equals("cssSelector")) {
		errMsg = driver.findElement(By.cssSelector(locvalue)).getText();
		}
		else if(loc.equals("id")) {
			errMsg = driver.findElement(By.id(locvalue)).getText();
		}
		return errMsg;
	}
	public void closeApplication() {
		driver.quit();
	}

}

			
			
		
			 
			
		
		  
	
	 
		
	
	