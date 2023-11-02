package rahulshettyacademy.Abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjet.cartsection;
import rahulshettyacademy.pageobjet.orderSection;

public class AbstractComponent {
	
	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderpage;

	public void waitForElementAppear(By findBy) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementAppear(WebElement Findby) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(Findby));
	}
	
	
	
	public cartsection cart() {
		cart.click();
		cartsection cart=new cartsection(driver);
		return cart;
	
	}
	
	public orderSection order() throws InterruptedException {
		orderpage.click();
	
		orderSection order=new orderSection(driver);
		return order;
		
	}
	
	
	public void waitForElementDisappear(By findBy) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findBy)));
	}
	
	public void closedriver() {
		driver.close();
	}

}
