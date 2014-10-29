import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class RssFeedReaderMain {

	public static void main(String[] args) {
		
		// Factory----------------------------------------------------
		RssReader reader = null;
		RssReaderFactory readerFactory = new RssReaderFactory();
		reader = readerFactory.createReader("15min");
		
		try {
	         reader.writeFeed("http://www.15min.lt/rss");  
	    } catch (Exception e) {  
	         e.printStackTrace();  
	    }
		// Factory end------------------------------------------------
		
		// Strategy---------------------------------------------------
		FilteredFeeds fFeeds = null;
		fFeeds = new FilteredFeeds(new FeedsByCategoryFilter("Futbolas"));
		fFeeds.executeFiltering();
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
        
        // Abstract factory---------------------------------------------
        ReaderFactory fac1 = new LithuanianReaderFactory();
        Reader read1 = fac1.createReader("15min");
        read1.writeFeed("http://www.15min.lt/rss");
        
        ReaderFactory fac2 = new ForeignReaderFactory();
        Reader read2 = fac2.createReader("guardian");
        read2.writeFeed("http://www.15min.lt/rss");
        // Abstract factory end ----------------------------------------

	}

}
