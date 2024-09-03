package rahulshettyacademy.pageobjet;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import rahulshettyacademy.Abstractcomponent.AbstractComponent;

public class cartsection extends AbstractComponent {

		WebDriver driver;
	public cartsection(WebDriver driver) {
		super(driver);		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css=".cart h3")
	List<WebElement> cartproducts;
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
public  boolean  getcartproductlist(String productname) {
	boolean match = cartproducts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productname));
	return match;	
}

public paymentsection checkout() {
	checkout.click();
	paymentsection payment=new paymentsection(driver);
	return payment;
}



 
}
