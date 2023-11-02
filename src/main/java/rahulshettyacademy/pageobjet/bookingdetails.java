package rahulshettyacademy.pageobjet;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponent.AbstractComponent;

public class bookingdetails extends AbstractComponent {
	
	WebDriver driver;
	 
	public bookingdetails(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	@FindBy (css=".hero-primary")
	WebElement thankyou;
	
	
	public String thankYou() {
		
		String confirmmessage=thankyou.getText();
		//System.out.println(driver.findElement(By.cssSelector("label.ng-star-inserted")).getText());
		return confirmmessage;
	}

}
