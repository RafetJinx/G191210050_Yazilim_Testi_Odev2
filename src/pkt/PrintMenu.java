/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 26.05.2023
* <p>
* Program.java dosyasi tarafindan menu ekranini gostermek
* icin kullanilacak olan PrintMenu sinifimizdir.
* 
* Genel Amacı: Menu ekranini gostermektir.
* </p>
*/
package pkt;

public class PrintMenu {
	public void showMenu() {
		System.out.println("----------- Test Senaryolari -----------");
	    System.out.println("1. Renk Testlerini Calistir");
	    System.out.println("2. Sayi Hesaplama Testlerini Calistir");
	    System.out.println("3. Login Testlerini Calistir");
	    System.out.println("4. Ekran Boyutu Testlerini Calistir");
	    System.out.println("5. Link Sayısı Kontrolü Teslerini Calistir");
	    System.out.println("6. Arama Testlerini Calistir");
	    System.out.println("7. Popup Testlerini Calistir");
	    System.out.println("0. Cikis");
	    System.out.println("----------------------------------------");
	    System.out.print("Seciminizi yapin (1-7): ");
	}
}
