using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie2App2
{
    class Program
    {
        static void Main(string[] args)
        {
            string path = @"C:\Users\msawicki\Desktop\University\Grafy-i-sieci\Zadanie2App2\Zadanie2App2\graf.txt";
            Graph gainedGraph = GraphReader.Read(path);
            GraphService.WyswietlRzdGrafu(gainedGraph);
            GraphService.WyswietlRozmiarGrafu(gainedGraph);
            GraphService.WyswietlStopnieWierzcholkow(gainedGraph);        
            System.Console.ReadKey();
        }
    }
}
