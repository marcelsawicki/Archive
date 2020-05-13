using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie2App2
{
    class GraphService
    {
        public static void WyswietlRzdGrafu(Graph graph)
        {
            System.Console.WriteLine("Rzad grafu G wynosi: " + graph.NVerticies);
        }

        public static void WyswietlRozmiarGrafu(Graph graph)
        {
            System.Console.WriteLine("Rozmiar grafu G wynosi: " + graph.NEdges);
        }

        public static void WyswietlStopnieWierzcholkow(Graph graph)
        {
            int[,] macierzPomocnicza = new int[graph.NEdges, 2];

            int rowCounter = 0;
            foreach (Edge edge in graph.Edges)
            {
                macierzPomocnicza[rowCounter, 0] = edge.From;
                macierzPomocnicza[rowCounter, 1] = edge.To;
                rowCounter++;
            }

            int[,] macierzWierzcholkow = new int[graph.NVerticies+1, 2];

            for (int k = 0; k <= graph.NVerticies; k++)
            {
                macierzWierzcholkow[k, 0] = k;
                int stopienWierzcholka = 0;

                for (int d = 0; d < macierzPomocnicza.GetLength(0); d++)
                {
                    if (macierzPomocnicza[d, 0] == k && macierzPomocnicza[d, 1] != k)
                    {
                        stopienWierzcholka++;
                    }
                    else if (macierzPomocnicza[d, 0] == k && macierzPomocnicza[d, 1] == k)
                    {
                        stopienWierzcholka += 2;
                    }
                    else if (macierzPomocnicza[d, 0] != k && macierzPomocnicza[d, 1] == k)
                    {
                        stopienWierzcholka++;
                    }
                }

                macierzWierzcholkow[k, 1] = stopienWierzcholka; 
            }
            System.Console.WriteLine("Stopnie wierzcholkow: ");
            for (int j = 0; j < macierzWierzcholkow.GetLength(0); j++)
            {
                System.Console.WriteLine("deg(" + macierzWierzcholkow[j, 0] + ") = " + macierzWierzcholkow[j, 1]);
            }
            WyswietlCiagStopnigrafu(macierzWierzcholkow);
        }

        private static void WyswietlCiagStopnigrafu(int[,] macierzWierzcholkow)
        {
            int[] wierzcholki = new int[macierzWierzcholkow.GetLength(0)];
            for (int j = 0; j < macierzWierzcholkow.GetLength(0); j++)
            {
                wierzcholki[j] = macierzWierzcholkow[j, 1];
            }

            int[] posortowaneWierzcholki = QuickSort(wierzcholki, 0, wierzcholki.Length - 1);

            System.Console.Write("Ciag stopni grafu G: ");
            for (int g = 1; g < posortowaneWierzcholki.Length; g++)
            {
                System.Console.Write(posortowaneWierzcholki[g] + ", ");
            }
            System.Console.WriteLine();

        }

        public static int[] QuickSort(int[] array, int left, int right)
        {
            var i = left;
            var j = right;
            var pivot = array[(left + right) / 2];
            while (i < j)
            {
                while (array[i] < pivot) i++;
                while (array[j] > pivot) j--;
                if (i <= j)
                {
                    // swap
                    var tmp = array[i];
                    array[i++] = array[j];  // ++ and -- inside array braces for shorter code
                    array[j--] = tmp;
                }
            }
            if (left < j) QuickSort(array, left, j);
            if (i < right) QuickSort(array, i, right);

            return array;
        }

    }
}
