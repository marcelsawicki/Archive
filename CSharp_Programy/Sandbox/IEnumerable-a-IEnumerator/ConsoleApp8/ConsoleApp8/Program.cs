using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp8
{
    class Program
    {
        static void Main(string[] args)
        {
            IEnumerable<string> enumerable = new string[] { "A", "B", "C" };

            // Z uzyciem foreach dostepnego w IEnumerable

            foreach(string s in enumerable)
                Console.WriteLine(s);

            // Z uzyciem enumeratora
            IEnumerator<string> enumerator = enumerable.GetEnumerator();

            while (enumerator.MoveNext())
            {
                string s = enumerator.Current;
                Console.WriteLine(s);
            }

            Console.ReadLine();
        }
    }
}
