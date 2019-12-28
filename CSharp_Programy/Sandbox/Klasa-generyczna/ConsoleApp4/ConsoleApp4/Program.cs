using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp4
{
    class Program
    {
        static void Main(string[] args)
        {
            KlasaGeneryczna<int> obiektKlasyGenerycznej = new KlasaGeneryczna<int>();
            obiektKlasyGenerycznej.Dodaj(12);

            KlasaGeneryczna<string> obiektKlasyGenerycznej1 = new KlasaGeneryczna<string>();
            obiektKlasyGenerycznej1.Dodaj("napis");
            Console.ReadKey();
        }
    }

    public class KlasaGeneryczna<T>
    {
        public void Dodaj(T parametr)
        {
            Console.WriteLine("Wynik metody Dodaj: " + parametr);
        }
    }
}
