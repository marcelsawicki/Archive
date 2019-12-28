#include <iostream>
#include <string.h>

using namespace std;

/* definicja klasy */

class osoba
{
		char nazwisko[80];
		int wiek;
		
		public:
			void zapamietaj(char *napis, int lata);
			
			void wypisz()
			{
				cout << "\t" << nazwisko << ", lat: " << wiek << endl;
			}
};

void osoba::zapamietaj(char *napis, int lata)
{
	strcpy(nazwisko, napis);
	wiek = lata;
}

main()
{
	osoba student1, student2, profesor, pilot;
	
	cout << "Dla informacji podaje, ze jeden obiekt klasy osoba ma rozmiar: " << sizeof(osoba) << " bajty. To samo inaczej: " << sizeof(student1) << endl;
	
	profesor.zapamietaj("Albert Einstein", 55);
	student1.zapamietaj("Rudgier Schubert", 26);
	student2.zapamietaj("Claudia Bach", 25);
	pilot.zapamietaj("Neil Armstrong", 37);
	
	cout << "Po wpisaniu informacji do obiektow. Sprawdzamy: \n";
	
	cout << "- dane z obiektu profesor \n";
	profesor.wypisz();
	
	cout << "- dane z obiektu student1 \n";
	student1.wypisz();
	
	cout << "- dane z obiektu student2 \n";
	student2.wypisz();
	
	cout << "- dane z obiektu pilot \n";
	pilot.wypisz();	
	
	cout << "Podaj swoje nazwisko (tylko nazwisko): ";
	char magazynek[80];
	cin >> magazynek;
	
	cout << "Podaj swoj wiek: ";
	int ile;
	cin >> ile;
	
	pilot.zapamietaj(magazynek, ile);
	
	cout << "Oto dane ktore teraz sa zapamietan w obiektach profesor i pilot. \n";
	
	profesor.wypisz();
	pilot.wypisz();
	
}
