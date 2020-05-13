using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie3App3
{
    class Program
    {
        static void Main(string[] args)
        {
            string path2 = @"C:\Users\msawicki\Desktop\University\Grafy-i-sieci\Zadanie3App3\Zadanie3App3\graf2.txt";
            Graph gainedGraph2 = GraphReader.Read(path2);
            GraphService.SprawdzCzyGrafProstyGrafOgolny(gainedGraph2);

            string path1 = @"C:\Users\msawicki\Desktop\University\Grafy-i-sieci\Zadanie3App3\Zadanie3App3\graf.txt";
            Graph gainedGraph = GraphReader.Read(path1);
            GraphService.SprawdzCzyGrafProstyGrafOgolny(gainedGraph);

            System.Console.ReadKey();
        }
    }
}
