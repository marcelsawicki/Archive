using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lista2Grafy
{
    class Program
    {
        static void Main(string[] args)
        {
            /*
            Console.WriteLine("Zadanie 1, Lista 2");
            Console.WriteLine("Sprawdzenie czy graf jest grafem regularnym.");
            Graph pobranyGrafDoSPrawdzeniaCzyRegularny = GraphReader.Read(@"C:\Users\msawicki\Desktop\UZ-Informatyka\Grafy-i-sieci\Lista2\Lista2Grafy\Lista2Grafy\g1.txt");
            GraphService.SprawdzCzyGrafJestRegularny(pobranyGrafDoSPrawdzeniaCzyRegularny);
            Console.WriteLine("<ENTER>");
            Console.ReadKey();

            Graph pobranyGrafRegularny = GraphReader.Read(@"C:\Users\msawicki\Desktop\UZ-Informatyka\Grafy-i-sieci\Lista2\Lista2Grafy\Lista2Grafy\g1a.txt");
            Console.WriteLine("Pobralem kolejny graf..");
            GraphService.SprawdzCzyGrafJestRegularny(pobranyGrafRegularny);
            Console.WriteLine("<ENTER>");
            Console.ReadKey();


            Console.WriteLine("Zadanie 2, Lista 2");
            Console.WriteLine("Sprawdzenie czy graf jest grafem cyklicznym.");

            Graph pobranyGraf = GraphReader.Read(@"C:\Users\msawicki\Desktop\UZ-Informatyka\Grafy-i-sieci\Lista2\Lista2Grafy\Lista2Grafy\g1-2.txt");
            Console.WriteLine("Pobrano graf.");
            bool czySpojny = GraphService.SprawdzCzyGrafSpojny(pobranyGraf);
            bool czyRegularny = GraphService.SprawdzCzyGrafJestRegularny(pobranyGraf);

            if (czyRegularny && czySpojny)
            {
                Console.WriteLine("Graf jest regularny i spojny. Tworze z niego graf typu kolo.");
                Graph grafTypuKoloDoZapisania = GraphService.UtworzGrafKolo(pobranyGraf);
                GraphReader.Save(grafTypuKoloDoZapisania);
            }
            Console.WriteLine("<ENTER>");
            Console.ReadKey();

            Console.WriteLine("Zadanie 3, Lista 2");
            Console.WriteLine("Sprawdzenie czy graf jest grafem typu koło.");

            Graph pobranyGrafKolo = GraphReader.Read(@"C:\Users\msawicki\Desktop\UZ-Informatyka\Grafy-i-sieci\Lista2\Lista2Grafy\Lista2Grafy\g1-3.txt");
            Console.WriteLine("Pobrano graf.");
            GraphService.SprawdzCzyGrafTypuKolo(pobranyGrafKolo);
            Console.WriteLine("<ENTER>");
            Console.ReadKey(); 
            */
            /*
            Console.WriteLine("Zadanie 5, Lista 2");
            Console.WriteLine("Sprawdzenie czy graf jest grafem eulerowskim, półeulerowskim lub nieeulerowskim.");
            Graph pobranyGrafNieEulerowski = GraphReader.Read(@"C:\Users\msawicki\Desktop\UZ-Informatyka\Grafy-i-sieci\Lista2\Lista2Grafy\Lista2Grafy\g1c.txt");
            Console.WriteLine("Pobrano graf.");
            GraphService.SprawdzCzyGrafEulerowski(pobranyGrafNieEulerowski);
            Console.WriteLine("<ENTER>");
            Console.ReadKey();
            Graph pobranyGrafEulerowski = GraphReader.Read(@"C:\Users\msawicki\Desktop\UZ-Informatyka\Grafy-i-sieci\Lista2\Lista2Grafy\Lista2Grafy\g1d.txt");
            Console.WriteLine("Pobrano graf.");
            bool eulerowski = GraphService.SprawdzCzyGrafEulerowski(pobranyGrafEulerowski);
            bool poleulerowski = GraphService.SprawdzCzyGrafPolEulerowski(pobranyGrafEulerowski);
            Console.WriteLine("<ENTER>");
            Console.ReadKey();
            */

            Graph pobranyGrafPolEulerowski = GraphReader.Read(@"C:\Users\msawicki\Desktop\UZ-Informatyka\Grafy-i-sieci\Lista2\Lista2Grafy\Lista2Grafy\g1e.txt");
            Console.WriteLine("Pobrano graf.");
            // eulerowski = GraphService.SprawdzCzyGrafEulerowski(pobranyGrafPolEulerowski);
            bool poleulerowski = GraphService.SprawdzCzyGrafPolEulerowski(pobranyGrafPolEulerowski);
            Console.WriteLine("<ENTER>");
            Console.ReadKey();
        }
    }
}
