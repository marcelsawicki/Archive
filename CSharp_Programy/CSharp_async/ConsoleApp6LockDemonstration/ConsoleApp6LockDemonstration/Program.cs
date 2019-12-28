using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleApp6LockDemonstration
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Task> list = new List<Task>();
            ReadClass.HowMuchWillBeDone = 6;
            list.Add(new Task(ReadClass.SaveLockMessage));
            list.Add(new Task(ReadClass.SaveLockMessage));
            list.Add(new Task(ReadClass.SaveLockMessage));
            list.Add(new Task(ReadClass.SaveLockMessage));
            list.Add(new Task(ReadClass.SaveLockMessage));
            list.Add(new Task(ReadClass.SaveLockMessage));

            foreach (var task in list)
            {
                task.Start();
            }

            while (!ReadClass.CheckIsDone())
            { }

            Console.WriteLine("\n Skończone...");

            Console.ReadKey();
        }
    }

    class ReadClass
    {
        private static readonly object SyncObject = new object();
        private static TextWriter W;

        public static void SaveLockMessage()
        {
            Console.WriteLine("Przed Lockiem");

            lock (SyncObject)
            {
                i++;
                W = new StreamWriter("log.txt", true);
                Console.WriteLine("\t Start zapisu do pliku: " + i);
                W.WriteLine("Otrzymana: {0} {1}",
                    DateTime.Now.ToLongTimeString(),
                    DateTime.Now.ToLongDateString());
                Thread.Sleep(1000);

                Console.WriteLine("\t Skończyłem: " + i);
                W.Close();
            }
        }

        private static int i = 0;

        public static int HowMuchWillBeDone = 6;

        public static bool CheckIsDone()
        {
            return i >= HowMuchWillBeDone;
        }
    }

}
