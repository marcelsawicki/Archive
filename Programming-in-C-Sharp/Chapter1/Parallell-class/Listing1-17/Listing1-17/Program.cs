using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listing1_17
{
    class Program
    {
        static void Main(string[] args)
        {
            ParallelLoopResult result = Parallel.For(0, 1000, (int i, ParallelLoopState loopState) => 
            {
                Console.Write(" "+i);

                if (i == 500)
                {
                    Console.WriteLine("\nBreaking loop");
                    loopState.Break();
                }

                return;
            });


            Console.WriteLine("\nPress SPACE to continue.");
            Console.ReadKey();
        }
    }
}
