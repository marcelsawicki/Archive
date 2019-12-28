using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
	class Program
	{
		static void iterujPoKolekcji(List<double> lista)
		{
			System.Console.WriteLine("Kolejne rozwiązania: ");
			foreach (double x in lista)
			{
				System.Console.Write(x + ",");
			}
			System.Console.WriteLine();
		}

		static void Main(string[] args)
		{
			List<double> kolekcja1 = Obliczenia.PrzeliczPierwiastki(1, 2, 3); // parametry a, b, c
			iterujPoKolekcji(kolekcja1);

			List<double> kolekcja2 = Obliczenia.PrzeliczPierwiastki(4, 2, 10);
			iterujPoKolekcji(kolekcja2);

			List<double> kolekcja3 = Obliczenia.PrzeliczPierwiastki(-3, 2, 3);
			iterujPoKolekcji(kolekcja3);

			List<double> kolekcja4 = Obliczenia.PrzeliczPierwiastki(1, 2, 1);
			iterujPoKolekcji(kolekcja4);


			Console.ReadKey();
			System.Console.ReadLine();

		}
	}
}
