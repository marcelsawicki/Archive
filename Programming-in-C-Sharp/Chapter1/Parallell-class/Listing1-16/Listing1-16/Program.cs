using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Listing1_16
{
    class Program
    {
        static void Main(string[] args)
        {
            Parallel.For(0, 10, i =>
            {
                Thread.Sleep(1000);
                Console.WriteLine("Thread A");
            });

            var numbers = Enumerable.Range(0, 10);
            Parallel.ForEach(numbers, i => 
            {
                Thread.Sleep(1000);
                Console.WriteLine("Thread B");
            });

            string communicate = "Press SPACE to continue.";
            Console.WriteLine("{0}", communicate);
            Console.ReadKey();
        }
    }
}
