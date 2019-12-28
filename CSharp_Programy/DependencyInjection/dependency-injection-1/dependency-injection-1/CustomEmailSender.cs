using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dependency_injection_1
{
    class CustomEmailSender: IEmailSender
    {
        public void SendEmail()
        {
            System.Console.WriteLine("Sending custom...");
        }
    }
}
