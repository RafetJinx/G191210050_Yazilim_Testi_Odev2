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
