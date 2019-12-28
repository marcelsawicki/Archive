using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class Program
    {
        static void Main(string[] args)
        {
            Delegat d = new Delegat();

            Delegat.Delegat1 dodawanie = new Delegat.Delegat1(d.Dodawanie);
            int wynikDodawania = dodawanie(2, 2);
            Console.WriteLine("Wynik dodawania: {0}", wynikDodawania.ToString());


            Delegat.Delegat1 odejmowanie = new Delegat.Delegat1(d.Odejmowanie);
            int wynikOdejmowania = odejmowanie(2, 2);
            Console.WriteLine("Wynik odejmowania: {0}", wynikOdejmowania.ToString());

            Console.ReadLine();
        }
    }
}
