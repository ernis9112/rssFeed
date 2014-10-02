using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace RssFeedReader
{
    public class RssReaderDelfi
    {

        public static void readOneFeed(string url)
        {

            StringBuilder output = new StringBuilder();
            using (XmlReader reader = XmlReader.Create(url))
            {
                while (reader.Read())
                {
                    if (reader.IsStartElement())
                    {
                        if (!reader.IsEmptyElement)
                        {

                            //will be some code for feed data saving
                            reader.ReadToFollowing("item");
                            FeedsCounterSingleton.getInstance().addFeeds(1);
                        }
                    }
                }
            }
            Logger.getInstance().addLog("Nuskaitytas naujas rss is url:" + url);
        }

    }
}
