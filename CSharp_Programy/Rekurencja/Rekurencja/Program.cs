using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Rekurencja
{
	class Program
	{
		public static long Suma(int n)
		{
			if (n < 1)
				return 0;

			return n + Suma(n - 1);
		}

		public static long Silnia(int n)
		{
			if (n < 1)
				return 1;

			return n * Silnia(n - 1);
		}

		public static long Potega(int x, int y)
		{
			if (y < 1)
				return 1;

			return x * Potega(x, y-1);
		}

		static void Main(string[] args)
		{
			int n = 5;
			long wynikRekursji = Program.Suma(n);
			long wyswietlanyWynikRekursji = Program.Silnia(n);
			long wyswietlanyWynikPotegowania = Program.Potega(n, 5);

			System.Console.WriteLine("Dodanie cyfr: "+wynikRekursji);
			System.Console.WriteLine("Silnia: " + wyswietlanyWynikRekursji);
			System.Console.WriteLine("Potegowanie: {0}, {1}, {2}:", wyswietlanyWynikPotegowania, n, 5);
			System.Console.ReadKey();
		}
	}
}
