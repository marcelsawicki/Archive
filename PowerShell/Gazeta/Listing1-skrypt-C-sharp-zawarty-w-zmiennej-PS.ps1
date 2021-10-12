# Główny skrypt w C# zawarty w zmiennej PS
$script=@"
using System;
using System.IO;
using System.Net;

namespace Example
{
    public class WebRequestGet
    {
        public static void Main()
        {
            WebRequest request = WebRequest.Create("https://programistamag.pl");
            WebResponse response = request.GetResponse();
            Console.WriteLine(((HttpWebResponse)response).StatusDescription);

            using(Stream dataStream = response.GetResponseStream())
            {
                StreamReader reader = new StreamReader(dataStream);
                string responseFromServer = reader.ReadToEnd();
                Console.WriteLine(responseFromServer);
            }
            response.Close();
        }
    }
}
"@
# Dodanie typu dla zmiennej przetrzymującej skrypt w C#
Add-Type -TypeDefinition $script -Language CSharp

#Wywołanie skryptu C#
[Example.WebRequestGet]::Main()