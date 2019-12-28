/* Jest dany ciag n liczb rzeczywistych. Oblicz:
 * b) srednia arytmetyczna dodatnich liczb ciagu
 */

public class Main {
	public static void main(String[] args) {
		int suma = 0;
		int[] ciagLiczbRzeczywistych = {1, -2, 3, -4, 5, -6, 7, -8};
		
		for(int k=0;k<=ciagLiczbRzeczywistych.length-1;k++) {
			if(ciagLiczbRzeczywistych[k]>=0) {
			suma += ciagLiczbRzeczywistych[k];
			System.out.println("Suma: " +suma);
			}
		}
		
		// TODO: ostatecznie ma byc srednia arytmetyczna, a nie suma
		System.out.println("Ostatecznie Suma wynosi:" +suma);
	}
}
