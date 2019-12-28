/* O6. Zdefiniowa� klas� Hotel. 
 * Ka�dy hotel ma okre�lon� liczb� numerowanych pokoi rozmieszczonych  na poszczeg�lnych pi�trach.
 * Liczba pi�ter i liczba pokoi na ka�dym pi�trze jest ustawiana w momencie tworzenia obiektu. 
 * Pok�j jest identyfikowany przez obiekt klasy NumerPokoju (o polach: pietro i pokoj). 
 * Okre�lony pok�j jest wyj�ty je�li jest z nim powi�zany obiekt klasy Osoba 
 * (zaproponowa� definicj� stosownej klasy). Jedna osoba mo�e wynajmowa� wiele pokoi.  
 * Zdefiniowa� metody: 
 * - czy jest jaki� wolny pok�j, 
 * - ile jest wolnych pokoi, 
 * - wynajmij dowolny z wolnych pokoi podanej (jako parametr) osobie (obiekt typu Osoba); 
 *  wynikiem powinien by� numer przydzielonego pokoju, 
 *  
 *  - czy mo�na wynaj�� k s�siednich pokoi 
 *  (wynikiem powinien by� numer pierwszego pokoju lub null je�li to niemo�liwe), 
 *  - czy osoba o podanym nazwisku wynajmuje jaki� pok�j, 
 *  - kt�re pokoje wynajmuje osoba o podanym nazwisku 
 *  (wynikiem powinna by� tablica numer�w pokoi lub null), 
 *  - zwolnij wszystkie pokoje wynajmowane przez osob� o podanym nazwisku. 
 *  Zaproponuj ewentualne inne metody klasy Hotel
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel grand = new Hotel(2,5); // liczba pieter, liczba pokoi
		Osoba osoba1 = new Osoba("Jan", "Aronia"); 
		Osoba osoba2 = new Osoba("Mariusz", "Brzoskwinia");
		Osoba osoba3 = new Osoba("Janina", "Agrest"); 
		List<Osoba> kolekcjaOsob = new LinkedList<>();
		kolekcjaOsob.add(osoba1);
		kolekcjaOsob.add(osoba2);
		
		grand.wynajmijPokoj(1, osoba1);
		grand.wynajmijPokoj(4, osoba2);
		
		grand.informacjePokoj(1);
		grand.informacjePokoj(2);
		grand.informacjePokoj(3);
		grand.informacjePokoj(4);
		grand.informacjePokoj(5);
		
		System.out.println("\nWolne pokoje: ");
		grand.wolnePokoje();
		
		System.out.println("\nWolnych pokoi jest: "+grand.ileJestWolnychPokoi());
		grand.ktorePokojeWynajmujeOsobaOPodanymNazwisku("Aronia");
		grand.czyOsobaOPodanymNazwiskuWynajmujePokoj("Agrest");
		grand.czyOsobaOPodanymNazwiskuWynajmujePokoj("Brzoskwinia");
		grand.zwolnijWszystkiePokojeWynajmowanePrzezOsobeOPodanymNazwisku("Brzoskwinia");
		grand.czyOsobaOPodanymNazwiskuWynajmujePokoj("Brzoskwinia");
		int zmienna = 0;
		do {
			Menu.display(args);
			Scanner s = new Scanner(System.in);
			zmienna = s.nextInt();
			System.out.println("Wprowadzono: "+zmienna);	
//			s.close();
			switch(zmienna) {
			case 1: { 
				System.out.println("przypadek 1"); 
				Osoba osoba4 = new Osoba("Wiktor", "Pomidor");
				grand.wynajmijPokoj(3, osoba4);
				break; 
				}
			case 2: { System.out.println("przypadek 2"); break; }
			case 3: { 
				System.out.println("\nWolnych pokoi jest: "+grand.ileJestWolnychPokoi()); 
				break; 
				}
			case 4: { System.out.println("przypadek 4"); break; }
			case 5: { System.out.println("przypadek 5"); break; }
			}
		}
		while(zmienna!=6);
	}

}
