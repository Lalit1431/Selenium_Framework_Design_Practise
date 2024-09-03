package rahulshettyacademy.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//LandingPage page=new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.xpath("//span[contains(text(),'Select PDF files')]/parent::a")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\USER\\Documents\\fileupload\\fileupload.exe");
	}

}
