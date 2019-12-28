#include <iostream>
#include <cstdlib>
#include <time.h>
#include <stdio.h>

using namespace std;

int liczba, strzal, ile_prob=0;
int main()

{
    cout << "Witaj! Pomyslalam sobie liczbe od 1 do 100" << endl;
    srand (time(NULL));
    liczba=rand()%100+1;


    while (strzal!=liczba)
    {
        ile_prob++;
        cout << "Zgadnij jaka (to Twoja "<<ile_prob<< " proba):" << endl;
        cin >> strzal;

        if (strzal==liczba)
            cout << "Super! Trafiles! Wygrywasz w "<<ile_prob<<" probie."<< endl;
        else if (strzal<liczba)
            cout << "Za malo!" << endl;
        else if (strzal>liczba)
            cout << "Za duzo!" << endl;
    }
getchar();getchar();
    return 0;
}
