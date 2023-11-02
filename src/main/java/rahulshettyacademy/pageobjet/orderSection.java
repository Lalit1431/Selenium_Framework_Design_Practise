package rahulshettyacademy.pageobjet;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.Abstractcomponent.AbstractComponent;

public class orderSection extends AbstractComponent {
WebDriver driver;

public orderSection(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(css="tr td:nth-child(3)")
List<WebElement> orderproducts;

public boolean orderproductname(String productname) {
	boolean match = orderproducts.stream().anyMatch(orderproducts -> orderproducts.getText().equalsIgnoreCase(productname));
	return match;
}
	
	
	
}
