// ConsoleApplication1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <fstream>
#include <string>
using namespace std;
string imie, nazwisko;
int nr_tel;
int main()
{
    cout << "Podaj imie: "; cin >> imie;
	cout << "Podaj nazwisko: "; cin >> nazwisko;
	cout << "Podaj nr telefonu: "; cin >> nr_tel;
	fstream plik;
	plik.open("wizytowka.txt", ios::out | ios::app);
	plik << imie << endl;
	plik << nazwisko << endl;
	plik << nr_tel << endl;
	plik.close();
	return 0;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the E uture, to open this project again, go to File > Open > Project and select the .sln file
