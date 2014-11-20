import java.util.LinkedHashMap;


public class RssFeedReaderMain {

	public static void main(String[] args) throws Exception {
		
		//Chain of responsibility and nullObject      
        AbstractLogger chain = new WriteLogger(AbstractLogger.WRITE);
  
        AbstractLogger logger1 = new ReadLogger(AbstractLogger.READ);
        chain.setNext(logger1);
        
        AbstractLogger logger2 = new NullLogger(AbstractLogger.READ);
        chain.setNext(logger2);
        
        //Chain of responsibility end
		
		// Factory----------------------------------------------------
		RssReader reader = null;
		RssReaderFactory readerFactory = new RssReaderFactory();
		reader = readerFactory.createReader("15min");
		
		try {
	         reader.writeFeed("http://www.15min.lt/rss");
	         chain.message("Feed read", AbstractLogger.READ);
	    } catch (Exception e) {  
	         e.printStackTrace();  
	    }
		// Factory end------------------------------------------------
		
		// Strategy---------------------------------------------------
		FilteredFeeds fFeeds = null;
		fFeeds = new FilteredFeeds();
		
		fFeeds.setFilter(new FeedsByCategoryFilter("Futbolas"));		
		fFeeds.executeFiltering();
		chain.message("Feed writed", AbstractLogger.WRITE);
		
		fFeeds.setFilter(new FeedsByAuthorFilter("15min"));		
		fFeeds.executeFiltering();
		chain.message("Feed writed", AbstractLogger.WRITE);
		// Strategy end-----------------------------------------------
		
		NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("namai");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bites");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
        NewsPerCategoryCounterSingleton.getInstance().fillCategoryArray("bite");
    
        // Facade ------------------------------------------------------
        Facade facade = new Facade();        
        LinkedHashMap categories = facade.getNewsPerCategoryCounts();        
        // Facade end---------------------------------------------------
	}
}
