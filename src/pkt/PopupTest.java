package pkt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupTest implements Test {
	private WebDriver driver;
	private ShowTestResult showTestResult;
	
	public PopupTest(WebDriver driver, ShowTestResult showTestResult) {
		super();
		this.driver = driver;
		this.showTestResult = showTestResult;
	}

	@Override
	public void runAllTest() throws InterruptedException {
		closeLolWikiBottomLeftPopupTest();
		Thread.sleep(1500);
		
		closeLolWikiBottomRightPopupTest();
		Thread.sleep(1500);

		openSearchBarPopopTest();
		Thread.sleep(1500);
		
		writeExpressionToSearchBarInputTest("jinx");
		Thread.sleep(1500);

		deleteWritedExpressionToSearchBar("jinx");
		Thread.sleep(1500);
	}
	
	//    https://leagueoflegends.fandom.com/wiki/List_of_champions

	public void closeLolWikiBottomLeftPopupTest() throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/League_of_Legends_Wiki");
		Thread.sleep(1500);
		WebElement closeBtn = driver.findElement(By.xpath("//*[local-name()='svg' and @class='wds-icon wds-icon-tiny sitenotice-wrapper__close']//*[local-name()='use']"));
		closeBtn.click();
		Thread.sleep(1500);
		
		showTestResult.showResult("LoL Wiki Sayfasinin Sol Altinda Yer Alan Popup Kapatma Testi: Basarili");
	}
		
	public void closeLolWikiBottomRightPopupTest() throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/List_of_champions");
		Thread.sleep(1500);
		WebElement closeBtn = driver.findElement(By.xpath("//*[local-name()='svg' and @class='wds-icon wds-icon-small close-icon']//*[local-name()='use']"));
		closeBtn.click();
		Thread.sleep(1500);

		showTestResult.showResult("LoL Wiki Sayfasinin Sag Altinda Yer Alan Popup Kapatma Testi: Basarili");
	}
	
	public void openSearchBarPopopTest() throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/List_of_champions");
		WebElement openSearchBtn = driver.findElement(By.xpath("//header//div[@class='wiki-tools wds-button-group']//a[@title='Search']"));
		Thread.sleep(1500);
		openSearchBtn.click();
		Thread.sleep(1500);

		showTestResult.showResult("LoL Wiki Sayfasinda Arama Butonu Tıklama Testi: Basarili");
	}
	
	public void writeExpressionToSearchBarInputTest(String expression) throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/List_of_champions");
		Thread.sleep(1500);
		// open search btn
		WebElement openSearchBtn = driver.findElement(By.xpath("//header//div[@class='wiki-tools wds-button-group']//a[@title='Search']"));
		
		openSearchBtn.click();
		Thread.sleep(1500);
		
		driver.findElement(By.className("SearchInput-module_input__LhjJF")).sendKeys(expression);
		Thread.sleep(1500);
		
		showTestResult.showResult("LoL Wiki Sayfasinda Arama Cubuguna Yazilan Ifadenin Silinme Testi: Basarili");
	}
	
	public void deleteWritedExpressionToSearchBar(String expression) throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/List_of_champions");
		Thread.sleep(1500);
		WebElement openSearchBtn = driver.findElement(By.xpath("//header//div[@class='wiki-tools wds-button-group']//a[@title='Search']"));
		
		openSearchBtn.click();
		Thread.sleep(1500);
		
		String start = driver.findElement(By.className("SearchInput-module_input__LhjJF")).getText();
		
		driver.findElement(By.className("SearchInput-module_input__LhjJF")).sendKeys(expression);
		
		WebElement clearBtn = driver.findElement(By.xpath("//form//button[@class='wds-button SearchInput-module_clearButton__TioEW wds-is-text']"));
		
		clearBtn.click();
		Thread.sleep(1500);

		String end = driver.findElement(By.className("SearchInput-module_input__LhjJF")).getText();
		
		if(start.equals(end)) {
			System.out.println("Arama Alanina Girilen Ifadeyi Silme Testi: Basarili");
		}
		else {
			System.out.println("Arama Alanina Girilen Ifadeyi Silme Testi: Basarisiz");
		}
		
		Thread.sleep(1500);
	}
}
