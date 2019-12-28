#include <iostream>
using namespace std;
void zer(int wart, int &ref);
/********************************************************************/

main()
{
	int a = 44, b = 77;
	cout << "Przed wywoaleniem funkcji: zer \n";
	cout << "a = " << a << ", b = " << b << endl;
	
	zer(a, b);
	
	cout << "Po powrocie z funkcji: zer \n";
	cout << "a = " << a << ", b = " << b << endl;
}

void zer(int wart, int &ref)
{
	cout << "\tW funkcji zer przed zerowaniem \n";
	cout << "\twart = " << wart << ", ref = " << ref << endl;
	
	wart = 0;
	ref = 0;
	
	cout << "\tW funkcji zer po zerowaniu \n";
	cout << "\twart = " << wart << ", ref = " << ref << endl;
}
