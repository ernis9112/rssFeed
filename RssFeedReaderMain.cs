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
            NewsPerCategoryCounterSingleton.getInstance().addCategoryAndTitle("namai", "siandien kazkas tipo ale atsitiko");
            NewsPerCategoryCounterSingleton.getInstance().addCategoryAndTitle("bites", "nieko naujo");
            NewsPerCategoryCounterSingleton.getInstance().addCategoryAndTitle("bite", "nieko naujo");
            NewsPerCategoryCounterSingleton.getInstance().addCategoryAndTitle("bite", "nieko naujo");
            NewsPerCategoryCounterSingleton.getInstance().addCategoryAndTitle("bite", "nieko naujo");

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
