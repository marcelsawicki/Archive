using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChinesePostman
{
    class Program
    {
        static void Main(string[] args)
        {
            // K01: Sprawdz, czy graf jeste spojny. Jesli nie jest, to zakoncz algorytm z odpowiednim komunikatem.
            Graph graf = GraphReader.ReadWithWeight(@"C:\Users\msawicki\Desktop\UZ-Informatyka\Grafy-i-sieci\Lista4\ChinesePostman\ChinesePostman\graf.txt");
            bool spojny = GraphService.SprawdzCzyGrafSpojny(graf);
            if (spojny)
            {
                // K02: Wyszukaj w grafie wszystkie wierzchołki o nieparzystych stopniach.
                GraphService.ZnajdzCyklEulera(graf, 4);
                //GraphReader.SaveWithWeight(graf);
            }
            else
            {
                Console.WriteLine("Graf nie jeste grafem spojnym.");
            }
            Console.ReadLine();
        }
    }
}
