using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    
        class Program
    {
        static void Main(string[] args)
        {
            //int liczbaA = 5;
            //int liczbaB = 10;
            Towar towar = new Towar();
            // string nazwa, string typ, double cenaNetto, int ilosc
            Towar towar1 = new Towar("Woda", "Napoj", 2.00, 2);
            Towar towar2 = new Towar("Sok", "Napoj", 3.50, 7);

            // wlasnosci
            Towar towar3 = new Towar() { nazwa = "Mleko", typ = "Napoj", cenaNetto=5.25, ilosc=3 };
            System.Console.WriteLine(towar1);
            System.Console.WriteLine(towar2);
            System.Console.WriteLine(towar3);
            //towar1.average(1, 2, 3, 4);
            //towar1.average(29.4, 2.4, 3.5, 4.5, 77.6, 33.2);
            //System.Console.WriteLine("LiczbaA: " + liczbaA + ", LiczbaB: " + liczbaB);
            //towar1.swap(ref liczbaA, ref liczbaB);
            //System.Console.WriteLine("LiczbaA: " + liczbaA + ", LiczbaB: " + liczbaB);
            System.Console.ReadLine();
        }
    }
}
