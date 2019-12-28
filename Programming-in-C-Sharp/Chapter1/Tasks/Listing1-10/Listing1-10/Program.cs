﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listing1_10
{
    class Program
    {
        static void Main(string[] args)
        {
            Task<int> t = Task.Run(() => 
            {
                return 42;
            }).ContinueWith((i)=> 
            {
                return i.Result * 2;
            });

            Console.WriteLine(t.Result); // Displays 84

            Console.ReadKey();
        }
    }
}
