/* Lista 2, Zadanie I5:
 * Sprawdz czy liczba naturalna K jest liczba pierwsza.
 *
 * @author: Marcel Sawicki
 * @version 1.00 2013/12/11
 */
import java.util.*; // importuje ta biblioteke zeby moc uzyc klasy Scanner do odczytania wpisanej 
					// przez uzytkownika liczby K
public class Main {

	public static void main(String[] args) {
		
		System.out.println("Program sprawdza czy podana liczba K jest liczba pierwsza.");
		
		/* deklaracja zmiennych */
		Scanner rk = new Scanner(System.in);
		double k = rk.nextDouble();
		double p=1;
		
		/* glowna petla programu odpowiedzialna za sprawdzenie czy liczba K jest liczba pierwsza */
		do{
			p++;
			System.out.println("Podana liczba K: "+k+" dzile przez P: "+p);
		}while((k%p)!=0); // dopoki podana liczba K dzielona przez liczbe P ma reszte z dzielenia rozna od 0
		
		/* sprawdzenie warunkow i wyswietlenie rezultatu */
		if(p==k) // liczba pierwsza to taka liczba ktora jest podzielna przez 1 oraz sama siebie
		{
			System.out.println("Tak, podana liczba K jest liczba pierwsza.");
		}
		else // wynika stad ze liczba jest podzielna przez 1, sama siebie oraz inne/inna liczbe
		{
			if(k%p==0) // sprawdzam czy podana liczba K dzielona przez naliczone P nie ma reszty z dzielenia.
			{
				System.out.println("Nie, podana liczba K nie jest liczba pierwsza.");
			}
		};
	} // koniec metody main
} // koniec klasy Main