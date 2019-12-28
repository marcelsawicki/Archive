using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleApp6Mutex
{
    class Program
    {
        private readonly string MUTEX_GUID = "e1ffff8f-c91d-4188-9e82-c92ca5b1d057";
        private readonly Mutex m_oLoggerMutex = null;
        static void Main(string[] args)
        {
            Program.Log();
        }

        public Program()
        {
            m_oLoggerMutex = new Mutex(false, MUTEX_GUID);
        }

        public void Log()
        {
            m_oLoggerMutex.WaitOne();
            {
                StreamWriter oFile = null;
                try
                {
                    oFile = File.AppendText("E:\\logger.txt");
                    oFile.WriteLine("Przykładowa linia...");
                    oFile.Flush();
                }
                finally
                {
                    if (null != oFile)
                    {
                        oFile.Close();
                        oFile.Dispose();
                    }
                }
            }
            m_oLoggerMutex.ReleaseMutex();
        }
    }
}
