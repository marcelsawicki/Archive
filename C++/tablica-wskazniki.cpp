#include <iostream>
using namespace std;

main()
{
	int *wi;
	float *wf;
	int tabint[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	float tabflo[10];
	
	// ustawienie wskaznika
	wf = &tabflo[0];
	wi = &tabint[0];
	
	// zaladowanie tablicy float wartosciami poczatkowymi
	for(int i=0; i<10; i++)
	{
		*wf++ = (float)i;
	}
	
	cout << "Tresc tablicy na poczatku.\n";
	
	for(int i=0; i<10; i++)
	{
		cout << i << ") \t" << *wi << "\t\t\t\t" << *wf << endl;
		wi++;
		wf++;
	}
	
	// nowe ustawienie wskaznikow
	wi = &tabint[5];
	wf = tabflo + 2; // czyli wf = &tabflo[2];
	
	// wpisanie do tablic kilku nowych wartosci
	for(int d=0; d<4; d++)
	{
		*(wi++)=-222;
		*(wf++)=-777.5;
	}
	
	cout << "Tresc tablic po wstawieniu nowych wartosci.\n";
	wi = tabint;
	wf = tabflo;
	
	for(int j=0; j<10; j++)
	{
		cout << "tabint[" << j << "] = " << *(wi++) << "\t\ttabflo[" << j << "] = " << *(wf++) << endl;
	}
}
