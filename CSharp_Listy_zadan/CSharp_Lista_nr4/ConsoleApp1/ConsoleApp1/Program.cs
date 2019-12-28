using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    
        class Program
    {
		static double ObliczWartosc(List<Towar> lista)
		{
			double wartosc = 0;

			foreach(Towar t in lista)
			{
				wartosc += t.cenaBrutto * t.ilosc;
			}
			return wartosc;
		}
        static void Main(string[] args)
        {

            Towar towar = new Towar();
            // string nazwa, string typ, double cenaNetto, int ilosc
            Towar towar1 = new Towar("woda", "napoj", 2.00, 2);
            Towar towar2 = new Towar("sok", "napoj", 3.50, 7);

            // wlasnosci
            Towar towar3 = new Towar() { nazwa = "lemoniada", typ = "napoj", cenaNetto=5.25, ilosc=3 };


			TowarZagraniczny towar4 = new TowarZagraniczny("banany", "owoce tropikalne", 5.0, 100, 10.0);
			TowarZagraniczny towar5 = new TowarZagraniczny("kokosy", "orzechy", 9.0, 100, 15.0);

			List<Towar> lista = new List<Towar>();

			lista.Add(towar1);
			lista.Add(towar2);
			lista.Add(towar3);
			lista.Add(towar4);
			lista.Add(towar5);

			foreach (Towar t in lista)
			{
				System.Console.WriteLine(t);
			}

			System.Console.WriteLine("Wartosc wszystkich towarów w magazynie wynosi: "+ ObliczWartosc(lista)+" zł.");
            System.Console.ReadLine();
        }
    }
}
