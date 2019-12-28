/* Lista 2, Zadanie I2:
 * Oblicz sume cyfr danej liczby naturalnej K. Wykorzystaj dwuargumentowy operator
 * calkowitoliczbowy % ("modulo" - reszta z dzielenia): "A%B" daje reszte z dzielenia A przez B.
 * 
 * @author: Marcel Sawicki
 * @version 1.00 2013/12/11
 */

public class Main{

	public static void main(String[] args){
		
		/* deklaracja zmiennych */
		int liczba;
		int kolejna_cyfra;
		int ile=0;
		liczba=1234567890; // w tym miejscu mozemy zdefiniowac dowolna liczbe
		int komunikatLiczba = liczba;
		
		/* petla odpowiedzialna za obliczenia */
		while(liczba>0){
			kolejna_cyfra=liczba % 10; // operator calkowitoliczbowy
			System.out.println("Reszta z dzielenia przez 10:"+ kolejna_cyfra);
			liczba/=10;
			ile=ile+kolejna_cyfra;
		};
		
		/* koncowy komunikat z wynikiem obliczen */
		System.out.println("Suma cyfr danej liczby ("+komunikatLiczba+") wynosi: "+ile);
		
	} // koniec metody main
} // koniec klasy Main