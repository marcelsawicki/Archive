/*
Procedura wyszukiwanie liniowe z warownikiem(A, n, x)

Wejscie wyjscie takie samo jak w wyszukiwaniu liniowym.

1. Przechowaj A[n] w zmiennej ostatni, po czym podstaw x do A[n]
2. Ustaw i na 1
3. Dopoki A[i] != x, wykonuj co nastepuje:
	A. Zwieksz i
4. Odtworz A[n] z ostatniego
5. Jesli i < n lub A[n] = x, to zwroc wartosc i jako wynik.
6. W przeciwnym razie zwroc jako wynik Nie-znaleziono.
*/

#include <iostream>
using namespace std;

int x=1;
int tablica[6] = { 2, 5, 6, 12, 7, 8 };
	
class Szukajacy {
	public:
		int znajdz(int, int[]);
	};	
	
	int Szukajacy::znajdz(int liczba, int tablica[])
	{		
		for(int k=0; k < 6; k++)
		{
			if(tablica[k]==liczba)
			{
				cout << "znalazlem" << endl;
			}
			
			cout << "petla for:" << k << "\n";
		}
		return 0;
	};


int main()
{

    cout << "Wyszukiwanie liniowe.\n";
    
    cout << "Dlugosc tablicy: ";
	int arraySize = sizeof(tablica)/sizeof(tablica[0]);
	cout << arraySize << endl;
	
    cout << "Jakiej wartosci szukac? x= ";
    Szukajacy szukajacy;
    cin >> x;
    cout << szukajacy.znajdz(x, tablica);
	return 0;
}


