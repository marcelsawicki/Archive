#include <iostream>
#include <fstream>

using namespace std;

string imie, nazwisko;
int nr_tel;

int main()
{
    fstream plik;
    plik.open("wizytowka.txt", ios::in);
    
    if(plik.good()==false)

    plik<<imie<<endl;
    plik<<nazwisko<<endl;
    plik<<nr_tel<<endl;

    plik.close();
    return 0;
}