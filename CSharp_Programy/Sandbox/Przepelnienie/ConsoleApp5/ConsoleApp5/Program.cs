using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp5
{
    class Program
    {
        static void Main(string[] args)
        {
            byte x = 150;
            byte y = 12;
            byte z;

            try
            {
                z = checked((byte)(x * y));
            }
            catch (OverflowException)
            {
                Console.WriteLine("Przepelnienie");
                Console.ReadLine();
            }
        }
    }
}
