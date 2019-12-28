using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp3
{
    class Program
    {
        static void Main(string[] args)
        {
            var inty = GenerycznaMetoda<int>(12);
            Console.WriteLine("Metoda z parametrem int: " +inty);

            var stringi = GenerycznaMetoda<string>("napis");
            Console.WriteLine("Metoda z parametrem string: " +stringi);

            Console.ReadKey();
        }

        public static T GenerycznaMetoda<T>(T parametr)
        {
            return parametr;
        }
    }
}
