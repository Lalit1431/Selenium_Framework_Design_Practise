package rahulshettyacademy.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Retailer3 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//LandingPage page=new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://uat-ra.sarvm.ai/selected-language");
		Thread.sleep(5000);
		driver .findElement(By.xpath("//ion-card-content[contains( text(), 'English')]")).click();
		
		WebElement element=driver.findElement(By.xpath("//h4[text()='Select Language']"));
		// Assert if the text is present
        Assert.assertTrue(element.isDisplayed(), "Text 'Select Language' is not present on the webpage");
		driver.findElement(By.xpath("//ion-button[text()=' Continue ']")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Mobile Number\"]")).sendKeys("4202200200");
		driver.findElement(By.xpath("(//ion-button)[2]")).click();
		WebElement Otpfield = driver.findElement(By.xpath("//ion-input[@maxlength='4']"));
		Otpfield.click();
        Robot robot = new Robot();
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_NUMPAD7);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_NUMPAD7);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_NUMPAD7);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_NUMPAD7);
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Order Management']")).click();
        // Find the WebElement whose property you want to check
        WebElement newTab = driver.findElement(By.xpath("//ion-segment-button[@ng-reflect-value='new']"));
	     // Check if the "New" tab is selected
	     String newclassAttributeValue = newTab.getAttribute("class");
	     boolean isNewTabSelected = newclassAttributeValue.contains("segment-button-after-checked");
		Assert.assertEquals(isNewTabSelected, false);
        driver.findElement(By.xpath("(//div[@class='orderDetails'])[1]//ion-button[text()='Accept']")).click();
        driver.findElement(By.xpath("//ion-button[text()='Ok']")).click();
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//ion-button[text()='Yes']")).click();
        
        
        
        WebElement acceptedTab = driver.findElement(By.xpath("(//ion-label[text()='Accepted'])[3]"));
	     // Check if the "Accepted" tab is selected
	    String acceptedclassAttributeValue = acceptedTab.getAttribute("class");
	    boolean isacceptedTabSelected = acceptedclassAttributeValue.contains("segment-button-after-checked");
		Assert.assertEquals(isacceptedTabSelected, false);
        driver.findElement(By.xpath("//ion-button[text()='Process']")).click();
        Thread.sleep(1000);
        driver.switchTo().activeElement();
        WebElement processbtn=driver.findElement(By.xpath("//span[text()='Process']"));
        Thread.sleep(1000);
        Actions act=new Actions(driver);
        Thread.sleep(1000);
        act.click(processbtn).perform();
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//ion-button[text()='Yes']")).click();
        
        
        
        WebElement processingTab = driver.findElement(By.xpath("(//ion-label[text()='Processing'])[4]"));
        String processingclassAttributeValue = processingTab.getAttribute("class");
	    boolean isprocessingTabSelected = processingclassAttributeValue.contains("segment-button-after-checked");
		Assert.assertEquals(isprocessingTabSelected, false);
		driver.findElement(By.xpath("(//ion-button[text()='Ready'])[2]")).click();
		Thread.sleep(1000);
        driver.switchTo().activeElement();
        WebElement readybtn=driver.findElement(By.xpath("//span[text()='Ready']"));
        Thread.sleep(1000);
        act.click(readybtn).perform();
        Thread.sleep(1000);
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//ion-button[text()='Yes']")).click();     
        
        WebElement readyTab = driver.findElement(By.xpath("(//ion-label[text()='Ready'])[2]"));
        String readyclassAttributeValue = readyTab.getAttribute("class");
	    boolean isreadyTabSelected = readyclassAttributeValue.contains("segment-button-after-checked");
		Assert.assertEquals(isreadyTabSelected, false);
		WebElement ordertype = driver.findElement(By.xpath("(//ion-card[@class=\"card ion-margin-bottom md hydrated\"]//span[@class=\"status-text\"])[4]"));
		System.out.println(ordertype.getText());
		
		System.out.println("pickup method");
		Thread.sleep(2000);
		WebElement pck = driver.findElement(By.xpath("(//ion-button[text()='Pickup'])[2]"));
		Actions act2=new Actions(driver);
		act2.click(pck).perform();
	    driver.switchTo().activeElement();
	    WebElement pickupbtn=driver.findElement(By.xpath("//span[text()='Pickup']"));
	    act2.click(pickupbtn).perform();
	    driver.switchTo().activeElement();
	    driver.findElement(By.xpath("//ion-button[text()='Yes']")).click();
        WebElement deliveryTab = driver.findElement(By.xpath("(//ion-label[text()='Delivery'])[4]"));
        String deliveryclassAttributeValue = deliveryTab.getAttribute("class");
	    boolean isdeliveryTabSelected = deliveryclassAttributeValue.contains("segment-button-after-checked");
		Assert.assertEquals(isdeliveryTabSelected, false);
		driver.findElement(By.xpath("(//ion-button[text()=' Payment Received ? '])")).click();
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//ion-button[text()='Yes']")).click();
		
        
        
        
		driver.quit();
}
	}

	


