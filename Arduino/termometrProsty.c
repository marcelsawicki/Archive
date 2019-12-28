//projekt nr 8 - budowa szybkiego termometru

//definicja pinów, do których pod³¹czono diody LED:
#define HOT 6
#define NORMAL 4
#define COLD 2

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
}

void loop()
{
//odczytuje stan czujnika temperatury i konwertuje
//wynik na stopnie Celsjusza

sensor = analogRead(0);
voltage = (sensor*5000)/1024; //konwertuje wskazanie czujnika
                              // na miliwolty
voltage = voltage - 500; //odejmuje wartoœæ przesuniecia
celsius = voltage/10; //konwertuje miliwolty na stopnie Celsjusza

//obs³uga przedzia³ów temeperatur
if(celsius < coldTemp)
{
    digitalWrite(COLD, HIGH);
    delay(1000);
    digitalWrite(COLD, LOW);
}
else if(celsius > coldTemp && celsius <= hotTemp)
{
    digitalWrite(NORMAL, HIGH);
    delay(1000);
    digitalWrite(NORMAL, LOW);
}
else
{
    //celsius > hotTemp
    digitalWrite(HOT, HIGH);
    delay(1000);
    digitalWrite(HOT, LOW);
}
}