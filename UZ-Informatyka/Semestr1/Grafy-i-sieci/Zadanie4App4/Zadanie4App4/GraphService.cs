using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie4App4
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

        public void CompleteGraph(Graph graph)
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

            // show list of vertices
            List<Edge> listaPomocnicza = new List<Edge>();
            foreach (int v in vertices)
            {
                foreach (int j in vertices)
                {
                    if (v != j)
                    {
                        System.Console.WriteLine("Mozliwe kombinacje: " + v + " " + j);
                        bool complete = false;
                        foreach (Edge edge in graph.Edges)
                        {
                            if (v != j)
                            {

                                if ((edge.From == v && edge.To == j) || (edge.To == v && edge.From == j))
                                {
                                    complete = true;
                                    System.Console.WriteLine("Mam: " + v + " " + j);
                                    Edge pomocniczyEdge = new Edge();
                                    pomocniczyEdge.From = v;
                                    pomocniczyEdge.To = j;
                                    listaPomocnicza.Add(pomocniczyEdge);

                                }
                            }

                        }
                    }

                    //}

                }
            }
        }
    }
}
