package rahulshettyacademy.pageobjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.Abstractcomponent.AbstractComponent;

public class paymentsection extends AbstractComponent {

	WebDriver driver;
	
	public paymentsection(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;
	By countrytext=By.cssSelector(".ta-results");
	@FindBy(css = ".ta-item:nth-child(3)")
	WebElement India;
	@FindBy(css="a.btnn.action__submit")
	WebElement submit;
	
	
	
	public bookingdetails countryselection() {
		country.sendKeys("ind");
		waitForElementAppear(countrytext);
		India.click();
		submit.click();
		bookingdetails details=new bookingdetails(driver);
		return details;
	}
	
}
