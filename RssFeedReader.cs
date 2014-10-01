using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RssFeedReader
{
    class RssFeedReader
    {
        static void Main(string[] args)
        {
            System.Console.WriteLine("Hello, World!");

            FeedsCounterSingleton.getInstance().addFeeds(2);
            FeedsCounterSingleton.getInstance().addFeeds(3);
            FeedsCounterSingleton.getInstance().addFeeds(4);

            var feedsCount = FeedsCounterSingleton.getInstance().getFeeds();
            System.Console.WriteLine(feedsCount);

            Console.ReadLine();
        }
    }
}
