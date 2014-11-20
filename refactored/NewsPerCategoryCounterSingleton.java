import java.util.LinkedHashMap;


public class NewsPerCategoryCounterSingleton {
	
	private static NewsPerCategoryCounterSingleton instance = null;

    private LinkedHashMap categoriesCounts = new LinkedHashMap();


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

    public void fillCategoryArray(String category)
    {
    	if(categoriesCounts.containsKey(category)) {
    		Integer val = (Integer) categoriesCounts.get(category);
    		categoriesCounts.put(category, val + 1);
    	} else {
    		categoriesCounts.put(category, 1);
    		Logger.getInstance().addLog("Skaiciujant prideta nauja kategorija: " + category);
    	}
    	
    }

    public LinkedHashMap getCategories()
    {
        return categoriesCounts;
    }

}
