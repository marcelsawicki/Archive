using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dependency_injection_1
{
    class Program
    {
        static void Main(string[] args)
        {
            IEmailSender iem = new MyEmailSender();
            PasswordResetHelper pswd = new PasswordResetHelper(iem);
            pswd.ResetPassword();

            IEmailSender iemm = new CustomEmailSender();
            PasswordResetHelper pswdd = new PasswordResetHelper(iemm);
            pswdd.ResetPassword();
            System.Console.ReadKey();
        }
    }
}
