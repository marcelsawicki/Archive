using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class Delegat
    {
        public delegate int Delegat1(int arg1, int arg2);

        public int Dodawanie(int arg1, int arg2)
        {
            return arg1 + arg2;
        }

        public int Odejmowanie(int arg1, int arg2)
        {
            return arg1 - arg2;
        }
    }
}
