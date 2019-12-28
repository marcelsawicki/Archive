using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp7Decorator
{
/****************************************
*   Wzorzec Projektowy Decorator        *
*   (dekorator)                         *  
*   www.algorytm.org                    *
*   Opracowal Dworak Kamil              *
*****************************************/

    /* Standardowy nieudekorowany samochod */
    abstract class Samochod
    {
        protected string samochod = "Samochod podstawowy";

        virtual public String about()
        {
            return samochod;
        }

        public abstract double cena();
    }
    /* abstrakcyjny dekorator */
    abstract class Dekorator : Samochod
    {
        public abstract override String about();
    }

    /* teraz mamy 2 przykladowe marki samochodow */
    class Mercedes : Samochod
    {

        public Mercedes()
        {
            samochod = "Mercedes";
        }

        public override double cena()
        {
            return 500000;
        }
    }

    class Fiat : Samochod
    {

        public Fiat()
        {
            samochod = "Fiat";
        }

        public override double cena()
        {
            return 100000;
        }
    }

    /* czas na same dodatki */
    class Klimatyzacja : Dekorator
    {
        Samochod car;

        public Klimatyzacja(Samochod samochod)
        {
            car = samochod;
        }

        public override String about()
        {
            return car.about() + " + klimatyzacja";
        }

        public override double cena()
        {
            if (car is Mercedes)
            {
                return car.cena() + 100000;
            }
            else if (car is Fiat)
            {
                return car.cena() + 20000;
            }
            return 0;
        }
    }

    class OponyZimowe : Dekorator
    {
        Samochod car;

        public OponyZimowe(Samochod samochod)
        {
            car = samochod;
        }

        public override String about()
        {
            return car.about() + " + opony zimowe";
        }

        /* niech ceny beda takie same */
        public override double cena()
        {
            return car.cena() + 31234;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Samochod s1 = new Mercedes();
            Samochod s2 = new Fiat();

            Console.WriteLine("\nBez wyposazenia");
            Console.WriteLine(s1.about() + " " + s1.cena());
            Console.WriteLine(s2.about() + " " + s2.cena());

            //dodajemy po klimie

            s1 = new Klimatyzacja(s1);
            s2 = new Klimatyzacja(s2);
            Console.WriteLine("\nZ Klima");
            Console.WriteLine(s1.about() + " " + s1.cena());
            Console.WriteLine(s2.about() + " " + s2.cena());

            // i opony

            s1 = new OponyZimowe(s1);
            s2 = new OponyZimowe(s2);
            Console.WriteLine("\nZ oponami");
            Console.WriteLine(s1.about() + " " + s1.cena());
            Console.WriteLine(s2.about() + " " + s2.cena());

            //odrazu tworzymy wyposazony samochod
            Console.WriteLine("\nPelne wyposazenie");
            Samochod s3 = new OponyZimowe(new Klimatyzacja(new Mercedes()));
            Console.WriteLine(s3.about() + " " + s3.cena());
            Console.ReadLine();
        }
    }
}
