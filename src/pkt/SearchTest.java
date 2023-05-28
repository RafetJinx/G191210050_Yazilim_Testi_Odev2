/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 26.05.2023
* <p>
* Arama testi islemlerimizi gerceklestirecek olan sinifimizdir. 
* Test arayuzunu implemente etmektedir
* 
* Genel Amacı: Site icerisinde bulunması gereken miktarda
* ifade edilen elementin olup olmadigini test etmektedir.
* </p>
*/
package pkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchTest implements Test {
	private WebDriver driver;
	private ShowTestResult showTestResult;
	
	public SearchTest(WebDriver driver, ShowTestResult showTestResult) {
		super();
		this.driver = driver;
		this.showTestResult = showTestResult;
	}
	
	@Override
	public void runAllTest() throws InterruptedException {
		openAndCloseSearchPopupTest();
		Thread.sleep(1000);
		
		openSearchBarAndDoSearch();
		Thread.sleep(1000);
		
		openSearchBarDoSearchCheckTheExpressionAndResult();
		Thread.sleep(1000);
		
		clickToSearchLayoutLeftLinksOnTheSearchResultPageTest();
		Thread.sleep(1000);
	}
	
	/*
	 * Searchbar acma ve kapama testi gerceklestiriyor.
	 */
	public void openAndCloseSearchPopupTest() throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/Universe");

		// open popup
		openSearchBarPopup();
		
		Actions deleteAction = new Actions(driver);
		deleteAction.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(1000);
		
		System.out.println("Searchbar popup acma ve kapama testi basarili");
		showTestResult.showResult("Searchbar basari ile acildi ve kapatildi.");
	}

	
	/*
	 * Searchbar'da arama yapıyor ve o sayfaya gidip gitmedigi test ediliyor.
	 */
	public void openSearchBarAndDoSearch() throws InterruptedException {
		String url = "https://leagueoflegends.fandom.com/wiki/League_of_Legends_Wiki";
		String expectedUrl = "https://leagueoflegends.fandom.com/wiki/Special:Search?query=jinx&scope=internal&navigationSearch=true";
		driver.get(url);
		
		openSearchBarPopup();
		
		writeExpressionToSearchBarInput("jinx");
		
		doClickForSearchInSearchBar();
		
		if(!url.equals(expectedUrl)) {
			System.out.println("Searchbar ile arama yapildi ve sayfa degisti mi testi: Basarili");
		} else {
			System.out.println("Searchbar ile arama yapildi ve sayfa degisti mi testi: Basarisiz");
		}
		showTestResult.showResult("Testin baslangicindaki ve sonundaki testin farklı olması bekleniyordu.");
		
	}
	
	
	/*
	 * Searchbar'da arama yapıp ilk sonuca gidiyor.
	 * Aramadaki yazilan ile gidilen yerdeki ifade ayni mi test ediliyor 
	 */
	public void openSearchBarDoSearchCheckTheExpressionAndResult() throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/League_of_Legends_Wiki");
		String input = "jinx";
		input = input.toLowerCase();
		
		openSearchBarPopup();
		Thread.sleep(1500);
		
		writeExpressionToSearchBarInput(input);
		Thread.sleep(1500);
		
		doClickForSearchInSearchBar();
		Thread.sleep(4500);
		
		WebElement aElement = driver.findElement(By.xpath("//a[@class='unified-search__result__title']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", aElement);

		List<WebElement> spanList = driver.findElements(By.xpath("//div[@class='league-font']//div//span"));
		String characterName = spanList.get(0).getText().trim().toLowerCase(Locale.ENGLISH);
		
		if(input.equals(characterName)) {
			System.out.println("Arama Islemi Sonucunda Istenilen Sayfaya Gidildi Mi Testi: Basarili");
		} else {
			System.out.println("Arama Islemi Sonucunda Istenilen Sayfaya Gidildi Mi Testi: Basarisiz");
		}
		showTestResult.showResult("Input degeri verilen sayfaya gidildiyse test basarili.");
		showTestResult.showResult(input, characterName);
	}
	
	
	/*
	 *  Search results sayfasinda solda bulunan
	 *  "Articles, Posts, Photos and Videos->All Files, Blogs, People, Everything" linklerine
	 *  sirasi ile gidilip gidilemedigi test ediliyor.
	 */
	public void clickToSearchLayoutLeftLinksOnTheSearchResultPageTest() throws InterruptedException {
		String jinxResult = "https://leagueoflegends.fandom.com/wiki/Special:Search?scope=internal&query=jinx&ns%5B0%5D=0&ns%5B1%5D=114&ns%5B2%5D=500&ns%5B3%5D=502&ns%5B4%5D=2900";

		driver.get(jinxResult);
		Thread.sleep(1000);
		closeLoLWikiBottomPopupTest();
		
		List<WebElement> links = driver.findElements(By.className("unified-search__profiles__profile"));
		links.remove(0);
		
		List<String> urls = new ArrayList<>();
		
		List<String> expectedUrls = new ArrayList<>();
		expectedUrls.add("https://leagueoflegends.fandom.com/wiki/Special:Search?scope=internal&query=jinx&contentType=posts");
		expectedUrls.add("https://leagueoflegends.fandom.com/wiki/Special:Search?scope=internal&query=jinx&ns%5B0%5D=6");
		expectedUrls.add("https://leagueoflegends.fandom.com/wiki/Special:Search?scope=internal&query=jinx&ns%5B0%5D=500&ns%5B1%5D=502");
		expectedUrls.add("https://leagueoflegends.fandom.com/wiki/Special:Search?scope=internal&query=jinx&ns%5B0%5D=2");
		expectedUrls.add("https://leagueoflegends.fandom.com/wiki/Special:Search?scope=internal&query=jinx&ns%5B0%5D=0&ns%5B1%5D=1&ns%5B2%5D=2&ns%5B3%5D=3&ns%5B4%5D=4&ns%5B5%5D=5&ns%5B6%5D=6&ns%5B7%5D=7&ns%5B8%5D=8&ns%5B9%5D=9&ns%5B10%5D=10&ns%5B11%5D=11&ns%5B12%5D=12&ns%5B13%5D=13&ns%5B14%5D=14&ns%5B15%5D=15&ns%5B16%5D=110&ns%5B17%5D=111&ns%5B18%5D=114&ns%5B19%5D=115&ns%5B20%5D=420&ns%5B21%5D=421&ns%5B22%5D=500&ns%5B23%5D=501&ns%5B24%5D=502&ns%5B25%5D=503&ns%5B26%5D=828&ns%5B27%5D=829&ns%5B28%5D=1200&ns%5B29%5D=1201&ns%5B30%5D=1202&ns%5B31%5D=2000&ns%5B32%5D=2001&ns%5B33%5D=2002&ns%5B34%5D=2300&ns%5B35%5D=2301&ns%5B36%5D=2302&ns%5B37%5D=2303&ns%5B38%5D=2900&ns%5B39%5D=2901");

		boolean testDone = false;
		
		for(int i = 0; i < expectedUrls.size(); i++) {
			Thread.sleep(5000);
			links = driver.findElements(By.className("unified-search__profiles__profile"));
			WebElement link = links.get(i);
			link.click();
			Thread.sleep(2500);
			urls.add(driver.getCurrentUrl());
			if(i+1 == expectedUrls.size()) {
				testDone = true;
			}
		}
		
		if(testDone) {
			System.out.println("Search Results Sayfasinda Solda Bulunan Linkler Dogru Calisiyor Mu Testi : Basarili");
		}
		else {
			System.out.println("Search Results Sayfasinda Solda Bulunan Linkler Dogru Calisiyor Mu Testi : Basarisiz");
		}
		showTestResult.showResult("Test edilen tüm sitelere basarili bir sekilde tiklanabildi.");
		
	}
	
	
	
	// Functions
	public void closeBottomPopupTest() {
		driver.get("https://leagueoflegends.fandom.com/wiki/Special:Search?scope=internal&query=jinx&ns%5B0%5D=0&ns%5B1%5D=114&ns%5B2%5D=500&ns%5B3%5D=502&ns%5B4%5D=2900");
		closeLoLWikiBottomPopupTest();
	}
	
	public void closeLoLWikiBottomPopupTest() {
		WebElement closeBtn = driver.findElement(By.xpath("//*[local-name()='svg' and @class='wds-icon wds-icon-tiny sitenotice-wrapper__close']//*[local-name()='use']"));
		closeBtn.click();
	}
	
	public void closeLolWikiBottomRightPopupTest() {
		WebElement closeBtn = driver.findElement(By.xpath("//*[local-name()='svg' and @class='wds-icon wds-icon-small close-icon']//*[local-name()='use']"));
		closeBtn.click();
	}
	
	
	public void openSearchBarPopup() throws InterruptedException {
		WebElement openSearchBtn = driver.findElement(By.xpath("//header//div[@class='wiki-tools wds-button-group']//a[@title='Search']"));
		openSearchBtn.click();
		Thread.sleep(2000);
	}
	
	public void writeExpressionToSearchBarInput(String expression) throws InterruptedException {
		driver.findElement(By.className("SearchInput-module_input__LhjJF")).sendKeys(expression);
		Thread.sleep(2000);
	}
	
	public void doClickForSearchInSearchBar() {
		WebElement searchBtn = driver.findElement(By.xpath("//button[@data-testid='search-modal__submit-search']"));
		searchBtn.click();
	}
}
