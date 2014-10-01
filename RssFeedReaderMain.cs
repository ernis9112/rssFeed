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

            System.Console.WriteLine(FeedsCounterSingleton.getInstance().getFeeds());

            //Categories
            NewsPerCategoryCounterSingleton.getInstance().addCategory("namai");
            NewsPerCategoryCounterSingleton.getInstance().addCategory("bites");
            NewsPerCategoryCounterSingleton.getInstance().addCategory("bite");
            NewsPerCategoryCounterSingleton.getInstance().addCategory("bite");
            NewsPerCategoryCounterSingleton.getInstance().addCategory("bite");

            var categories = NewsPerCategoryCounterSingleton.getInstance().getCategories();

            System.Console.WriteLine("Categories:");
            foreach (KeyValuePair<string, int> temp in categories)
            {
                System.Console.Write("\"" + temp.Key.ToString() + "\" : " + temp.Value.ToString() + "\n");
            }

            //stop program for a while
            Console.ReadLine();
        }
    }
}
