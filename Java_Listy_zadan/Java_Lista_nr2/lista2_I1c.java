/* Jest dany ciag n liczb rzeczywistych. Oblicz:
 * c) srednia arytmetyczna liczb wystepujacych bezposrednio po liczbach
 * dodatnich.
 */

public class Main {
	public static void main(String[] args) {
		int suma = 0;
		int[] ciagLiczbRzeczywistych = {1, -2, 3, -4, 5, -6, 7, -8};
		int szukaneLiczby = 0;
		int ileLiczb = 0;
		
		for(int k=0;k<=ciagLiczbRzeczywistych.length-1;k++) {
			if(ciagLiczbRzeczywistych[k]>=0) {
					szukaneLiczby += ciagLiczbRzeczywistych[k+1];
					ileLiczb++;
			// szukam liczby wystepujace bezposrednio po liczbach dodatnich
			suma += ciagLiczbRzeczywistych[k];
			System.out.println("Suma: " +suma);
			}
		}
		System.out.println("srednia arytmetyczna liczb po liczbach dodatnich:" +szukaneLiczby/ileLiczb);
	}
}
