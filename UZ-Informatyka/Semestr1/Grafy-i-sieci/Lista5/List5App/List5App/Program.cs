using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace List5App
{
    class Program
    {
        static void Main(string[] args)
        {
            System.Diagnostics.Debugger.Break();
            if (args.Length == 0)
            {
                System.Console.WriteLine("Please enter a numeric argument.");
            }
            else
            {
                string plik = args[0];
                int pWierzch = int.Parse(args[1]);
                int dWierzch = int.Parse(args[2]);
                          
                Graph graphWithWeight = GraphReader.ReadWithWeight(plik);
                GraphService.Dijkstra(pWierzch, dWierzch, graphWithWeight);
            }
        }
    }
}
