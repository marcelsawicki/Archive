using System;
using System.IO;
using System.Net;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {

            WebRequest request = WebRequest.Create("https://programistamag.pl");
            WebResponse response = request.GetResponse();
            Console.WriteLine(((HttpWebResponse)response).StatusDescription);

            using (Stream dataStream = response.GetResponseStream())
            {
                StreamReader reader = new StreamReader(dataStream);
                string responseFromServer = reader.ReadToEnd();
                Console.WriteLine(responseFromServer);
            }
            response.Close();
        }
    }
}
