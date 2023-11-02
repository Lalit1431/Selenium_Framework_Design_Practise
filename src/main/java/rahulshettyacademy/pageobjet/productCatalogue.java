package rahulshettyacademy.pageobjet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.Abstractcomponent.AbstractComponent;

public class productCatalogue extends AbstractComponent {

		WebDriver driver;
	public productCatalogue(WebDriver driver) {
		super(driver);		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	By product=By.cssSelector(".mb-3");
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	By toast=By.cssSelector("#toast-container");
	By spinner=By.cssSelector(".ng-animating");
	
	
public  List<WebElement> getproductlist() {
	
	waitForElementAppear(product);
	return products;
}

 public WebElement getProductByName(String productname) {
	 WebElement prod = getproductlist().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
	 return prod;
 }
 
 public void addtocart(String productname) {
	WebElement prod = getProductByName(productname);
	prod.findElement(addtocart).click();
	waitForElementAppear(toast);
	waitForElementDisappear(spinner);
 }

}
