using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp9
{
    class Program
    {
        private static IEnumerable<int> PobierzDane()
        {
            Console.WriteLine("Poczatek merody PobierzDane.");

            List<int> list = new List<int>();

            for (int i = 1; i <= 10; i++)
            {
                Console.WriteLine("Aktualna wartosc: {0}", i);
                yield return i;
            }
        }

        static void Main(string[] args)
        {
            Console.WriteLine("Pobranie danych.");
            IEnumerable<int> data = PobierzDane();

            Console.WriteLine("Rozpoczecie petli.");
            foreach (var i in data)
            {
                Console.WriteLine("Odczyt wartosci w petli: {0}", i);

                if (i > 6)
                    break;
            }

            Console.WriteLine("Koniec programu.");
            Console.ReadLine();
        }
    }
}
