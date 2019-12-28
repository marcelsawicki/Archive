using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
	static class Obliczenia
	{
		public static double delta, x1, x2;

		public static List<double> PrzeliczPierwiastki(int a, int b, int c)
		{
			List<double> kolekcjaPierwiastkow = new List<double>();

			delta = (b * b) - 4 * a * c;
			//Console.WriteLine("-----------------------------------------");
			//Console.WriteLine("Delta wynosi: " + delta + " \n");

			if (delta == 0)
			{
				x1 = x2 = -b / (2 * a);
				//Console.WriteLine("{0}x^2+{1}x+{2}", a, b, c);
				//Console.WriteLine("Dla delty równej 0 istnieje jedno rozwiązanie.");
				kolekcjaPierwiastkow.Add(x1);
			}
			else if (delta > 0)
			{
				x1 = (-b - Math.Sqrt(delta)) / (2 * a);
				x2 = (-b + Math.Sqrt(delta)) / (2 * a);
				kolekcjaPierwiastkow.Add(x1);
				kolekcjaPierwiastkow.Add(x2);
				//Console.WriteLine("{0}x^2+{1}x+{2}", a, b, c);
				//Console.WriteLine("Dla delty większej niż 0:\nx1 = " + x1 + " \nx2 = " + x2);
			}
			else if (delta < 0)
			{
				//Console.WriteLine("{0}x^2+{1}x+{2}",a,b,c);
				//Console.WriteLine("Dla delty mniejszej niż 0 brak rozwiazan.");
			}

			return kolekcjaPierwiastkow;
		}
	}
}
