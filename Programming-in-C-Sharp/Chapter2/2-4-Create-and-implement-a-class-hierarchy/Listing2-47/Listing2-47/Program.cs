using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listing2_47
{
    class Base
    {
        protected virtual void Execute()
        { }
    }

    class Derived : Base
    {

        protected override void Execute()
        {
            Log("Before executing");
            base.Execute();
            Log("After executing");
        }

        private void Log(string message)
        {
            System.Console.WriteLine(message);
        }

        public void Start()
        {
            Execute();
        }

    }

    class Program
    {
        static void Main(string[] args)
        {
            Derived d = new Derived();
            d.Start();

            Console.ReadKey();
        }
    }
}
