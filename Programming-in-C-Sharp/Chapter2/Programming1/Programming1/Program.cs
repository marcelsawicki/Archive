using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Programming1
{
    interface IAnimal
    {
        void Move();
    }

    class Dog : IAnimal
    {
        public void Move() { Console.WriteLine("Move animal.");  }
        public void Bark() { Console.WriteLine("Bark.");  }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Dog pies = new Dog();
            MoveAnimal(pies);
            Console.WriteLine("Press <SPACE> to continue.");
            Console.ReadKey();
            
        }

        static void MoveAnimal(IAnimal animal)
        {
            animal.Move();
        }
    }
}
