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
            RssReader.readOneFeed("http://www.delfi.lt/rss/feeds/lithuania.xml");            
            RssReader.readOneFeed("http://www.15min.lt/rss");

            Logger.getInstance().addLog("Nuskaitytas irasu kiekis: " + FeedsCounterSingleton.getInstance().getFeeds());

            //Categories
            NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("namai");
            NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bites");
            NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
            NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
            NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");

            var categories = NewsPerCategoryCounterSingleton.getInstance().getCategories();

            System.Console.WriteLine("Categories:");
            foreach (KeyValuePair<string, int> temp in categories)
            {
                System.Console.Write("\"" + temp.Key.ToString() + "\" : " + temp.Value.ToString() + "\n");
            }
        
            Console.ReadLine();
        }
    }
}
