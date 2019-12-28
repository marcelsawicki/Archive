/* Jest dany ciag n liczb rzeczywistych. Oblicz:
 * a) sume wszystkich liczb ciagu
 */

public class Main {
	public static void main(String[] args) {
		int suma = 0;
		int[] ciagLiczbRzeczywistych = {1, -2, 3, -4, 5, -6, 7, -8};
		
		for(int k=0;k<=ciagLiczbRzeczywistych.length-1;k++) {
			suma += ciagLiczbRzeczywistych[k];
			System.out.println("Suma: " +suma);
		}
		System.out.println("Ostatecznie Suma wynosi:" +suma);
	}
}
