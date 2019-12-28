#include <iostream>

using namespace std;

int uczniowie, cukierki, x, y;

int main()
{
    cout << "Ilu uczniow jest w Twojej klasie:";
    cin >> uczniowie;

    cout << "Ile cukierkow kupila mama:";
    cin >> cukierki;

    x=cukierki/(uczniowie-1);
    y=cukierki-x*(uczniowie-1);

    cout << "Tyle cukierkow dostanie kazdy uczen: " << x << endl;

    cout << "Tyle cukierkow zostanie dla Jasia na wieczor: " << y;

    return 0;

}
