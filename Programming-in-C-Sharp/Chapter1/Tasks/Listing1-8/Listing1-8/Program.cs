using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listing1_8
{
    //Listing 1-8 Starting a new Task
    class Program
    {
        static void Main(string[] args)
        {
            Task t = Task.Run(()=> 
            {
                for (int i = 0; i < 100; i++)
                {
                    Console.Write('*');
                }
            });

            t.Wait();
        }
    }
}
