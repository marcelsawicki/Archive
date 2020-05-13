using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lista2Grafy
{
    class GraphService
    {
        public static void ShowEdgesNumber(Graph graph)
        {
            System.Console.WriteLine("Liczba krawedzi grafu: " + graph.NEdges.ToString());
        }

        public static void ShowVerticiesNumber(Graph graph)
        {
            System.Console.WriteLine("Liczba wierzcholkow grafu: " + graph.NVerticies.ToString());
        }

        public static void ShowEdges(Graph graph)
        {
            Console.WriteLine("Wyswietlanie krawedzi grafu.");
            foreach (Edge edge in graph.Edges)
            {
                System.Console.WriteLine("Krawedz: " + edge.From.ToString() + ", " + edge.To.ToString());
            }

        }

        public static Graph UtworzGrafKolo(Graph graph)
        {
            List<int> wierzcholki = GetVerticies(graph);
            int najwyzszy = wierzcholki.Last();

            Graph grafTypuKolo = new Graph();
            List<Edge> krawedzieGrafuKolo = new List<Edge>();
            Edge ostatniaKrawedz = graph.Edges.Last();

            foreach (Edge edge in graph.Edges)
            {
                Edge wierzcholekDodawany = new Edge();
                wierzcholekDodawany.From = edge.From;
                wierzcholekDodawany.To = edge.To;
                krawedzieGrafuKolo.Add(wierzcholekDodawany);
            }

            foreach (int wierzcholek in wierzcholki)
            {
                Edge krawedzKola = new Edge();
                krawedzKola.From = wierzcholek;
                krawedzKola.To = najwyzszy + 1;
                krawedzieGrafuKolo.Add(krawedzKola);
            }

            Console.WriteLine("Utworzylem graf typu kolo.");
            Console.WriteLine("graph W {");

            foreach (Edge edge in krawedzieGrafuKolo)
            {
                Console.WriteLine("{0} -- {1}", edge.From, edge.To);
            }

            Console.WriteLine("}");

            grafTypuKolo.Edges = krawedzieGrafuKolo;
            grafTypuKolo.NEdges = grafTypuKolo.Edges.Count();
            grafTypuKolo.NVerticies = najwyzszy + 1;

            return grafTypuKolo;

        }

        public static void ShowVerticies(Graph graph)
        {
            Console.WriteLine("Wyswietlanie wierzcholkow grafu");
            int countVertices = 0;
            int[,] verticesMatrix = new int[graph.Edges.Count,2];

            List<int> vertices = new List<int>();

            foreach (Edge edge in graph.Edges)
            {
                bool addVertexFrom = true;

                foreach (int vertex in vertices)
                {
                    if (edge.From == vertex)
                    {
                        addVertexFrom = false;
                    }
                }

                if (addVertexFrom)
                {
                    vertices.Add(edge.From);
                }

                bool addVertexTo = true;

                foreach (int vertex in vertices)
                {
                    if (edge.To == vertex)
                    {
                        addVertexTo = false;
                    }
                }

                if (addVertexTo)
                {
                    vertices.Add(edge.To);
                }
            }

            // show list of vertices

            foreach (int v in vertices)
            {
                System.Console.WriteLine(v + " vertex");
            }
        }

        public static bool SprawdzCzyGrafEulerowski(Graph pobranyGrafEulerowski)
        {
            bool eulerowski = true;
            Console.WriteLine("Twierdzenie (Euler, 1736): Graf spójny G jest grafem eulerowskim wtedy i");
            Console.WriteLine("tylko wtedy, gdy stopień każdego wierzchołka grafu G jest liczbą parzystą.");
            bool czySpojny = SprawdzCzyGrafSpojny(pobranyGrafEulerowski);
            int[,] macierzAdjacencji = ShowNAdjacencyMatrix(pobranyGrafEulerowski);
            bool czyParzysteStopnie = SprawdzCzyStopnieWierzcholkowParzyste(macierzAdjacencji);

            if (czySpojny && czyParzysteStopnie)
            {
                Console.WriteLine("Graf jest grafem eulerowskim.");
            }
            else
            {
                Console.WriteLine("Graf nie jest grafem eulerowskim.");
                eulerowski = false;
            }

            return eulerowski;

        }

        private static bool SprawdzCzyStopnieWierzcholkowParzyste(int[,] adjacencyMatrix)
        {
            bool parzyste = true;
            List<int> sumowanieWierszy = new List<int>();
            int sumaPomocnicza = 0;
            for (int m = 1; m < adjacencyMatrix.GetLength(0); m++)
            {
                for (int g = 1; g < adjacencyMatrix.GetLength(0); g++)
                {
                    sumaPomocnicza += adjacencyMatrix[m, g];
                }
                sumowanieWierszy.Add(sumaPomocnicza);
                sumaPomocnicza = 0;
            }

            var tablicaSum = sumowanieWierszy.Distinct().ToArray();

            foreach (int item in tablicaSum)
            {
                if (item % 2 != 0)
                {
                    parzyste = false;
                }
            }

            if (parzyste)
            {
                Console.WriteLine("Stopnie wierzchołków grafu sa parzyste.");
            }
            else
            {
                Console.WriteLine("Nie wszystkie stopnie wierzchołków grafu są parzyste.");
            }

            return parzyste;
        }

        private static bool SprawdzCzyStopnieWierzcholkowParzysteOrazDwaNieparzyste(int[,] adjacencyMatrix)
        {
            bool parzyste = true;
            List<int> sumowanieWierszy = new List<int>();
            int sumaPomocnicza = 0;
            for (int m = 1; m < adjacencyMatrix.GetLength(0); m++)
            {
                for (int g = 1; g < adjacencyMatrix.GetLength(0); g++)
                {
                    sumaPomocnicza += adjacencyMatrix[m, g];
                }
                sumowanieWierszy.Add(sumaPomocnicza);
                sumaPomocnicza = 0;
            }

            var tablicaSum = sumowanieWierszy.ToArray();
            int ileNieparzystych = 0;
            foreach (int item in tablicaSum)
            {
                if (item % 2 != 0)
                {
                    parzyste = false;
                    ileNieparzystych++;
                }
            }

            if (parzyste)
            {
                Console.WriteLine("Stopnie wierzchołków grafu sa parzyste.");
            }
            else
            {
                Console.WriteLine("Nie wszystkie stopnie wierzchołków grafu są parzyste. {0} stopni nieparzystych.", ileNieparzystych);
            }

            if (ileNieparzystych == 2)
            {
                Console.WriteLine("Graf jest grafem półeulerowskim. {0} stopni nieparzystych.", ileNieparzystych);
                return true;
            }
            else
            {
                return false;
            }
        }

        public static bool SprawdzCzyGrafPolEulerowski(Graph pobranyGrafEulerowski)
        {
            bool polEulerowski = false;
            Console.WriteLine("Graf spójny G jest grafem półeulerowskim wtedy i");
            Console.WriteLine("tylko wtedy, gdy ma dokładnie dwa wierzchołki nieparzystych stopni.");
            bool czySpojny = SprawdzCzyGrafSpojny(pobranyGrafEulerowski);
            int[,] macierzAdjacencji = ShowNAdjacencyMatrix(pobranyGrafEulerowski);
            bool czyParzysteStopnie = SprawdzCzyStopnieWierzcholkowParzyste(macierzAdjacencji);
            bool czyPolEulerowski = SprawdzCzyStopnieWierzcholkowParzysteOrazDwaNieparzyste(macierzAdjacencji);


            if (czySpojny && czyParzysteStopnie)
            {
                Console.WriteLine("Graf jest grafem eulerowskim.");
            }
            else if (czyPolEulerowski)
            {
                Console.WriteLine("Graf jest grafem półeulerowskim.");
                polEulerowski = true;
            }
            else
            {
                Console.WriteLine("Graf nie jest grafem półeulerowskim, nie jest tez grafem eulerowskim.");
            }

            return polEulerowski;

        }

        public static void SprawdzCzyGrafTypuKolo(Graph graph)
        {
            bool grafTypuKolo = false;
            // pobieram wszystkie wierzcholki i sprawdzam cz jest wierzcholek ktory
            // jest polaczony z wszystkimi innymi wierzcholkami
            List<int> wierzcholkiPobranegoGrafu = GetVerticies(graph);

            int sprawdzanyWierzcholek = 0;
            Stack<int> sasiadujaceWierzcholki = new Stack<int>();
            foreach (int wierzcholek in wierzcholkiPobranegoGrafu)
            {
                foreach (Edge edge in graph.Edges)
                {
                    if (wierzcholek == edge.From)
                    {
                       sasiadujaceWierzcholki.Push(edge.To);
                    }

                    if (wierzcholek == edge.To)
                    {
                      sasiadujaceWierzcholki.Push(edge.From);
                    }
                }

                if (sasiadujaceWierzcholki.Count == wierzcholkiPobranegoGrafu.Count - 1)
                {
                    Console.WriteLine("Wierzcholek grafu typu kolo do usuniecia: " + wierzcholek);
                    grafTypuKolo = true;
                    sprawdzanyWierzcholek = wierzcholek;
                }
                sasiadujaceWierzcholki.Clear();

            }

            List<Edge> tworzonyGrafCykliczny = new List<Edge>();

            // jesli jest taki wierzcholek to usuwam go i sprawdzam czy powstanie graf regularny drugiego stopnia i spojny
            if (grafTypuKolo)
            {
                Console.WriteLine("Graf jest grafem typu kolo, tworze graf cykliczny.");
                Graph grafCykliczny = UtworzGrafCykliczny(graph, sprawdzanyWierzcholek);
                GraphReader.Save(grafCykliczny, @"c.txt");
                Console.WriteLine("Zapisano utworzony graf cykliczny do pliku c.txt");
            }

        }

        private static Graph UtworzGrafCykliczny(Graph graph, int sprawdzanyWierzcholek)
        {
            Graph tworzonyGrafCykliczny = new Graph();
            List<Edge> tworzoneKrawedzieGrafuCyklicznego = new List<Edge>();
            foreach (Edge edge in graph.Edges)
            {
                if (sprawdzanyWierzcholek != edge.From && sprawdzanyWierzcholek != edge.To)
                {
                    Edge krawedzGrafuCyklicznego = new Edge();
                    krawedzGrafuCyklicznego.From = edge.From;
                    krawedzGrafuCyklicznego.To = edge.To;
                    tworzoneKrawedzieGrafuCyklicznego.Add(krawedzGrafuCyklicznego);
                }
            }

            tworzonyGrafCykliczny.Edges = tworzoneKrawedzieGrafuCyklicznego;
            tworzonyGrafCykliczny.NEdges = tworzoneKrawedzieGrafuCyklicznego.Count;
            tworzonyGrafCykliczny.NVerticies = GetVerticies(tworzonyGrafCykliczny).Count;
            return tworzonyGrafCykliczny;
        }

        private static List<int> GetVerticies(Graph graph)
        {
            int countVertices = 0;
            int[,] verticesMatrix = new int[graph.Edges.Count, 2];

            List<int> vertices = new List<int>();

            foreach (Edge edge in graph.Edges)
            {
                bool addVertexFrom = true;

                foreach (int vertex in vertices)
                {
                    if (edge.From == vertex)
                    {
                        addVertexFrom = false;
                    }
                }

                if (addVertexFrom)
                {
                    vertices.Add(edge.From);
                }

                bool addVertexTo = true;

                foreach (int vertex in vertices)
                {
                    if (edge.To == vertex)
                    {
                        addVertexTo = false;
                    }
                }

                if (addVertexTo)
                {
                    vertices.Add(edge.To);
                }
            }
            return vertices;
        }

        public static void CheckIfItIsMultigraph(Graph graph)
        {
            int countVertices =  0;
            int[,] verticesMatrix = new int[graph.Edges.Count, 2];

            foreach (Edge edge in graph.Edges)
            {
                
                for (int s = 0; s < verticesMatrix.GetLength(0); s++)
                {
                    verticesMatrix[s, 0] = edge.From;
                    verticesMatrix[s, 1] = edge.To;
                }
            }

            for (int u = 0; u < verticesMatrix.GetLength(0); u++)
            {
                for (int b = 0; b < verticesMatrix.GetLength(0); b++)
                {
                    if (verticesMatrix[u, 0] == verticesMatrix[b, 1] && verticesMatrix[u, 1] == verticesMatrix[b, 0])
                    {
                        System.Console.WriteLine("Duplikat");
                    }
                }
            }

            /*
                countVertices++;
                System.Console.WriteLine("Liczba wierzcholkow grafu G wynosi: " +countVertices);
                System.Console.WriteLine("Zbiór wierzcholkow V= " + countVertices);
             */
        }

        public static int[,] ShowNAdjacencyMatrix(Graph graph)
        {
            int matrixRow = 0;
            int[,] adjacencyMatrixPreparation = new int[graph.NEdges, 2];
            foreach (Edge item in graph.Edges)
            {

                adjacencyMatrixPreparation[matrixRow, 0] = item.From;
                adjacencyMatrixPreparation[matrixRow, 1] = item.To;
                matrixRow++;
            }

            int[,] adjacencyMatrix = new int[graph.NVerticies+1, graph.NVerticies+1];


            for (int k = 0; k <= graph.NVerticies; k++)
            {
                for (int d = 0; d <= graph.NVerticies; d++)
                {
                    for (int j = 0; j < adjacencyMatrixPreparation.GetLength(0); j++)
                    {
                        if (adjacencyMatrixPreparation[j, 0]==(k) && adjacencyMatrixPreparation[j, 1]==(d))
                        {
                            adjacencyMatrix[k, d]++;
                        }

                        if (adjacencyMatrixPreparation[j, 1] == (k) && adjacencyMatrixPreparation[j, 0] == (d))
                        {
                            adjacencyMatrix[k, d]++;
                        }
                    }
                }
            }

            System.Console.WriteLine("Macierz adjacencji");
            for (int m = 1; m < adjacencyMatrix.GetLength(0); m++)
            {
                for (int g = 1; g < adjacencyMatrix.GetLength(0); g++)
                {
                    System.Console.Write(adjacencyMatrix[m, g]);
                    System.Console.Write(", ");
                }
                System.Console.WriteLine();
            }
            return adjacencyMatrix;
        }

        public static bool SprawdzCzyGrafJestRegularny(Graph graph)
        {
            bool regularny = false;
            int matrixRow = 0;
            int[,] adjacencyMatrixPreparation = new int[graph.NEdges, 2];
            foreach (Edge item in graph.Edges)
            {

                adjacencyMatrixPreparation[matrixRow, 0] = item.From;
                adjacencyMatrixPreparation[matrixRow, 1] = item.To;
                matrixRow++;
            }

            int[,] adjacencyMatrix = new int[graph.NVerticies + 1, graph.NVerticies + 1];


            for (int k = 0; k <= graph.NVerticies; k++)
            {
                for (int d = 0; d <= graph.NVerticies; d++)
                {
                    for (int j = 0; j < adjacencyMatrixPreparation.GetLength(0); j++)
                    {
                        if (adjacencyMatrixPreparation[j, 0] == (k) && adjacencyMatrixPreparation[j, 1] == (d))
                        {
                            adjacencyMatrix[k, d]++;
                        }

                        if (adjacencyMatrixPreparation[j, 1] == (k) && adjacencyMatrixPreparation[j, 0] == (d))
                        {
                            adjacencyMatrix[k, d]++;
                        }
                    }
                }
            }

            List<int> sumowanieWierszy = new List<int>();
            int sumaPomocnicza = 0;
            for (int m = 1; m < adjacencyMatrix.GetLength(0); m++)
            {
                for (int g = 1; g < adjacencyMatrix.GetLength(0); g++)
                {
                    sumaPomocnicza += adjacencyMatrix[m, g];
                }
                sumowanieWierszy.Add(sumaPomocnicza);
                sumaPomocnicza = 0;
            }

            var tablicaSum = sumowanieWierszy.Distinct().ToArray();
            if (tablicaSum.Length > 1)
            {
                Console.WriteLine("Graf nie jest grafem regularnym.");
            }
            else
            {
                Console.WriteLine("Graf jest grafem regularnym.");
                Console.WriteLine("Stopien grafu regularnego: " +tablicaSum[0]);
                regularny = true;
            }

            return regularny;
        }

        public static void ShowIncidenceMatrix(Graph graph)
        {
            int[,] incidenceMatrix = new int[graph.NVerticies+1, graph.NEdges+1];
            int matrixRow = 0;
            int[,] incidenceMatrixPreparation = new int[graph.Edges.Count, 3];
            foreach (Edge item in graph.Edges)
            {

                incidenceMatrixPreparation[matrixRow, 0] = item.From;
                incidenceMatrixPreparation[matrixRow, 1] = item.To;
                incidenceMatrixPreparation[matrixRow, 2] = matrixRow + 1;
                matrixRow++;
            }


            for (int k = 1; k < incidenceMatrix.GetLength(0); k++)
            {
                for (int j = 1; j < incidenceMatrix.GetLength(1); j++)
                {
                    for (int g = 0; g < incidenceMatrixPreparation.GetLength(0); g++)
                    {
                        if (incidenceMatrixPreparation[g, 0] == k && incidenceMatrixPreparation[g, 2] == j)
                        {
                            incidenceMatrix[k, j]++;
                        }

                        if (incidenceMatrixPreparation[g, 1] == k && incidenceMatrixPreparation[g, 2] == j)
                        {
                            incidenceMatrix[k, j]++;
                        }
                    }
                                    
                }
            }


            System.Console.WriteLine("macierz incydencji");
            for (int m = 1; m < incidenceMatrix.GetLength(0); m++)
            {
                for (int g = 1; g < incidenceMatrix.GetLength(1); g++)
                {
                    System.Console.Write(incidenceMatrix[m, g]);
                    System.Console.Write(", ");
                }
                System.Console.WriteLine();
            }
        }

        public static void SprawdzCzyGrafCykliczny(Graph graph)
        {
            int matrixRow = 0;
            int[,] adjacencyMatrixPreparation = new int[graph.NEdges, 2];
            foreach (Edge item in graph.Edges)
            {

                adjacencyMatrixPreparation[matrixRow, 0] = item.From;
                adjacencyMatrixPreparation[matrixRow, 1] = item.To;
                matrixRow++;
            }

            int[,] adjacencyMatrix = new int[graph.NVerticies + 1, graph.NVerticies + 1];


            for (int k = 0; k <= graph.NVerticies; k++)
            {
                for (int d = 0; d <= graph.NVerticies; d++)
                {
                    for (int j = 0; j < adjacencyMatrixPreparation.GetLength(0); j++)
                    {
                        if (adjacencyMatrixPreparation[j, 0] == (k) && adjacencyMatrixPreparation[j, 1] == (d))
                        {
                            adjacencyMatrix[k, d]++;
                        }

                        if (adjacencyMatrixPreparation[j, 1] == (k) && adjacencyMatrixPreparation[j, 0] == (d))
                        {
                            adjacencyMatrix[k, d]++;
                        }
                    }
                }
            }

            System.Console.WriteLine("Macierz adjacencji");
            for (int m = 1; m < adjacencyMatrix.GetLength(0); m++)
            {
                for (int g = 1; g < adjacencyMatrix.GetLength(0); g++)
                {
                    System.Console.Write(adjacencyMatrix[m, g]);
                    System.Console.Write(", ");
                }
                System.Console.WriteLine();
            }

            List<int> sumowanieWierszy = new List<int>();
            int sumaPomocnicza = 0;
            System.Console.WriteLine("sumuje wiersze i sprawdzam czy graf jest regularny stopnia 2");
            for (int m = 1; m < adjacencyMatrix.GetLength(0); m++)
            {
                for (int g = 1; g < adjacencyMatrix.GetLength(0); g++)
                {
                    System.Console.Write(adjacencyMatrix[m, g]);
                    System.Console.Write(", ");
                    sumaPomocnicza += adjacencyMatrix[m, g];
                }
                sumowanieWierszy.Add(sumaPomocnicza);
                System.Console.WriteLine();
                sumaPomocnicza = 0;
            }

            foreach (int wynik in sumowanieWierszy)
            {
                Console.WriteLine("Zsumowany wiersz: " + wynik);
            }
            var tablicaSum = sumowanieWierszy.Distinct().ToArray();
            if (tablicaSum.Length > 1)
            {
                Console.WriteLine("Graf nie jest grafem regularnym. Graf nie jest grafem cyklicznym.");
            }
            else
            {
                Console.WriteLine("Graf jest grafem regularnym.");
                Console.WriteLine("Stopien grafu regularnego: " + tablicaSum[0]);
                if (tablicaSum[0] == 2)
                {
                    Console.WriteLine("Graf jest grafem regularnym stopnia drugiego.");
                    Console.WriteLine("Jesli jest takze spojny to jest grafem cyklicznym.");
                }
                else
                {
                    Console.WriteLine("Graf nie jest grafem regularnym stopnia drugiego, dlatego nie bedzie tez grafem cyklicznym.");
                }
            }
        }
        public static bool SprawdzCzyGrafSpojny(Graph graph)
        {
            bool spojny = false;
            int zadanyWierzcholek = graph.Edges[0].From;
            int odwiedzonyWierzcholek = zadanyWierzcholek;
            // na stosie bede odkladal wierzcholki do odwiedzenia
            Stack<int> stos = new Stack<int>();
            Stack<int> bylem = new Stack<int>();
            List<int> wszystkieWierzcholki = new List<int>();
            stos.Push(odwiedzonyWierzcholek);
            // w kolekcji visited bede przechowywal dane czy wierzcholek byl odwiedzony
            // wyszukaj wszystkich sasiadow dla wierzcholka 1

            while (stos.Count > 0)
            {
                odwiedzonyWierzcholek = stos.Pop();
                bylem.Push(odwiedzonyWierzcholek);
                foreach (Edge edge in graph.Edges)
                {
                    wszystkieWierzcholki.Add(edge.From);
                    wszystkieWierzcholki.Add(edge.To);

                    if (odwiedzonyWierzcholek == edge.From)
                    {
                        if (!stos.Contains(edge.To))
                        {
                            if (!bylem.Contains(edge.To))
                            {
                                stos.Push(edge.To);
                            }                         
                        }
                    }

                    if (odwiedzonyWierzcholek == edge.To)
                    {
                        if (!stos.Contains(edge.From))
                        {
                            if (!bylem.Contains(edge.From))
                            {
                                stos.Push(edge.From);
                            }
                        }
                        
                    }
                }
            }
            List<int> wierzchokiGrafu = wszystkieWierzcholki.Distinct().ToList();
            if (wierzchokiGrafu.Count == bylem.Count)
            {
                Console.WriteLine("Graf jest grafem spójnym.");
                spojny = true;
            }
            else
            {
                Console.WriteLine("Graf nie jest grafem spójnym.");
            }

            return spojny;
        }
    }
}
