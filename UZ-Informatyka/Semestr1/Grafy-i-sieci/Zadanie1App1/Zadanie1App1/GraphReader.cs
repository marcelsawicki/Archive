using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadanie1App1
{
    class GraphReader
    {
        public Graph Read(String path)
        {
            List<Edge> result = new List<Edge>();
            string[] lines = File.ReadAllLines(path);
            int lineNumber = 0;

            foreach (var line in lines)
            {
                lineNumber++;
                string[] edgeFromFile = line.Split(' ');

                if (edgeFromFile.Length == 2)
                {
                    Edge edge = new Edge();
                    edge.From = int.Parse(edgeFromFile[0]);
                    edge.To = int.Parse(edgeFromFile[1]);
                    result.Add(edge);
                }
                else
                {
                    throw new ArgumentException("Invalid data format");
                }
 

                System.Console.WriteLine(line);
                
            }

            Graph graphResult = new Graph();
            graphResult.NVerticies = result[0].From;
            graphResult.NEdges = result[0].To;
            result.RemoveAt(0);
            graphResult.Edges = result;
            return graphResult;
        }

    }
	//
}
