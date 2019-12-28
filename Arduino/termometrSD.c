//projekt nr X - budowa szybkiego termometru z zapisem na SD
#include <SD.h>
//definicja pinów, do których podłączono diody LED:
#define HOT 13
#define NORMAL 12
#define COLD 11

float voltage = 0;
float celsius = 0;
float hotTemp = 26;
float coldTemp = 20;
float sensor = 0;

void setup()
{
  pinMode(HOT, OUTPUT);
  pinMode(NORMAL, OUTPUT);
  pinMode(COLD, OUTPUT);
  
  Serial.begin(9600);
  Serial.print("Inicjalizacja karty SD...");
  pinMode(10, OUTPUT);
  
  //sprawdza czy karta microSD jest dostepna i gotowa do uzycia
  if(!SD.begin(4))
  {
    Serial.println("Brak lub nieprawidłowe działanie karty");
    //zatrzymuje wykonywanie szkicu
    return;
  }
  Serial.println("Karta microSD jest gotowa");
}

void loop()
{
  
//tworzy plik, w którym beda zapisywane dane
File dataFile = SD.open("DATA.TXT", FILE_WRITE);
//jesli plik jest gotow, mozna zapisac dane
if(dataFile)
{
//odczytuje stan czujnika temperatury i konwertuje
//wynik na stopnie Celsjusza
for (int a=0; a < 30; a++) //8 godzin to 480 minut
{
sensor = analogRead(0);
voltage = (sensor*5000)/1024; //konwertuje wskazanie czujnika
                              // na miliwolty
voltage = voltage - 500; //odejmuje wartość przesuniecia
celsius = voltage/10; //konwertuje miliwolty na stopnie Celsjusza
dataFile.print("Zapis temperatury");
dataFile.print(a, DEC);
Serial.println(a, DEC);
dataFile.print(" Temperatura:");
dataFile.print(celsius, 2);
Serial.println(celsius, 2);
dataFile.println(" stopni Celsjusza");
delay(1000); //czeka trochę poniżej jednej minuty

} //for

dataFile.close(); //zamknięcie pliku jest konieczne
Serial.println("Koniec!");
do {} while(1);
} //if

}