using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lista3Grafy
{
    class Program
    {
        static void Main(string[] args)
        {
            //Console.WriteLine("Zadanie 1. Wczytanie i zapisanie grafu do pliku w formacie GraphViz.");
            //Graph graphWithWeight = GraphReader.ReadWithWeight(@"C:\Users\msawicki\Desktop\University\Grafy-i-sieci\Lista3\Lista3Grafy\Lista3Grafy\graf.txt");
            //GraphReader.SaveWithWeight(graphWithWeight);
            //Console.WriteLine("<ENTER>");
            //Console.ReadLine();

            //Console.WriteLine("Zadanie 2. Obliczeni najkrotszej drogi miedzy podanymi wierzcholkami.");
            //GraphService.ZnajdzNajkrotszaDroge(graphWithWeight);
            //Console.WriteLine("<ENTER>");
            //Console.ReadLine();

            //Console.WriteLine("Zadanie 3. Najkrótsza droga dla wszsytkich możliwych par wierzchołków (kombinacje bez powtórzeń).");
            //GraphService.ZnajdzNajkrotszeDrogiDlaKombinacjiBezPowtorzen(graphWithWeight);
            //Console.WriteLine("<ENTER>");
            //Console.ReadLine();
            Console.WriteLine("Zadanie 4. Problem komiwojażera. Trasa rozpoczyna się i kończy w podanym mieście przez użytkownika.");
            GraphService.ProblemKomiwojazeraBezWczytywaniaGrafu();
            Console.WriteLine("<ENTER>");
            Console.ReadLine();

            //Console.WriteLine("Zadanie 5. Problem komiwojażera. Trasa rozpoczyna się i kończy w podanym mieście przez użytkownika.");
            //Graph graphCity = GraphReader.ReadWithWeight(@"C:\Users\msawicki\Desktop\University\Grafy-i-sieci\Lista3\Lista3Grafy\Lista3Grafy\grafMiasta.txt");
            //GraphService.ProblemKomiwojazera(graphCity);
            //Console.WriteLine("<ENTER>");
            //Console.ReadLine();

        }
    }
}
