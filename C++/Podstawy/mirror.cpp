#include <iostream>

using namespace std;


int main()
{
    string napis;
    cout << "Podaj napis do odwrocenia:" << endl;
    getline(cin,napis);

    int dlugosc=napis.length();

    for (int i=dlugosc-1; i>=0; i--)
    {
        cout << napis [i];
    }
    return 0;
}