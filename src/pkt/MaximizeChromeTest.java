/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 26.05.2023
* <p>
* Chrome penceresinin maksimum buyukluge getirilip getirilmediginin testin 
* gerceklestirecek olan sınıfımız. 
* Test arayuzunu implemente etmektedir
* 
* Genel Amacı: Chrome penceresinin maksimum boyutta olup olmadigini test etmek
* </p>
*/
package pkt;

import org.openqa.selenium.WebDriver;

public class MaximizeChromeTest implements Test {

	private WebDriver driver;
	private ShowTestResult showTestResult;
	
	public MaximizeChromeTest(WebDriver driver, ShowTestResult showTestResult) {
		super();
		this.driver = driver;
		this.showTestResult = showTestResult;
	}
	
	@Override
	public void runAllTest() throws InterruptedException {
		maximizeWindowTest();
		Thread.sleep(1000);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	/*
	 * driver penceresi maximize edilmesi test ediliyor. 
	 */
	public void maximizeWindowTest() {
		maximizeWindow();
		
		System.out.println("Pencere Maksimize Edildi Mi Testi: Başarılı");
	}
}
