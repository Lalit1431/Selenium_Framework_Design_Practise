package rahulshettyacademy.pageobjet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.Abstractcomponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	public WebDriver driver;
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement passsword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	
public productCatalogue loginapplication(String name,String pwd) {
	useremail.sendKeys(name);
	passsword.sendKeys(pwd);
	submit.click();
	productCatalogue catalogue=new productCatalogue(driver);
	return catalogue;
}

public String errormessage() {
	waitForWebElementAppear(errormessage);
	return errormessage.getText();
}

public void goTo() {
	driver.get("https://rahulshettyacademy.com/client");
	
}




}
