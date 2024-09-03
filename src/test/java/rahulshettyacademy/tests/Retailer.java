package rahulshettyacademy.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Retailer {

	public static void main(String[] args) throws InterruptedException, AWTException {
		String productname="ZARA COAT 3";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//LandingPage page=new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://uat-ra.sarvm.ai/selected-language");
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
        WebElement catalogue = driver.findElement(By.xpath("//div[text()='Catalogue Management']"));
        catalogue.click();
        driver.switchTo().activeElement();
        Thread.sleep(2000);
        WebElement iamselling = driver.findElement(By.xpath("//ion-title[text()='I am Selling']"));
        Assert.assertTrue(iamselling.isDisplayed(), "Text 'I am Selling' is not present on the webpage");
       Thread.sleep(5000);
       WebElement rest = driver.findElement(By.xpath("//img[@src=\"https://uat-static.sarvm.ai/catalog_images/categories/restaurant.svg\"]"));
       Actions act=new Actions(driver);
       act.click(rest).perform();
       WebElement cont=driver.findElement(By.xpath("(//ion-button[text()='Continue'])"));
       act.click(cont).perform();
       Thread.sleep(10000);
       act.click(cont).perform();
       driver.findElement(By.linkText("/my-catalog")).click();
    /* Get the initial value of the property using JavaScript
       JavascriptExecutor js = (JavascriptExecutor) driver;
       String initialPropertyValue = (String) js.executeScript("return arguments[0].getAttribute('property_name');", element);

       // Perform actions that might change the property value (e.g., click on the element)
       // For example, clicking on the element
       element.click();

       // Get the updated value of the property
       String updatedPropertyValue = (String) js.executeScript("return arguments[0].getAttribute('property_name');", element);

       // Check if the property value has changed
       if (!initialPropertyValue.equals(updatedPropertyValue)) {
           System.out.println("Property has changed.");
       } else {
           System.out.println("Property has not changed.");
       }*/
       
		//driver.quit();
	}

}
