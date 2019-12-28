using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace dependency_injection_1
{
    public class PasswordResetHelper
    {
        private IEmailSender emailSender;

        public PasswordResetHelper(IEmailSender emailSenderParam)
        {
            emailSender = emailSenderParam;
        }

        public void ResetPassword()
        {
            emailSender.SendEmail();
            // IEmailSender mySender = new MyEmailSender();
            // mySender.SendEmail();
        }
        
    }
}
