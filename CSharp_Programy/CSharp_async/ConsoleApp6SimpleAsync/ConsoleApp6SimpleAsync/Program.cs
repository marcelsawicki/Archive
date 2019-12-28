using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleApp6SimpleAsync
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("Uruchamiam metode asynchroniczna.");
            MyMethodAsync();
            Console.WriteLine("Zakonczylem. Przeskakuje do metody synchronicznej.");
            Console.WriteLine("Uruchamiam metode synchroniczna.");
            MyMethod();
            Console.WriteLine("Powracam do metody asynchronicznej i wykonuje odliczanie.");
            Console.ReadKey();
        }

        static async Task MyMethodAsync()
        {
            // Do asynchronous work.
            Console.WriteLine("Wykonuje metode asynchroniczna.");
            await Task.Delay(1000);
            Console.WriteLine("Wykonuje odliczanie w metodzie asynchronicznej.");
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine("Odliczam: " + i);
            }
        }


        static void MyMethod()
        {
            // Do synchronous work.
            Thread.Sleep(1000);
            Console.WriteLine("Wykonuje metode synchroniczna.");
        }
    }
}
