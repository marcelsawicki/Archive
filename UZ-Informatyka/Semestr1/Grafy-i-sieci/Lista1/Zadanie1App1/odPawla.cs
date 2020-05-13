 class Program
    {
        static void Main(string[] args)
        {
            string path = @"c:\users\pstepnowski\documents\visual studio 2015\Projects\ConsoleApplication13\ConsoleApplication13\Graph.txt";
            var graph = new GraphReader().Read(path);
        }
    }
 
    public class GraphReader
    {
        public IDictionary<int, Node> Read(string path)
        {
            Dictionary<int, Node> result = new Dictionary<int, Node>();
            string[] lines = File.ReadAllLines(path);
            int lineNumber = 0;
 
            foreach (string line in lines)
            {
                lineNumber++;
                string[] edge = line.Split(' ');
 
                if (edge.Length == 2)
                {
                    int from = int.Parse(edge[0]);
                    int to = int.Parse(edge[1]);
                    Node fromNode = this.GetNode(result, from);
                    Node toNode = this.GetNode(result, to);
                    fromNode.Nodes.Add(toNode);
                }
                else
                {
                    throw new ArgumentException("Invalid data format");
                }
            }
 
            return result;
        }
 
        private Node GetNode(Dictionary<int, Node> nodes, int id)
        {
            Node result;
 
            if (nodes.TryGetValue(id, out result) == false)
            {
                result = new Node();
                nodes.Add(id, result);
            }
 
            return result;
        }
    }
 
    public class Node
    {
        public readonly List<Node> Nodes = new List<Node>(); 
    }
 