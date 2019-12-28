/* O6. Zdefiniowaæ klasê Hotel. 
 * Ka¿dy hotel ma okreœlon¹ liczbê numerowanych pokoi rozmieszczonych  na poszczególnych piêtrach.
 * Liczba piêter i liczba pokoi na ka¿dym piêtrze jest ustawiana w momencie tworzenia obiektu. 
 * Pokój jest identyfikowany przez obiekt klasy NumerPokoju (o polach: pietro i pokoj). 
 * Okreœlony pokój jest wyjêty jeœli jest z nim powi¹zany obiekt klasy Osoba 
 * (zaproponowaæ definicjê stosownej klasy). Jedna osoba mo¿e wynajmowaæ wiele pokoi.  
 * Zdefiniowaæ metody: 
 * - czy jest jakiœ wolny pokój, 
 * - ile jest wolnych pokoi, 
 * - wynajmij dowolny z wolnych pokoi podanej (jako parametr) osobie (obiekt typu Osoba); 
 *  wynikiem powinien byæ numer przydzielonego pokoju, 
 *  
 *  - czy mo¿na wynaj¹æ k s¹siednich pokoi 
 *  (wynikiem powinien byæ numer pierwszego pokoju lub null jeœli to niemo¿liwe), 
 *  - czy osoba o podanym nazwisku wynajmuje jakiœ pokój, 
 *  - które pokoje wynajmuje osoba o podanym nazwisku 
 *  (wynikiem powinna byæ tablica numerów pokoi lub null), 
 *  - zwolnij wszystkie pokoje wynajmowane przez osobê o podanym nazwisku. 
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
