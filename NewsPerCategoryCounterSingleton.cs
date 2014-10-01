using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RssFeedReader
{
    public class NewsPerCategoryCounterSingleton
    {
        private static NewsPerCategoryCounterSingleton instance = null;

        Dictionary<string, int> categoriesCounts = new Dictionary<string, int>(); 

        private string category = "";
        private string title = "";

        private NewsPerCategoryCounterSingleton()
        {
        }

        public static NewsPerCategoryCounterSingleton getInstance()
        {
            if (instance == null)
            {
                instance = new NewsPerCategoryCounterSingleton();
            }
            return instance;
        }

        public void addCategoryAndTitle(string category, string title)
        {
            this.category = category;
            this.title = title;

            this.fillCategoryArray();
        }

        protected void fillCategoryArray()
        {
            int count;
            if (this.categoriesCounts.TryGetValue(this.category, out count))
            {
                count++;
                this.categoriesCounts[this.category] = count;
            }
            else
            {
                this.categoriesCounts.Add(this.category, 1);
            }
        }

        public Dictionary<string, int> getCategories()
        {
            return categoriesCounts;
        }
    }
}
