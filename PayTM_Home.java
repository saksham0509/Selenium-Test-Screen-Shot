package myframework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayTM_Home {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement userNameField;
	
	@FindBy(xpath="//input[@name='pass']")
	WebElement passwordField;
	
	@FindBy(xpath="//label[@id='loginbutton']")
	WebElement submitButton;
	
	@FindBy(xpath="(//span[@class='uiIconText _5qtp'])[1]")
	WebElement composeTab;
	
	public PayTM_Home() {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		PageFactory.initElements(driver, this);
		}
	
	public void logIn(String username, String password) {
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		
		try {
		composeTab.click();
		}catch(Exception e) {
			submitButton.click();
			TakesScreenshot screen=(TakesScreenshot)driver;
			File srcFile = screen.getScreenshotAs(OutputType.FILE);		
			try {
				FileUtils.copyFile(srcFile, new File ("D:\\issue_screen.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		}
		
		
	}

}
