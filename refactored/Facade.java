import java.util.LinkedHashMap;

public class Facade {
	
   private NewsPerCategoryCounterSingleton counter;
   private Logger logger;
  
   public Facade() {
	   counter = NewsPerCategoryCounterSingleton.getInstance();
	   logger = Logger.getInstance();
   }
   
   public LinkedHashMap getNewsPerCategoryCounts() {
	   LinkedHashMap categories = counter.getCategories();
	   logger.addLog("categories taken");

	   return categories;
   }
}  
