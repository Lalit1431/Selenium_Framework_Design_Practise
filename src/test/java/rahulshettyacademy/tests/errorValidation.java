package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjet.cartsection;
import rahulshettyacademy.pageobjet.productCatalogue;
import rahulshettyacademy.testcomponent.BaseTest;

public class errorValidation extends BaseTest{

	
		@Test
		public void loginerrorvalidaion() throws IOException {
		productCatalogue catalogue = page.loginapplication("iamlalit1431@gmail.com", "Lalit31");
		Assert.assertEquals("Incorrect email or password.", page.errormessage());
		//driver.close();
		
	}
		
		@Test 
		public void productnamevalidation() throws IOException {
		String productname="ZARA COAT 3";
		productCatalogue catalogue = page.loginapplication("anshika@gmail.com","Iamking@000");
		List<WebElement> products = catalogue.getproductlist();
		catalogue.addtocart(productname);
		cartsection cart = catalogue.cart();
		boolean match = cart.getcartproductlist("zaracoat55");
		Assert.assertFalse(match);
		
		}



}
