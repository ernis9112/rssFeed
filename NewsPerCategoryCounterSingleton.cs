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

        public void addCategory(string category)
        {
            this.fillCategoryArray(category);
        }

        protected void fillCategoryArray(string category)
        {
            int count;
            if (this.categoriesCounts.TryGetValue(category, out count))
            {
                count++;
                this.categoriesCounts[category] = count;
            }
            else
            {
                this.categoriesCounts.Add(category, 1);
            }
        }

        public Dictionary<string, int> getCategories()
        {
            return categoriesCounts;
        }
    }
}
