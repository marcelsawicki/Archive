using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
	class Average
	{
		public void average(params double[] tab)
		{
			double suma = 0;
			int ilosc = 0;
			double srednia = 0;
			System.Console.WriteLine("Metoda average - obliczanie sredniej.");

			for (int k = 0; k < tab.Length; k++)
			{
				System.Console.Write(tab[k] + "; ");
				suma = suma + tab[k];
				ilosc++;
			}
			srednia = suma / ilosc;


			System.Console.WriteLine("\nSrednia z liczb przekazanych do metody average: " + srednia.ToString());
		}
	}
}
