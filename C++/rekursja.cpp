#include <iostream>
using namespace std;
int x=1;
class Rekurencja {
	public:
		int silnia(int);
	};	
	
	int Rekurencja::silnia(int liczba)
	{
		if(liczba==0)
		{
			return 1;
		}
		else
		{
			return liczba*silnia(liczba-1);
		}
	};


int main()
{
	
    cout << "Rekursja, Silnia(x).\n";
    cout << "x= ";
    Rekurencja rekurencja;
    cin >> x;
    cout << rekurencja.silnia(x);
	return 0;
}

