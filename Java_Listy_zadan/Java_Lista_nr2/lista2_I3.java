/* Lista 2, Zadanie I3:
 * Ile cyfr znaczacych ma dana liczba naturalna K?
 *
 * excercise I3 from list no. 2
 * @author: Marcel Sawicki
 * @version 1.00 2013/12/11
 */

public class Main{

	public static void main(String[] args){
		
		/* deklaracja zmiennych */
		int liczba;
		int kolejna_cyfra;
		int ile=0;
		liczba=123; // w tym miejscu mozemy zdefiniowac dana liczbe  K do obliczen
		
		System.out.print("Kolejne cyfry liczby K to: ");
		while(liczba>0){
			kolejna_cyfra=liczba % 10; // operator calkowitoliczbowy, reszta z dzielenia
			System.out.print(kolejna_cyfra+", ");
			liczba/=10;
			ile++;
		};
		
		/* wyswietlenie koncowego wyniku */
		System.out.println();
		System.out.println("Cyfr znaczacych: "+ile);
	} //main
}