/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 26.05.2023
* <p>
* Test siniflarimizin referans bilgisini tasiyacak ve
* hepsine ortak bir metot ekleyebilmek icin olusturmus oldugum sinif.
* 
* Genel Amacı: Test siniflarinin sahip olduklari butun testleri 
* calistirmasini gozden kacirmamak icin runAllTest metodu icermektedir.
* </p>
*/
package pkt;

public interface Test {
	public void runAllTest() throws InterruptedException;
}
