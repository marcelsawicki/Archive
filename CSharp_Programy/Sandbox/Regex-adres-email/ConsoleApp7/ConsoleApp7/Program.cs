using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace ConsoleApp7
{
    class Program
    {
        static void Main(string[] args)
        {
            Regex regEmail;
            regEmail = new Regex(@"^[a-z][a-z0-9_]*@[a-z0-9]*\.[a-z]{2,3}$");
            Console.WriteLine("Prosze podac adres email: ");

            string napis = Console.ReadLine();

            // Podany przez uzytkownika
            Console.WriteLine(
                String.Format("Podany adres: {0} to {1}poprawny adres e-mail.", napis, regEmail.IsMatch(napis)?"":"nie")
                );
            Console.ReadKey();
        }
    }
}
