using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RssFeedReader
{
    public class Logger
    {
        private static Logger instance = null;
        List<string> logMessages = new List<string>();

        private Logger()
        {
        }

        public static Logger getInstance()
        {
            if (instance == null)
            {
                instance = new Logger();
            }
            return instance;
        }

        public void addLog(string log)
        {
            logMessages.Add(log);
        }

        public List<string> getLogMessages()
        {
            return logMessages;
        }
    }
}
