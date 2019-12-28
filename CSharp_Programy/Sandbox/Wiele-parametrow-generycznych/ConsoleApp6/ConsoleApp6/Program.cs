using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp6
{
    class Program
    {
        static void Main(string[] args)
        {
            KlasaGeneryczna<int, string> obiektKlasyGenerycznej = new KlasaGeneryczna<int, string>();
            obiektKlasyGenerycznej.Dodaj(12, "napis");

            KlasaGeneryczna<int, int> obiektKlasyGenerycznej1 = new KlasaGeneryczna<int, int>();
            obiektKlasyGenerycznej1.Dodaj(12, 12);

            Console.ReadKey();
        }

        public class KlasaGeneryczna<T, T1> where T : struct
        {
            public void Dodaj(T parametr, T1 parametr1)
            {
                Console.WriteLine("Wynik metody Dodaj: " + parametr + parametr1);
            }
        }
    }
}
