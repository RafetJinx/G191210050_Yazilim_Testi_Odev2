/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 26.05.2023
* <p>
* Testlerin sonucunda farkli gosterim sekilleri gerekli olabilir.
* Bu sinif da bu ihtiyac icin hazirlanmistir.
* 
* 
* Genel Amacı: Testlerin ortak bir cikti vermesine imkan saglamak.
* </p>
*/
package pkt;

public class ShowTestResult {
	public <T> void showResult(T exp1, T exp2) {
		System.out.println("> Beklenen Deger: " + exp1 + " "
				+ "Gelen Deger: " + exp2);
	}
	
	public void showNoResult() {
		System.out.println("> Ifade cok uzun oldugu icin kasitli olarak gosterilmemistir.");
	}
	
	public void showResult(String exp) {
		System.out.println("> " + exp);
	}
}
