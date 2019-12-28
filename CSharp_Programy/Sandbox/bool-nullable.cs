namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            bool? test1 = null;
            bool? test2 = false;
            bool? test3 = true;

            if(!test1.HasValue)
            {
                Console.WriteLine("nie ma value");
            }
            

            Console.WriteLine(Convert.ToBoolean(test1));
            Console.WriteLine(Convert.ToBoolean(test2));
            Console.WriteLine(Convert.ToBoolean(test3));

            Console.WriteLine(Convert.ToBoolean(null));
            Console.WriteLine(Convert.ToBoolean(0));
            Console.WriteLine(Convert.ToBoolean(1));
            Console.WriteLine(Convert.ToBoolean(Convert.ToInt32("0")));
            Console.WriteLine(Convert.ToBoolean(Convert.ToInt32("1")));
            Console.ReadKey();
        }
    }
}