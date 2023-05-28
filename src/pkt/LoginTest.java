/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 26.05.2023
* <p>
* Login testi gerceklestirecek olan sınıfımız. 
* Test arayuzunu implemente etmektedir
* 
* Genel Amacı: Login sayfasina deneme verileri girerek
* sitenin nasil bir cevap verdigini test etmektedir.
* </p>
*/
package pkt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest implements Test {
	private WebDriver driver;
	private ShowTestResult showTestResult;
	
	public LoginTest(WebDriver driver, ShowTestResult showTestResult) {
		super();
		this.driver = driver;
		this.showTestResult = showTestResult;
	}
	
	@Override
	public void runAllTest() throws InterruptedException {
		loginTest();
		Thread.sleep(2000);
	}
	
	/*
	 * Deneme verileri girerek login istemi yapiyor ve beklenen
	 * cikti geliyor mu test ediliyor. 
	 */
	public void loginTest() throws InterruptedException {
		driver.get("https://auth.fandom.com/signin");
		String expectedErrorString = "We don't recognize these credentials. Your username may have been changed as a result of login system changes, adding -fduser or -gpuser as a suffix. Try again or register a new account.";
		Thread.sleep(1000);
		
		driver.findElement(By.id("identifier")).sendKeys("Deneme-username");
		Thread.sleep(500);
		driver.findElement(By.id("password")).sendKeys("Deneme-password");
		Thread.sleep(500);
		
		WebElement submitButton = driver.findElement(By.xpath("//div[@class='Submit_buttonWrapper__33HZ0']"));
		submitButton.click();
		
		Thread.sleep(1000);
		
		WebElement errorDiv = driver.findElement(By.className("formError_error__2aO0Q"));
		String errorText = errorDiv.getText();
		
		if(expectedErrorString.equals(errorText)) {
			System.out.println("Login Testi : Basarili");
		}
		else {
			System.out.println("Login Testi : Basarisiz");
		}
		showTestResult.showNoResult();
	}
}
