package pkt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageCounterTest implements Test {
	private WebDriver driver;
	private ShowTestResult showTestResult;
	public PageCounterTest(WebDriver driver, ShowTestResult showTestResult) {
		super();
		this.driver = driver;
		this.showTestResult = showTestResult;
	}
	
	@Override
	public void runAllTest() throws InterruptedException {
		calculatePageCountInLoLWikiTest();
		Thread.sleep(1000);
	}
	
	/*
	 * LoL Wiki sayfasinda yazmasi gereken beklenen sayfa sayisi test ediliyor. 
	 */
	public void calculatePageCountInLoLWikiTest() {
		driver.get("https://leagueoflegends.fandom.com/wiki/League_of_Legends_Wiki");;
		String expectedPageCount = "9,045";
		
		WebElement pageCounterElement = driver.findElement(By.className("page-counter__value"));
		
		String pageCounterText = pageCounterElement.getText();
		
		if(expectedPageCount.equals(pageCounterText)) {
			System.out.println("LoL Wiki Sayfasindaki Sayfa Hesaplama Testi: Basarili");
		}
		else {
			System.out.println("LoL Wiki Sayfasindaki Sayfa Hesaplama Testi: Basarisiz");
		}
		showTestResult.showResult(expectedPageCount, pageCounterText);
	}
}
