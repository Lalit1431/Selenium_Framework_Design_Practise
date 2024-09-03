package rahulshettyacademy.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjet.bookingdetails;
import rahulshettyacademy.pageobjet.cartsection;
import rahulshettyacademy.pageobjet.orderSection;
import rahulshettyacademy.pageobjet.paymentsection;
import rahulshettyacademy.pageobjet.productCatalogue;
import rahulshettyacademy.testcomponent.BaseTest;

public class submitTest extends BaseTest{
	String productname="ZARA COAT 3";
	
		@Test(dataProvider = "getdata",groups = {"Purchase"})
		public void submitOrder(String email,String password,String productname) throws IOException {
		
//		 page = launchApplication(); 
		productCatalogue catalogue = page.loginapplication(email,password);
	//	List<WebElement> products = catalogue.getproductlist();
		catalogue.addtocart(productname);
		cartsection cart = catalogue.cart();
		boolean match = cart.getcartproductlist(productname);
		Assert.assertTrue(match);
		paymentsection payment=cart.checkout();
		bookingdetails details=payment.countryselection();
		String confirmessage=details.thankYou();
		Assert.assertTrue(confirmessage.equalsIgnoreCase("Thankyou for the order."));
	}
		
		
		@Test(dependsOnMethods = {"submitOrder"})
		public void orderhistory() throws InterruptedException {
			productCatalogue catalogue = page.loginapplication("iamlalit1431@gmail.com", "Lalit@1431");
			orderSection ord=catalogue.order();
			Assert.assertTrue(ord.orderproductname(productname));
			
		}
		
		
		@DataProvider
		public Object[] [] getdata() {
			return new Object [] []	{{"iamlalit1431@gmail.com","Lalit@1431","ZARA COAT 3"},{"anshika@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
		}

}
