using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie1App1
{
    class GraphService
    {
        public void ShowEdgesNumber(Graph graph)
        {
            System.Console.WriteLine("Edges number: " + graph.NEdges.ToString());
        }

        public void ShowVerticiesNumber(Graph graph)
        {
            System.Console.WriteLine("Verticies number: " + graph.NVerticies.ToString());
        }

        public void ShowEdges(Graph graph)
        {
            foreach (Edge edge in graph.Edges)
            {
                System.Console.WriteLine("Edge: " + edge.From.ToString() + ", " + edge.To.ToString());
            }

        }

        public void ShowVerticies(Graph graph)
        {
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

        public void CheckIfItIsMultigraph(Graph graph)
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

        public void ShowNAdjacencyMatrix(Graph graph)
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

            System.Console.WriteLine("Adjacency Matrix");
            for (int m = 1; m < adjacencyMatrix.GetLength(0); m++)
            {
                for (int g = 1; g < adjacencyMatrix.GetLength(0); g++)
                {
                    System.Console.Write(adjacencyMatrix[m, g]);
                    System.Console.Write(", ");
                }
                System.Console.WriteLine();
            }
        }

        public void ShowIncidenceMatrix(Graph graph)
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


            System.Console.WriteLine("Incidence Matrix");
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
    }
}
