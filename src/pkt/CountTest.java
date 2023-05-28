/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 26.05.2023
* <p>
* Sayaç testi gerceklestirecek olan sınıfımız. 
* Test arayuzunu implemente etmektedir
* 
* Genel Amacı: Site icerisinde bulunması gereken miktarda
* ifade edilen elementin olup olmadigini test etmektedir.
* </p>
*/
package pkt;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CountTest implements Test{
	private WebDriver driver;
	private ShowTestResult showTestResult;

	public CountTest(WebDriver driver, ShowTestResult showTestResult) {
		this.driver = driver;
		this.showTestResult = showTestResult;
	}
	
	@Override
	public void runAllTest() throws InterruptedException {
		calculateFandomNavigationBasisLinkCountTest();
		Thread.sleep(2000);
		
		calculateLolChampionCountTest();
		Thread.sleep(2000);
		
		calculateFreeChampionRotationInAramTest();
		Thread.sleep(2000);
		
		calculateFreeChampionRotationInNewAccountsTest();
		Thread.sleep(2000);
	}
	
	
	/*
	 * Fandom navigation alaninda temel olarak sayilabilen link sayisi
	 * test ediliyor.
	 */
	public void calculateFandomNavigationBasisLinkCountTest() throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/List_of_champions");
		Thread.sleep(1000);
		
		int basis_navigation_link_count = 9;

		List<WebElement> basis_navigation_links = driver.findElements(By.xpath("//div[contains(@class, 'global-navigation__links')]//a"));
		
		int calculated_basis_navigation_link_count = basis_navigation_links.size();
		
		if(basis_navigation_link_count == calculated_basis_navigation_link_count) {
			System.out.println("Fandom Navigation Basis Link Count Testi: Basarili");
		}
		else {
			System.out.println("Fandom Navigation Basis Link Count Testi: Basarisiz");
		}
		showTestResult.showResult(basis_navigation_link_count, calculated_basis_navigation_link_count);
	}

	/*
	 * League of Legends'te bulunan sampiyon sayisi test ediliyor.
	*/
	public void calculateLolChampionCountTest() throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/List_of_champions");
		Thread.sleep(1000);
		int lolChampionCount = 163;
		
		List<WebElement> champions = driver.findElements(By.xpath("//table[@class='article-table sticky-header sortable jquery-tablesorter']//tbody//tr"));
		
		int calculatedLolChampionCount = champions.size();
		
		if(lolChampionCount == calculatedLolChampionCount) {
			System.out.println("Sampiyon Sayisini Hesapla Testi: Basarili");
		}
		else {
			System.out.println("Sampiyon Sayisini Hesapla Testi: Basarisiz");
		}
		showTestResult.showResult(lolChampionCount, calculatedLolChampionCount);
	}
	
	/* 
	 * ARAM Haritasinda Free olarak sunulan sampiyon sayisi test ediliyor
	*/
	public void calculateFreeChampionRotationInAramTest() throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/Free_champion_rotation");
		Thread.sleep(2500);
				
		int freeAramChampionsCount = 65;
		
		// ARAM elementi seciliyor ve elemente tiklaniyor.
		WebElement element = driver.findElement(By.xpath("//li[@data-hash='ARAM']"));
		element.click();
		Thread.sleep(1000);
		
		// tiklanan alanda gelen sampiyon sayisi aliniyor.
		List<WebElement> freeAramChampions = driver.findElements(By.xpath("//div[@class='wds-tab__content wds-is-current']//ol[@class='free_champion_rotation']//li"));
		
		
		int calculatedAramChampionCount = freeAramChampions.size();
		
		// beklenen ile gelen deger esit mi kontrolu yapiliyor.
		if(freeAramChampionsCount == calculatedAramChampionCount) {
			System.out.println("Sampiyon Sayisini Hesapla Testi: Basarili");
		}
		else {
			System.out.println("Sampiyon Sayisini Hesapla Testi: Basarisiz");
		}
		showTestResult.showResult(freeAramChampionsCount, calculatedAramChampionCount);

		Thread.sleep(1000);
	}
	
	/*
	 * Yeni olusturulan hesaplar icin ilk 11 levelde free olarak erisim imkani
	 * olan sampiyonlarin sayisi test ediliyor
	 */
	public void calculateFreeChampionRotationInNewAccountsTest() throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/Free_champion_rotation");
		Thread.sleep(1000);
	
		int freeNewAccountsChampionCount = 10;
		

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(250, 0)");

        // Beklemek için bir süre bekleyin (örneğin, 5 saniye)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
				
		List<WebElement> freeAramChampions = driver.findElements(By.xpath("//div[@class='wds-tab__content wds-is-current']//ol[@class='free_champion_rotation']//li"));
		int calculatedNewAccountsChampionCount = freeAramChampions.size();
		
		// beklenen ile gelen deger esit mi kontrolu yapiliyor.
		if(freeNewAccountsChampionCount == calculatedNewAccountsChampionCount) {
			System.out.println("Sampiyon Sayisini Hesapla Testi: Basarili");
		}
		else {
			System.out.println("Sampiyon Sayisini Hesapla Testi: Basarili");
		}
		showTestResult.showResult(freeNewAccountsChampionCount, calculatedNewAccountsChampionCount);

		Thread.sleep(1000);
	}
}
