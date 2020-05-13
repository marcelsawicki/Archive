using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie1App1
{
    class Program
    {
        static void Main(string[] args)
        {
            string path = @"C:\Users\msawicki\Desktop\University\Grafy-i-sieci\Zadanie1App1\Zadanie1App1\graf2.txt";
            GraphReader przykladowyGraf = new GraphReader();
            Graph gainedGraph = przykladowyGraf.Read(path);
            GraphService graphService = new GraphService();
            graphService.ShowVerticies(gainedGraph);
            //graphService.ShowEdges(gainedGraph);
            //graphService.ShowEdgesNumber(gainedGraph);
            //graphService.ShowVerticiesNumber(gainedGraph);
            graphService.ShowNAdjacencyMatrix(gainedGraph);
            //graphService.ShowVerticies(gainedGraph);
            graphService.ShowIncidenceMatrix(gainedGraph);
            System.Console.ReadKey();
          
        }
    }
}
