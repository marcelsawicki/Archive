using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie3App3
{
    class GraphService
    {
        public static void SprawdzCzyGrafProstyGrafOgolny(Graph graph)
        {
            bool multiGraph = false;
            string rodzajGrafu = "prostym.";
            int[,] macierzPomocnicza = new int[graph.NEdges, 2];
            int rowCounter = 0;

            foreach (Edge edge in graph.Edges)
            {
                macierzPomocnicza[rowCounter, 0] = edge.From;
                macierzPomocnicza[rowCounter, 1] = edge.To;
                rowCounter++;
            }
            int pomocniczeFrom, pomocniczeTo;

            for (int k = 0; k < macierzPomocnicza.GetLength(0); k++)
            {
                pomocniczeFrom = macierzPomocnicza[k, 0];
                pomocniczeTo = macierzPomocnicza[k, 1];

                int multiEdge = 0;
                for (int d = 0; d < macierzPomocnicza.GetLength(0); d++)
                {
                    if (macierzPomocnicza[d, 0] == pomocniczeFrom && macierzPomocnicza[d, 1] == pomocniczeTo)
                    {
                        multiEdge++;
                    }

                    if (macierzPomocnicza[d, 0] == pomocniczeTo && macierzPomocnicza[d, 1] == pomocniczeFrom)
                    {
                        multiEdge++;
                    }

                    if (macierzPomocnicza[d, 0] == pomocniczeTo && macierzPomocnicza[d, 1] == pomocniczeTo || macierzPomocnicza[d, 0] == pomocniczeFrom && macierzPomocnicza[d, 1] == pomocniczeFrom)
                    {
                        multiEdge += 2;
                    }
                }

                if (multiEdge > 1)
                {
                    multiGraph = true;
                }
            }

            if (multiGraph)
            {
                rodzajGrafu = "ogólnym.";
            }
            System.Console.WriteLine("Graf G jest grafem " + rodzajGrafu);
        }
    }
}
