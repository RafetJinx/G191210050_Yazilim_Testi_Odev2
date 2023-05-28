/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 26.05.2023
* <p>
* Renk testi gerceklestirecek olan sınıfımız. 
* Test arayuzunu implemente etmektedir
* 
* Genel Amacı: Site icerisinde renkli bir alan dogru ifade 
* edildi mi kontrolu gerceklestirecek
* </p>
*/
package pkt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class ColorTest implements Test {
	private WebDriver driver;
	private ShowTestResult showTestResult;
	
	public ColorTest(WebDriver driver, ShowTestResult showTestResult) {
		super();
		this.driver = driver;
		this.showTestResult = showTestResult;
	}
	
	@Override
	public void runAllTest() throws InterruptedException {
		listOfChampionsPageColorKeyTest();
		Thread.sleep(1000);
	}
	
	/*
	 * List of Champions sayfasinda yer alan color key'in rengi test ediliyor. 
	 */
	public void listOfChampionsPageColorKeyTest() throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/List_of_champions");
		Thread.sleep(1000);
		String colorKey = "#cc3333";
		
		WebElement tdSpan = driver.findElement(By.xpath("//td[contains(@style, 'text-align')]/span[contains(@style, 'font-weight')]"));
		String rgb = tdSpan.getCssValue("color");
		String hexValue = Color.fromString(rgb).asHex();
		
		if(colorKey.equals(hexValue)) {
			System.out.println("List of Champions Sayfasindaki Color Key Testi: Basarili");
		} else {
			System.out.println("List of Champions Sayfasindaki Color Key Testi: Basarisiz");
		}
		showTestResult.showResult(colorKey, hexValue);
		
	}
	
	
	
	
	public void mapLeagueOfLegendsBackgroundColorTest() throws InterruptedException {
		driver.get("https://leagueoflegends.fandom.com/wiki/Map_(League_of_Legends)");
		Thread.sleep(1000);
		//String bgColor = "";
		
		//WebElement td = driver.findElement(By.)
	}


}
