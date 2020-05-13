using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace List5App2
{
    class Program
    {
        static void Main(string[] args)
        {

            if (args.Length == 0)
            {
                System.Console.WriteLine("Please enter a numeric argument.");
            }
            else
            {
                string plik = args[0];
                int pWierzch = int.Parse(args[1]);

                Graph graph = GraphReader.ReadWithWeight(plik);
                GraphService.ProblemKomiwojazera(graph, pWierzch);
                Console.WriteLine("<ENTER>");
                Console.ReadLine();
            }

        }
    }
}
