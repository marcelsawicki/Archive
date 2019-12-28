using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;
using System.Threading;

namespace ConsoleApp6MyFirstAsync
{
    class Program
    {
                static void Main(string[] args)
                {
                    MyThreadClass oMyThreadClass = new MyThreadClass();
                    Thread oThread = new Thread(new ThreadStart(oMyThreadClass.Run));
                    oThread.Start();
                    Console.WriteLine("Stan dodanego wątku:" + oThread.ThreadState);
                    Console.WriteLine("Priorytet dodanego wątku:" + oThread.Priority);
                    Console.WriteLine("Oczekiwanie na zakończenie wątku...");
                    oThread.Join();
                    Console.WriteLine("Stan głównego wątku:"+Thread.CurrentThread.ThreadState);
                    Console.WriteLine("Priorytet głównego wątku:" + Thread.CurrentThread.Priority);
                    Console.WriteLine("Stan dodanego wątku:" + oThread.ThreadState);
                    Console.ReadKey();
                }
            }

            class MyThreadClass
            {
            public MyThreadClass()
            {
             }

        public void Run()
        {
            Console.WriteLine("Rozpoczynam pracę...");
            // Jakieś długie operacje
            Console.WriteLine("Test uśpienia wątku...");
            Thread.Sleep(500);
            Console.WriteLine("Kończę pracę...");
        }
    }
}
