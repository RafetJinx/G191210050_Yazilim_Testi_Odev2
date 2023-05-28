/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 26.05.2023
* <p>
* Program.java Projemin main dosyası gorevini gormektedir.
* 
* 
* Genel Amacı: Tüm projeyi calistiracak olan dosyamizdir.
* </p>
*/
package pkt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chrome-driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		ShowTestResult showTestResult = new ShowTestResult();
		PrintMenu printMenu = new PrintMenu();
		
		MaximizeChromeTest maximizeChrome = new MaximizeChromeTest(driver, showTestResult);
		maximizeChrome.maximizeWindow();	
		
		
		Scanner scanner = new Scanner(System.in); 
		boolean exit = false;
		int choice;
		
		Map<Integer, Test> menuOptions = new HashMap<>();
		
		menuOptions.put(1, new ColorTest(driver, showTestResult));
		menuOptions.put(2, new CountTest(driver, showTestResult));
		menuOptions.put(3, new LoginTest(driver, showTestResult));
		menuOptions.put(4, new MaximizeChromeTest(driver, showTestResult));
		menuOptions.put(5, new PageCounterTest(driver, showTestResult));
		menuOptions.put(6, new SearchTest(driver, showTestResult));
		menuOptions.put(7, new PopupTest(driver, showTestResult));
		
		do {
			printMenu.showMenu();
			
			choice = scanner.nextInt();
			
			if(choice == 0) {
				exit = true;
			}
			else if(choice >= 1 && choice <= 7) {
				Test test = menuOptions.get(choice);
				test.runAllTest();
			}
			else {
				System.out.println("Verilen seçenekler arasında bir seçim yapınız.");
			}
		} while(!exit);
		
		scanner.close();
		
		
		driver.quit();
		
		
		
	}
}
