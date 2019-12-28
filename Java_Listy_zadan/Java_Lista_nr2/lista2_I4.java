/*Lista 2, Zadanie I4:
 * Jaka jest najwieksza cyfra liczby natrualnej K?
 *
 * 
 * @author: Marcel Sawicki
 * @version 1.00 2013/12/11
 */

public class Main {
	
	public static void main(String[] args){
		
		/* deklaracja zmiennych */
		int liczba;
		int kolejna_cyfra;
		int max_a=0;
		liczba=1239876088; // dana liczba natralna K
		
		/* poczatkowe komunikaty z danymi */
		System.out.println("Dana liczba naturalna K: " +liczba);
		System.out.print("Kolejne cyfry liczby K: ");
		/* petla odpowiedzialna za znalezienie najwiekszej cyfry liczby naturalnej K */
		while(liczba>0){
			kolejna_cyfra=liczba % 10;
			if(kolejna_cyfra>max_a)
			{
				max_a=kolejna_cyfra;
			};

			System.out.print(kolejna_cyfra+", ");
			liczba/=10;
		};
		
		/* wyswietlenie rezultatu obliczen */
		System.out.println();
		System.out.println("Najwieksza cyfra liczby naturalnej K to: " +max_a);
		
	} // koniec metody main
} // koniec klasy Main