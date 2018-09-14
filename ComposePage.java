package myframework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ComposePage {
	WebDriver driver;
	@FindBy(xpath="//div[text()='COMPOSE']")
	WebElement composeButton;
	
	@FindBy(xpath="(//textarea[@class='vO'])[1]")
	WebElement toTextBox;
	
	@FindBy(xpath="//input[@name='subjectbox']")
	WebElement subjectBox;
	
	@FindBy(xpath="//div[@class='Am Al editable LW-avf']")
	WebElement textArea;
	
	@FindBy(xpath="//div[@class='a1 aaA aMZ']")
	WebElement attachButton;
	
	@FindBy(xpath="//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
	WebElement sendButton;
	
	public ComposePage(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void composeMail() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(composeButton));
		composeButton.click();
		wait.until(ExpectedConditions.visibilityOf(toTextBox));
		toTextBox.sendKeys("saksham0509@gmail.com");
		subjectBox.sendKeys("Automation Testing");
		textArea.sendKeys("Issue is in attachment !!!");
		attachButton.click();
		Thread.sleep(5000);
		try {
			Robot robot=new Robot();
			for(int i=0;i<8;i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			}
			
			for(int i=0;i<12;i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			}
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			
			for(int i=0;i<10;i++) {
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				}
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='vq']"))));
		sendButton.click();
		
		
		
	}

}
