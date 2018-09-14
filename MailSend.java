package myframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailSend {
	WebDriver driver;
	@FindBy(xpath="//input[@type='email']")
	WebElement usernameField;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextButton;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordField;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement submitButton;
	
	public MailSend() {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com/gmail/");
		PageFactory.initElements(driver, this);
	}
	
	public ComposePage logInMail(String username, String password) {
		usernameField.sendKeys(username);
		nextButton.click();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.sendKeys(password);
		submitButton.click();
		
		ComposePage comPage=new ComposePage(driver);
		return comPage;		
	}
	

}
