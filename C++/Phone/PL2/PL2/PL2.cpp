/* pl_2.cpp Obliczanie wynagrodzenia dla autora za sprzedane ksiazki. */
#include <iostream>
#include <conio.h>
#define P 0.15 //definicja stalej rzeczywistej - procent dla autora
#define F 0.19 //procent podatku
using namespace std;
void main(void)
{
	int l, c;

	float wb, wn, pn;

	cout << "\n Obliczanie wynagrodzenia dla autora";
	cout << "\n Podaj cene ksiazki ";
	cin >> c;
	cout << " Podaj liczbe sprzedanych egzeplarzy ";
	cin >> l;
	wb = P * c * l; 	//obliczenie wynagrodzenia brutto
	pn = wb / 2 * F; 	//obliczenie podatku
	wn = wb - pn;	//obliczenie wynagrodzenia netto
	cout << "\n Wynagrodzenie brutto dla autora wynosi " << wb;
	cout << "\n Podatek od wynagrodzenia dla autora wynosi" << pn;
	cout << "\n Wynagrodzenie netto dla autora wynosi" << wn;
	cout << "\n Nacisnij dowolny klawisz" << endl;
	_getch();
}
