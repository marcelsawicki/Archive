using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Listing1_6
{
    class Program
    {
        public static ThreadLocal<int> _field =
            new ThreadLocal<int>(() => 
            {
                return Thread.CurrentThread.ManagedThreadId;
            });

        static Thread NewThread(string name)
        {
            Thread thread = new Thread(() =>
            {
                for (int x = 0; x < _field.Value; x++)
                {
                    Console.WriteLine($"Thread {name}: {x}");
                    Thread.Sleep(200);
                }
            });
            return thread;
        }

        static void Main(string[] args)
        {
            Thread[] threads =
            {
                NewThread("A"),
                NewThread("B")
            };
            threads.ToList().ForEach(thread => thread.Start());
            threads.ToList().ForEach(thread => thread.Join());
            Console.WriteLine("Koniec");
        }
    }
}
