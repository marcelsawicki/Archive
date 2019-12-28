using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listing1_9
{
    // Listing 1-9 Using a Task that returns a value 
    class Program
    {
        static void Main(string[] args)
        {
            Task<int> t = Task.Run(() => 
            {
                return 42;
            });

            Console.WriteLine(t.Result); //Displays 42
            Console.ReadKey();
        }
    }
}
