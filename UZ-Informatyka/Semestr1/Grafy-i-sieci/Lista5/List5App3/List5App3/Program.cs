using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace List5App3
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
                Graph graf = GraphReader.ReadWithWeight(plik);
                bool spojny = GraphService.SprawdzCzyGrafSpojny(graf);
                if (spojny)
                {
                    // K02: Wyszukaj w grafie wszystkie wierzchołki o nieparzystych stopniach.
                    GraphService.ZnajdzCyklEulera(graf, pWierzch);
                    //GraphReader.SaveWithWeight(graf);
                }
                else
                {
                    Console.WriteLine("Graf nie jest grafem spojnym.");
                }
                Console.ReadLine();
            }
        }
    }
}
