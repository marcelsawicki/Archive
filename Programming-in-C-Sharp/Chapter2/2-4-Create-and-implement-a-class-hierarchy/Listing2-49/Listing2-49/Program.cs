using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Listing2_49
{
    abstract class Base
    {
        public virtual void MethodWithImplementation()
        {
            Console.WriteLine("Method with implementation.");
        }

        public abstract void AbstractMethod();
    }

    class Derived : Base
    {
        public override void AbstractMethod() { }
    }

    class Program
    {
        static void Main(string[] args)
        {
        }
    }
}
