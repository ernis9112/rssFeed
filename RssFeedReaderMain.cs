using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RssFeedReader
{
    class RssFeedReaderMain
    {
        static void Main(string[] args)
        {
            RssReader.readOneFeed("http://www.delfi.lt/rss/feeds/lithuania.xml");
            RssReader.readOneFeed("http://www.15min.lt/rss");

            //stop program for a while
            Console.ReadLine();
        }
    }
}
