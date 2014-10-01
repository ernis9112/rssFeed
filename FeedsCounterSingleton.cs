using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RssFeedReader
{
    public class FeedsCounterSingleton
    {
        private static FeedsCounterSingleton instance = null;
        private int feedsCount = 0;

        private FeedsCounterSingleton()
        {
        }

        public static FeedsCounterSingleton getInstance()
        {
            if (instance == null)
            {
                instance = new FeedsCounterSingleton();
            }
            return instance;
        }

        public void addFeeds(int feeds)
        {
            feedsCount += feeds;
        }


        public int getFeeds()
        {
            return feedsCount;
        }
    }
}
