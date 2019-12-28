int RedPin = 8;
int GreenPin = 10;
int BluePin = 9;
int Zielona = 11;
int Czerwona = 12;
int Brzeczyk = 13;

void setup() { 
   pinMode(RedPin, OUTPUT); 
   pinMode(GreenPin, OUTPUT); 
   pinMode(BluePin, OUTPUT); 
   pinMode(Zielona, OUTPUT); //moja modyfikacja
   pinMode(Czerwona, OUTPUT); //moja modyfikacja
   pinMode(Brzeczyk, OUTPUT); //moja modyfikacja
}

void loop() 
{  digitalWrite(Zielona,HIGH); //moja modyfikacja
   delay(500);                 //moja modyfikacja
   digitalWrite(Zielona, LOW); //moja modyfikacja
   
   digitalWrite(Czerwona,HIGH); //moja modyfikacja
   delay(500);                 //moja modyfikacja
   digitalWrite(Czerwona, LOW); //moja modyfikacja
   
   analogWrite(Brzeczyk,128); //moja modyfikacja
   delay(1000);   //moja modyfikacja
   digitalWrite(Brzeczyk, LOW); //moja modyfikacja
   
   digitalWrite(GreenPin, LOW);
   delay(1000);
   digitalWrite(GreenPin, HIGH);
   digitalWrite(BluePin, LOW);
   delay(1000);
   digitalWrite(BluePin, HIGH);
   digitalWrite(RedPin, LOW);
   delay(1000);
   digitalWrite(RedPin, HIGH);
}