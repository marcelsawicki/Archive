using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
	class Swap
	{
		public void swap(ref int liczbaA, ref int liczbaB)
		{
			System.Console.WriteLine("Metoda swap - zamiana liczb.");

			int zmiennaPomocnicza = liczbaB;
			liczbaB = liczbaA;
			liczbaA = zmiennaPomocnicza;
		}
	}
}
